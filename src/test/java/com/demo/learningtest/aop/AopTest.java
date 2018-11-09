package com.demo.learningtest.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.board.domain.PageVO;
import com.demo.board.service.BoardService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {
	
	@Autowired
	private BoardService boardService;
	private PageVO pageVo = new PageVO();
	
	
	@Test
	public void test() {
		boardService.selectBoardCount(pageVo);
		boardService.selectBoardDetail(0);
		boardService.selectBoardList(pageVo);
		boardService.selectReplyList(0);
		boardService.toString();
	}

}
