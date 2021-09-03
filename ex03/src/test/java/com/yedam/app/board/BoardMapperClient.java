package com.yedam.app.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.domain.BoardVO;
import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BoardMapperClient {
	
	@Autowired BoardService boardMapper;
	
	@Test
	public void getList() {
		log.info(boardMapper.getList().toString());
	}
	
	// 한건조회 테스트
	//@Test
	public void read() {
		BoardVO vo = new BoardVO();
		vo.setBno(5l);
		vo = boardMapper.read(vo);
		log.info(vo.toString());
	}
	
	// 생성 테스트
//	@Test
//	@Rollback
	public void insert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로 작성하는 글");
		vo.setContent("새로 작성하는 내용");
		vo.setWriter("새로운 작성자");
		
		int result = boardMapper.insert(vo);
		
		log.info(Long.toString(vo.getBno()));
		assertEquals(result, 1);
	}
	
	// 삭제 테스트
	//@Test
	//@Rollback
	public void delete() {
		BoardVO vo = new BoardVO();
		vo.setBno(11l);
		int result = boardMapper.delete(vo);
		log.info(vo.toString());
		assertEquals(result, 1);
	}
	
	// 수정 테스트
	//@Test
	//@Rollback
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setBno(15l);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		vo.setWriter("수정된 작성자");
		int result = boardMapper.update(vo);
		log.info(vo.toString());
		assertEquals(result, 1);
	}
}
