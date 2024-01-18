package com.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AbcFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Abc 필터 초기화");		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Abc 필터에 요청이 들어옴");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response); //필터 통과시켜주기
		
	}

	@Override
	public void destroy() {
		System.out.println("Abc 필터 파괴");		
		
	}

}
