package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.util.DTO;

@WebServlet("/api/ajax2")
public class Ajax2Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ajax2 post 요청");
		
		Map<String, String> requestMap = DTO.getParams(request);

		response.setContentType("text/plain; charser=utf8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(requestMap.get("address1")+" "+requestMap.get("address2")+" "+
										requestMap.get("address3"));
	}

}
