package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sm.Paging;
import com.sm.mybatis.mb.*;

;

@Controller
public class StaffControllerUI {

	@Autowired
	private StaffMapper dao;

	@Autowired
	private RoleMapper roledao;
	@Autowired
	private LPRoleMapper LPdao;

	@RequestMapping("/main/staffs")
	public String search(Integer mes,HttpSession ss, Integer staffId, String staffName,
			Integer pageNum, ModelMap mm) throws UnsupportedEncodingException {
		// 只有拥有此权限的才可以进入

		if (null != mes && 1 == mes)
			mm.addAttribute("msg", "新增成功！");
		else if (null != mes && 2 == mes)
			mm.addAttribute("msg", "修改成功！");
		else if (null != mes && 3 == mes)
			mm.addAttribute("msg", "刪除成功！");
		
		Map<String, Object> params = new HashMap<String, Object>();
		System.out.println(staffName);
		Paging page = new Paging();
		page.setPageSize(2);
		if (null == pageNum) {
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}
		params.put("staffName", staffName);
		params.put("staffId", staffId);
		
		long count = dao.selectCountByStaff(params);

		page.setTotalCount(count);
		params.put("page", page);

		System.out.println("页的大小" + page.getPageSize());

		System.out.println("总页数" + page.getTotalPage());

		System.out.println("总计记录数" + page.getTotalCount());
		
		mm.addAttribute("staffId", staffId);
		mm.addAttribute("staffName",staffName);
		
		
		List<Staff> rs = dao.selectOnceByMap(params);
		mm.addAttribute("staffs", rs);
		mm.addAttribute("page", page);
		return "/staff";
	}

	// 初始化，新增/修改操作前置的JSP视图
	@RequestMapping({ "/main/staffs/add", "/main/staffs/edit" })
	public String initAddEditJsp( HttpSession ss,Integer staffId, ModelMap mm) {
		//既没有增加的权限也没有修改的权限
		if(check(ss,1)&&check(ss,2))
			return "/err";
		if (null != staffId) {
					Staff staff = dao.selectByPrimaryKey(staffId);
					mm.addAttribute("staff", staff);}
				RoleExample re=new RoleExample();
				String name = "%";			
				re.createCriteria().andRoleNameLike(name);
				List<Role> role=new ArrayList<Role>();
				role=roledao.selectByExample(re);
				mm.addAttribute("role", role);

				// 请求转发到JSP
				return "/staffCU";
	}

	// 新增，操作完成后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/staffs/add/handler")
	public String add(Staff dto) {
		System.out.println("做了新增动作");
		dao.insert(dto);
		return "redirect:../../staffs?mes=1";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/staffs/edit/handler")
	public String edit(Staff dto) {
		System.out.println("做了编辑动作");
		dao.updateByPrimaryKey(dto);
		return "redirect:../../staffs?mes=2";
	}

	@RequestMapping("/main/staffs/del")
	public String del(HttpSession ss,Integer staffId) {
		if(check(ss,2)){
			return "/err";
		}else{
			System.out.println("做了删除动作");
			dao.deleteByPrimaryKey(staffId);
			return "redirect:../staffs?mes=3";
		}
		
	}

	public boolean check(HttpSession ss, Integer limit) {
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		LPRoleExample e = new LPRoleExample();
		// //System.out.println(staff.getStaffName());
		Integer staffRoleId = staff.getRoleId();
		e.createCriteria().andRoleIdEqualTo(staffRoleId);
		List<LPRoleKey> lpRoleKeys = LPdao.selectByExample(e);

		for (LPRoleKey i : lpRoleKeys) {
			if (i.getLpId() == limit) {
				return false;
			}
		}
		return true;

	}
}
