package com.study.servlet.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.util.DTO;

@WebServlet("/auth/login")
public class LoginApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println(DTO.getParams(request));
		
//		Map<String, String> dataMap = new HashMap<>();
//		
//		Set<String> KeySet = request.getParameterMap().keySet();
//		KeySet.forEach(key -> {
//			dataMap.put(key,  request.getParameter(key));
//		});
//		
//		System.out.println(dataMap);
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		System.out.println(username);
//		System.out.println(password);
	}

}



