package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class Address{
	private String address1;
	private String address2;
	private String address3;
}

@WebServlet("/api/ajax2")
public class Ajax2Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Ajax2 post 요청");
		
//		Map<String, String> requestMap = DTO.getParams(request);
		String jsonData = request.getParameter("jsonData");
		
		System.out.println(jsonData);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Map<String, Object> addressMap = gson.fromJson(jsonData, Map.class);
		
		Address address = gson.fromJson(jsonData, Address.class);
		System.out.println(addressMap.get("address1"));
		System.out.println(address);
		
		Address address2 = Address.builder()
				.address1("부산광역시")
				.address2("부산 진구")
				.address3("삼정타워")
				.build();
		
		String responseJson = gson.toJson(address2);
		
//		System.out.println(addressMap);

		response.setContentType("text/plain; charser=utf8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(responseJson);
//		out.print(requestMap.get("address1")+" "+requestMap.get("address2")+" "+
//										requestMap.get("address3"));
	}

}
