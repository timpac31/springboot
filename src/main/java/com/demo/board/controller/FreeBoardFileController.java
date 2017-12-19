package com.demo.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.SizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.demo.common.FileController;
import com.demo.exception.InvalidFileException;

@Controller
public class FreeBoardFileController implements FileController {
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardFileController.class);
	
	private static final String FILE_PATH = "D:\\file\\";
	
	/** 허용 확장자, 파일 크기 제한 검증 */
	private void Validate(MultipartFile file) {
		boolean valid = false;
		String[] allowedExtention = {"ai","bmp","jpg","jpeg","png","gif","doc","hwp","mp3","pcx","pdf","ppf","ppt","psd","text","txt","wmv","xls","zip"};
		String filename = file.getOriginalFilename();
		String extention = filename.substring(filename.lastIndexOf(".") + 1);
		for(int i=0; i<allowedExtention.length; i++){
			if(allowedExtention[i].equalsIgnoreCase(extention))
				valid = true;
		}
		
		if(!valid) {
			throw new InvalidFileException("허용되지 않은 파일이 첨부되었습니다.");
		}
		
		int maxSize = 30 * 1024 * 1024;
		if(file.getSize() > maxSize) {
			throw new InvalidFileException("파일 크기 제한(30M) 초과");
		}
	}
	
	@Override
	public void singleFileUpload(MultipartFile file) {
		Validate(file);		
		try {
			Files.createDirectories(Paths.get(FILE_PATH));
	        Files.write(Paths.get(FILE_PATH + file.getOriginalFilename()),  file.getBytes());
		}catch (IOException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	@Override
	public void multiFileUpload(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	@RequestMapping(value="/board/download.do", method = RequestMethod.GET)
	public void fileDownload(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String filename = req.getParameter("filename");
		String fullPath = FILE_PATH + filename;

		File file = new File(fullPath);
		FileInputStream fis = null;
		FileChannel in = null;
		WritableByteChannel out = null;
		
		res.setContentType("application/octet-stream");
		res.setHeader( "Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(file.getName(), "utf-8") + "\";");
		
		try {
			if (file.isFile()) {
				 fis = new FileInputStream(file);
				 in = fis.getChannel();
				 out = Channels.newChannel(res.getOutputStream()); 
				    
				 in.transferTo(0, in.size(), out);
			}
		}catch(FileNotFoundException e1) {
			logger.info(e1.getMessage());
		}catch(IOException e2) {
			logger.info(e2.getMessage());
		}catch(Exception e3) {
			logger.info(e3.getMessage());
		}finally {
			if(out != null)	out.close();
			if(in != null)	in.close();
			if(fis != null)	fis.close();
		}
		
	}
	
	
	
}
