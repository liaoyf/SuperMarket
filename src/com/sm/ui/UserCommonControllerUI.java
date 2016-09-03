package com.sm.ui;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;

import com.sm.mybatis.mb.Staff;
import com.sm.mybatis.mb.StaffExample;
import com.sm.mybatis.mb.StaffMapper;

@Controller
public class UserCommonControllerUI {
	@RequestMapping("/admin")
	// 首页，也是登录初始化页
	public String index(Integer err, ModelMap mm) {
		if (null != err && 1 == err)
			mm.addAttribute("msg", "用户名或密码为空");
		else if (null != err && 2 == err)
			mm.addAttribute("msg", "用户名或密码不正确");
		System.out.println("哈哈");
		return "/BgLogin";
	}

	@Autowired
	private StaffMapper staffDao;
	// 登录处理
	@RequestMapping("/login")
	public String login(String staffName, String password, HttpSession session) {
		// 员工
		System.out.println("heh");
		if (null == staffName || null == password || //
				"".equals(staffName.trim()) || //
				"".equals(password.trim())) {
			// 用户名或密码为空
			return "redirect:/admin";
		} else {
			StaffExample staffem = new StaffExample();
			staffem.createCriteria().andStaffNameEqualTo(staffName)
					.andPasswordEqualTo(password);
			List<Staff> queryStaff = staffDao.selectByExample(staffem);
			if (null == queryStaff || queryStaff.size() != 1) {
				// 员工的用户名或密码不正确
				return "redirect:/admin/?err=2";
			} else {
				// 验证正确状态
				Staff staff = queryStaff.get(0);
				System.out.println("登陆成功");
				session.setAttribute(Flags.SESSION_USER_LOGIN_FLAG, staff);
				// 记录在线的用户数量
				Integer count = (Integer) session.getServletContext()
						.getAttribute(Flags.APPLICATION_VIP_COUNT_FLAG);
				if (count == null) {
					count = 0;
					session.getServletContext().setAttribute(
							Flags.APPLICATION_VIP_COUNT_FLAG, count);
				} else {
					count++;
					session.getServletContext().setAttribute(
							Flags.APPLICATION_VIP_COUNT_FLAG, count);
				}
				// 请求重定向(redirect:URL地址)
				return "redirect:main";
			}
		}
	}
	/*
	 * 修改成功
	 */
	@RequestMapping("/changePassword")
	public String changeSuccess(HttpSession ss,String userpassword){
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		//重定向至登陆页面
		staff.setPassword(userpassword);
		staffDao.updateByPrimaryKey(staff);
		return "redirect:/admin";
	}
	/*
	 * 退出登录
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession s) {
		System.out.println("登出系统");
		s.invalidate();
		return "redirect:/admin";
	}
}
