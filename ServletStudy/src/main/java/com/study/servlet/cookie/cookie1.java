package com.study.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/1")
public class cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("data1","쿠키저장"); // 쿠키에 띄어쓰기 쓸수없음 ex) 쿠키 저장 -> 오류 	
		cookie.setMaxAge(60 * 60);
		
		Cookie cookie2 = new Cookie("data2","쿠키저장2");
		cookie2.setMaxAge(60 * 60);
		
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
	}

}