package com.study.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/api/form/1")
public class FormAPI1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("get 요청");	
		
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("user_name"));
		System.out.println(session.getAttribute("user_phone"));
		System.out.println(session.getAttribute("user_email"));
		System.out.println(session.getAttribute("user_address"));
		System.out.println(session.getAttribute("user_password"));
		
		request.getRequestDispatcher("/WEB-INF/form1.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("post 요청");
		
//		request.setCharacterEncoding("UTF-8");
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("phone"));
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("address"));
//		System.out.println(request.getParameter("pw"));
		
//		response.setContentType("text/plain; charset=utf8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
//		PrintWriter out = response.getWriter();
		
		session.setAttribute("user_name", request.getParameter("name"));
		session.setAttribute("user_phone", request.getParameter("phone"));
		session.setAttribute("user_email", request.getParameter("email"));
		session.setAttribute("user_address", request.getParameter("address"));
		session.setAttribute("user_password", request.getParameter("pw"));
		
//		request.getParameter("name");
//		request.getParameter("phone");
//		request.getParameter("email");
//		request.getParameter("address");
//		request.getParameter("pw");
	}
}
