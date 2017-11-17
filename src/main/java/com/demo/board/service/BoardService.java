package com.demo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.board.dao.BoardDAO;
import com.demo.board.domain.BoardVO;
import com.demo.board.domain.PageVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDao;
	
	public int selectBoardCount(PageVO pageVO) {
		return boardDao.selectBoardCount(pageVO);
	}

	public List<BoardVO> selectBoardList(PageVO pageVO) {
		return boardDao.selectBoardList(pageVO);
	}

	public int insertBoard(BoardVO boardVO) throws Exception {
		return boardDao.insertBoard(boardVO);
	}

	public BoardVO selectBoardDetail(int seq) {
		return boardDao.selectBoardDetail(seq);
	}

	public int modifyBoard(BoardVO boardVO) throws Exception {
		return boardDao.modifyBoard(boardVO);
	}

}
