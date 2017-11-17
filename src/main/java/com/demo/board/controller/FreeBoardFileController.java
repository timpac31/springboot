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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.demo.common.FileController;

@Controller
public class FreeBoardFileController implements FileController {
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardFileController.class);
	
	private static final String FILE_PATH = "D:\\file\\";
	
	@Override
	public void singleFileUpload(MultipartFile file) throws IOException {
		Files.createDirectories(Paths.get(FILE_PATH));
        Files.write(Paths.get(FILE_PATH + file.getOriginalFilename()),  file.getBytes());
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
