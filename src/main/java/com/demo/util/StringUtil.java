package com.demo.util;

public class StringUtil {
	
	public static String LineToBr(String content) {
		return content.replaceAll("\r\n", "<br/>");
	}
	
	public static String getExtension(String fileName) {
		if(fileName == null || fileName.equals("")) {
			return "";
		}
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}

}
