package com.ducat.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
 
	private final String PUBLIC_URLS[]= { "/","login.jsp","/LoginHandler","register.jsp","index.jsp","phone.jsp","tablet.jsp","laptop.jsp","/RegisterController"};
	private static final long serialVersionUID = 1L;
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthFilter initialized !");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filtering ......");
		
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		boolean isLoggedIn =(session!=null && session.getAttribute("user") !=null);
		boolean isPublicResource = req.getRequestURI().endsWith(".css") || req.getRequestURI().endsWith(".js") || req.getRequestURI().endsWith(".svg");
		boolean isAuthenticated =false;
		for(String uri : PUBLIC_URLS) {
		if(req.getRequestURI().endsWith(uri) || isLoggedIn || isPublicResource)
			{
				isAuthenticated =true;
				chain.doFilter(request, response);
				break;
			}
		} 
		
		if(!isAuthenticated) {
			req.setAttribute("msg","pls login first");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}

	public void destroy() {
		System.out.println("filter destroyed !");
	}
}
