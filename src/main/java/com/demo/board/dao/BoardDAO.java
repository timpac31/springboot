package com.demo.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.board.domain.BoardReplyVO;
import com.demo.board.domain.BoardVO;
import com.demo.board.domain.PageVO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int selectBoardCount(PageVO pageVO) {
		return sqlSession.selectOne("mappers.boardMapper.boardCount", pageVO);
	}
	
	public List<BoardVO> selectBoardList(PageVO pageVO) {
		return sqlSession.selectList("mappers.boardMapper.boardList", pageVO);
	}
	
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("mappers.boardMapper.insert", boardVO);
	}

	public BoardVO selectBoardDetail(int seq) {
		return sqlSession.selectOne("mappers.boardMapper.detail", seq);
	}

	public int modifyBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("mappers.boardMapper.update", boardVO);
	}

	public void insertReply(BoardReplyVO boardReplyVO) throws Exception {
		sqlSession.insert("mappers.boardMapper.insertReply", boardReplyVO);
	}

	public List<BoardReplyVO> selectReplyList(int seq) {
		return sqlSession.selectList("mappers.boardMapper.selectReplyList", seq);
	}

}
