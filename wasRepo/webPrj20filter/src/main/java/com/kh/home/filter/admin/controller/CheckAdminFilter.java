package com.kh.home.filter.admin.controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/admin/*") //특정 URL은 다르게 설계해서 필터에 안 걸리게 작업하기 *임시방편 추후에 배울 예정
public class CheckAdminFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		
		//null이면 에러 페이지 이동
		if(req.getSession().getAttribute("adminInfo") == null) {
			req.getRequestDispatcher("errorPage~~~").forward(request, response);
			
		}else{
			//다음 단계 진행
			chain.doFilter(request, response);
		}
	}
}
