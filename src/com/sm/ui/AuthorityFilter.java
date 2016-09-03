package com.sm.ui;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sm.mybatis.mb.Staff;

public class AuthorityFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain fc) throws IOException, ServletException {
		if (req instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpSession ss = request.getSession();
			Staff staffDto = (Staff) ss
					.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
			if (null == staffDto) {
				((HttpServletResponse) resp).sendRedirect(request
						.getContextPath() + "/admin/");
				return;
			}
		} else {
			System.out.println("这不是我该处理的HTTP请求");
		}

		fc.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
