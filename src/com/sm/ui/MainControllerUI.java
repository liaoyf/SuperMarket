package com.sm.ui;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.mybatis.mb.Staff;

@Controller
public class MainControllerUI {
	@RequestMapping("/main")
	//登陆的界面展示
	public String initAddEditJsp(HttpSession ss){
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		if (null == staff)
			{
			return "redirect:/admin";}
		return "/BgMain";	
	}
}
