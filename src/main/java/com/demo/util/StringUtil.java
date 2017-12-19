package com.demo.util;

public class StringUtil {
	
	public static String LineToBr(String content) {
		if(content == null) return "";
		return content.replaceAll("\r\n", "<br/>");
	}
	
	public static String getExtension(String fileName) {
		if(fileName == null || fileName.equals("")) {
			return "";
		}
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	
	public static String nvl(String str) {
		if(str == null) return "";
		return str;
	}
	
	public static String nvl(String str, String defaultStr) {
		if(str == null) return defaultStr;
		return str;
	}

}
