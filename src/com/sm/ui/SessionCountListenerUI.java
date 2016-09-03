package com.sm.ui;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCountListenerUI implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session创建");
		// 记录在线人数
		ServletContext application = se.getSession().getServletContext();
		Object o = application.getAttribute(Flags.APPLICATION_USER_COUNT_FLAG);
		if (null == o)
			{application.setAttribute(Flags.APPLICATION_USER_COUNT_FLAG, 1);}
		else {
			Integer count = (Integer) o;
			count++;
			application.setAttribute(Flags.APPLICATION_USER_COUNT_FLAG, count);
		}
		// 初始化在线的注册用户数
		Object ovip = application
				.getAttribute(Flags.APPLICATION_VIP_COUNT_FLAG);
		if (null == ovip)
			application.setAttribute(Flags.APPLICATION_VIP_COUNT_FLAG, 0);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session清理");
		// 清理在线人数
		ServletContext application = se.getSession().getServletContext();
		Integer count = (Integer) application
				.getAttribute(Flags.APPLICATION_USER_COUNT_FLAG);
		count--;
		application.setAttribute(Flags.APPLICATION_USER_COUNT_FLAG, count);
		// 清理在线的注册用户人数
		count = (Integer) application
				.getAttribute(Flags.APPLICATION_VIP_COUNT_FLAG);
		count--;
		application.setAttribute(Flags.APPLICATION_VIP_COUNT_FLAG, count);
	}

}
