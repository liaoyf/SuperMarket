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
import com.sm.mybatis.mb.*;;


@Controller
public class RoleControllerUI {

	@Autowired
	private RoleMapper roledao;

	@Autowired
	private LPRoleMapper LPdao;

	@Autowired
	private LimitPowerMapper lpdao;

	// 初始化角色页面
	@RequestMapping("/main/roles")
	public String search(Integer mes,HttpSession ss,Integer roleId, ModelMap mm,Integer pageNum)
			throws UnsupportedEncodingException {
		if (check(ss,23))
			return "/err";
		if (null != mes && 1 == mes)
			mm.addAttribute("msg", "新增成功！");
		else if (null != mes && 2 == mes)
			mm.addAttribute("msg", "修改成功！");
		else if (null != mes && 3 == mes)
			mm.addAttribute("msg", "刪除成功！");
		else if (null != mes && 4 == mes)
			mm.addAttribute("msg", "授权成功！");
		RoleExample re = new RoleExample();
		re.createCriteria().andRoleNameLike("%");
		
		//查询到的记录数
		long count=roledao.countByExample(re);
		Paging page = new Paging();
		page.setPageSize(4);
		if (null == pageNum) {
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}
		page.setTotalCount(count);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		List<Role> rs = roledao.selectAllByRole(params);
		System.out.println("页的大小" + page.getPageSize());

		System.out.println("总页数" + page.getTotalPage());

		System.out.println("总计记录数" + page.getTotalCount());
		mm.addAttribute("role", rs);
		mm.addAttribute("page", page);
		return "/role";
		}

	// 初始化，新增/修改操作前置的JSP视图
	@RequestMapping({ "/main/roles/add", "/main/roles/edit" })
	public String initAddEditJsp(Integer roleId, ModelMap mm) {
		if (null != roleId) {
			Role role = roledao.selectByPrimaryKey(roleId);
			mm.addAttribute("role", role);
		}

		// 请求转发到JSP
		return "/roleCU";

	}

	// 授权初始化页面
	@RequestMapping("/main/roles/limits")
	public String RolelimitJsp(Integer roleId, ModelMap mm) {
		if (null != roleId) {
			// 通过角色ID求角色权限表
			Role role = roledao.selectByPrimaryKey(roleId);

			System.out.println("当前角色" + roleId);
			mm.addAttribute("role", role);
			LPRoleExample lprex = new LPRoleExample();
			lprex.createCriteria().andRoleIdEqualTo(roleId);
			List<LPRoleKey> lprole = LPdao.selectByExample(lprex);
			System.out.println("查询到的权限列表大小" + lprole.size());
			mm.addAttribute("lPRole", lprole);
		}
		LimitPowerExample lpex = new LimitPowerExample();
		lpex.createCriteria().andLPNameLike("%");
		List<LimitPower> rs = lpdao.selectByExample(lpex);
		int count =lpdao.countByExample(lpex);
		mm.addAttribute("count", count+1);
		mm.addAttribute("limit", rs);
		// 请求转发到JSP
		return "/rolelimit";

	}

	// 授权保存后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/roles/limits/edit")
	public String save(int[] lpr, Integer roleId, ModelMap mm) {
		System.out.println("做了角色授权动作");
		if (lpr != null) {
			LPRoleKey key = new LPRoleKey();
			key.setRoleId(roleId);
			LPdao.deleteByPrimaryKey(key);

			LPRoleKey lpk = new LPRoleKey();
			for (int i = 0; i < lpr.length; i++) {
				lpk.setRoleId(roleId);
				System.out.println("当前角色" + roleId);
				lpk.setLpId(lpr[i]);
				System.out.println("权限" + lpr[i]);
				LPdao.insert(lpk);
			}
		}
		return "redirect:/main/roles?mes=4";
	}
	// 新增，操作完成后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/roles/add/handler")
	public String add(Role dto) {
		
		System.out.println("做了新增动作");
		roledao.insert(dto);
		return "redirect:../../roles?mes=1";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/roles/edit/handler")
	public String edit(Role dto) {
		System.out.println("做了编辑动作");
		roledao.updateByPrimaryKey(dto);
		return "redirect:../../roles?mes=2";
	}

	@RequestMapping("/main/roles/del")
	public String del(Integer roleId) {
		System.out.println("做了删除动作");
		roledao.deleteByPrimaryKey(roleId);
		return "redirect:../roles?mes=3";
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
