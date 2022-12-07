package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/api/ajax3")
public class Ajax3Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonData = request.getParameter("data");
		Map<String, Object> dataMap = gson.fromJson(jsonData, Map.class);
//		List<String> phoneNumbers = new ArrayList<>();
//		
//		dataMap.forEach((key, value)->{
//			// string 이면 넣도록
//			if(value.getClass() == String.class) {
//			phoneNumbers.add((String)value);
//			}
//		});
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		StringBuilder stringBuilder = new StringBuilder();
		dataMap.forEach((key, value)->{			
			stringBuilder.append(value);
			stringBuilder.append("-");
			
		});
		stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
		out.print(stringBuilder.toString());
	}

}
