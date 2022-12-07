package com.study.servlet.ajax;

public class StringBuilderTest {
	public static void main(String[] args) {
		String str = "문자열1";
		str += "문자열2";
		str.replaceAll("문자열2", "문자열3");
		
		System.out.println(str);
		
		// 메모리주소가 변하지 않음! 기본 16 -> 32 Byte ( char = 2byte 이기 때문에 ) 
		// int capacity 가 크기에 맞게 늘어날 수 있음. 
		StringBuilder builder = new StringBuilder();  // 비동기 -> 굳이 thread가 아니어도 되는 경우 
		
		StringBuffer  buffer = new StringBuffer();  // 동기 -> thread 환경에서 써야함 
	}

}
