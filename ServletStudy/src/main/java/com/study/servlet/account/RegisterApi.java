package com.study.servlet.account;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.User;
import com.study.repository.UserRepository;
import com.study.service.AccountService;
import com.study.util.DTO;

@WebServlet("/auth/register")
public class RegisterApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(DTO.getParams(request));
		
		Map<String, String> registerParams = DTO.getParams(request);
		
		if(AccountService.getInstance().idDuplicateUsername(registerParams.get("username"))) {
			System.out.println("아이디 중복");
		}else {
			System.out.println("가입 가능");
			User user = User.builder()
					.username(registerParams.get("username"))
					.password(registerParams.get("password"))
					.name(registerParams.get("name"))
					.email(registerParams.get("email"))
					.build();
			UserRepository.getInstance().saveUser(user);
		}
	}

}
