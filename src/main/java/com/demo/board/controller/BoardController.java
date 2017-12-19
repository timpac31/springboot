package com.demo.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.demo.board.domain.BoardVO;
import com.demo.board.domain.PageVO;
import com.demo.board.service.BoardService;
import com.demo.board.controller.FreeBoardFileController;
import com.demo.exception.BoardSQLException;
import com.demo.util.StringUtil;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
		
	@Autowired
	private BoardService boardService;
	@Autowired
	private FreeBoardFileController fileController;
	
	@RequestMapping("/board/list.do")
	public String selectBoardList(Model model, @ModelAttribute PageVO pageVO) {
		int totalCount = boardService.selectBoardCount(pageVO);
		
		pageVO.setListSize(5);
		pageVO.setPage(totalCount);
		//logger.info("startRow: " + pageVO.getStartRow() + " endRow: " + pageVO.getEndRow());
		
		List<BoardVO> resultList = boardService.selectBoardList(pageVO);

		model.addAttribute("list", resultList);
		model.addAttribute("page", pageVO);
		return "boardList";
	}
	
	@RequestMapping("/board/writeForm.do")
	public String writeForm(Model model, @ModelAttribute BoardVO boardVO, Authentication auth) {
		model.addAttribute("sessionName", auth.getName());
		return "boardWrite";
	}
	
	@RequestMapping("/board/write.do")
	public String insertBoard(Model model, @ModelAttribute BoardVO boardVO, @RequestParam("file") MultipartFile file) 
			throws BoardSQLException, Exception {
		if(!file.isEmpty()) {
			fileController.singleFileUpload(file);			
			boardVO.setFilename(file.getOriginalFilename());
			boardVO.setFilesize(file.getSize());
			boardVO.setType(StringUtil.getExtension(file.getOriginalFilename()));
		}
		
		try {
			boardService.insertBoard(boardVO);
		} catch (Exception e) {	
			throw new BoardSQLException(e);
		}

		model.addAttribute("msg", "등록 되었습니다.");
		model.addAttribute("url", "/board/list.do");		
		return "redirect";
	}
	
	@RequestMapping("/board/modifyForm.do")
	public String modifyForm(Model model, @ModelAttribute BoardVO boardVO) {
		boardVO = boardService.selectBoardDetail(boardVO.getSeq());		
		model.addAttribute("boardVO", boardVO);
		return "boardModify";
	}
	
	@RequestMapping("/board/modify.do")
	public String modifyBoard(Model model, @ModelAttribute BoardVO boardVO, @RequestParam("file") MultipartFile file) 
			throws BoardSQLException {		
		if(!file.isEmpty()) {
			fileController.singleFileUpload(file);
			boardVO.setFilename(file.getOriginalFilename());
			boardVO.setFilesize(file.getSize());
			boardVO.setType(StringUtil.getExtension(file.getOriginalFilename()));
		}
		
		try {	
			boardService.modifyBoard(boardVO);
		} catch (Exception e) {
			throw new BoardSQLException(e);
		}
		
		model.addAttribute("msg", "수정 되었습니다.");
		model.addAttribute("url", "/board/list.do");
		return "redirect";
	}
	
	@RequestMapping(value="/board/view.do", method=RequestMethod.GET)
	public String view(Model model, @RequestParam int seq, BoardVO boardVO) {
		boardVO = boardService.selectBoardDetail(seq);
		model.addAttribute("boardVO", boardVO);
		return "boardView";
	}
	
	

}
