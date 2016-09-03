package com.sm.ui;

import java.io.UnsupportedEncodingException;
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

@Controller
public class LimitControllerUI {
	@Autowired
	private LimitPowerMapper limitdao;
	@Autowired
	private LPRoleMapper LPdao;
	// 初始化权限页面
	@RequestMapping("/main/limits")
	public String search( Integer mes,HttpSession ss,Integer pageNum, Integer limitId, ModelMap mm)
			throws UnsupportedEncodingException {
		//只有拥有此权限的员工才可进入
		if (check(ss,22))
			return "/err";
		
		if (null != mes && 1 == mes)
			mm.addAttribute("msg", "新增成功！");
		else if (null != mes && 2 == mes)
			mm.addAttribute("msg", "修改成功！");
		else if (null != mes && 3 == mes)
			mm.addAttribute("msg", "刪除成功！");

		
		LimitPowerExample lpe = new LimitPowerExample();
		lpe.createCriteria().andLPNameLike("%");
		// 进行分页计算
		Paging page = new Paging();
		page.setPageSize(5);
		if (null == pageNum) {
			pageNum = 1;
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}
		// 查询到的数量
		long count = limitdao.countByExample(lpe);
		page.setTotalCount(count);	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		System.out.println("页的大小" + page.getPageSize());

		System.out.println("总页数" + page.getTotalPage());

		System.out.println("总计记录数" + page.getTotalCount());
		List<LimitPower> rs = limitdao.selectAllByLimit(params);
		mm.addAttribute("limit", rs);
		mm.addAttribute("page", page);

		return "/limit";
		}

	// 初始化，新增/修改操作前置的JSP视图
	@RequestMapping({ "/main/limits/add", "/main/limits/edit" })
	public String initAddEditJsp(Integer lPId, ModelMap mm) {
		if (null != lPId) {
			LimitPower limit = limitdao.selectByPrimaryKey(lPId);
			mm.addAttribute("limit", limit);
		}

		// 请求转发到JSP
		return "/limitCU";

	}

	// 新增，操作完成后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/limits/add/handler")
	public String add(LimitPower dto) {
		System.out.println("做了新增动作");
		limitdao.insert(dto);
		return "redirect:../../limits?mes=1";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/limits/edit/handler")
	public String edit(LimitPower dto) {
		System.out.println("做了编辑动作");
		limitdao.updateByPrimaryKey(dto);
		return "redirect:../../limits?mes=2";
	}

	@RequestMapping("/main/limits/del")
	public String del(Integer lPId) {
		System.out.println("做了删除动作");
		limitdao.deleteByPrimaryKey(lPId);
		return "redirect:../limits?mes=3";
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
