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
import javax.servlet.http.HttpSession;

import com.study.domain.User;
import com.study.service.AccountService;
import com.study.util.DTO;

@WebServlet("/auth/login")
public class LoginApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> loginUser = DTO.getParams(request);
		AccountService accountService = AccountService.getInstance();
		
		User user = accountService.loadUserByUsername(loginUser.get("username"));
		
		if(user == null) {
			System.out.println("아이디 틀림");
			// error_login.html -> script : 사용자 정보를 확인해 주세요. history.back(); -> 다시 로그인창으로
			request.getRequestDispatcher("/WEB-INF/account/error_login.html").forward(request, response);
			return;
		}
		
		if(!accountService.cheackPassword(user, loginUser.get("password"))) {
			System.out.println("비밀번호 틀림");
			// error_login.html -> script : 사용자 정보를 확인해 주세요. history.back(); -> 다시 로그인창으로
			request.getRequestDispatcher("/WEB-INF/account/error_login.html").forward(request, response);
			return;
		}
		
		// 로그인 성공! -> session 에 데이터 들어가야함 !  
		HttpSession session = request.getSession();
		session.setAttribute("princial", user);
		
		response.sendRedirect("/mypage");
		
//		System.out.println(DTO.getParams(request));
		
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



