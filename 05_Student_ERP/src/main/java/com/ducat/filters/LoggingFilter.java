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

import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req =(HttpServletRequest)request;
//		String url = req.getContextPath()+req.getRequestURI();  //getContextPath gives the name of the project or base url and getRequestURI gives the path of the requested url it include base url and requested url
		System.out.println("user requested for : "+req.getRequestURL());  //getRequestURL gives the full url of the page include localhost
		chain.doFilter(request, response);
		System.out.println("sending response from :"+req.getRequestURL());
	}

}
