package com.demo.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface FileController {
	public void singleFileUpload(MultipartFile file) throws IOException;
	public void multiFileUpload(MultipartFile file) throws IOException;
	public void fileDownload(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
