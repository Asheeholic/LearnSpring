package com.yedam.app.board;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;
import com.yedam.app.board.mapper.ReplyMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class ReplyMapperTests {
	
	@Autowired private ReplyMapper mapper;
	private Long[] bnoArr = {7077912L, 7077911L, 7077910L, 7077909L, 7077908L};
	
	@Test
	public void testList2() {
		
		Criteria cri = new Criteria(1, 10);
		
		//7077912L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 7077912L);
		
		replies.forEach(reply -> log.info(reply.toString()));
	}
	
	//@Test
	public void testList() {
		
		Criteria cri = new Criteria();
		
		//7077912L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply.toString()));
	}
	
	//@Test
	public void testUpdate() {
		
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply ");
		
		int result = mapper.update(vo);
		
		assertEquals(result, 1);
		
	}
	
	//@Test
	public void testDelete() {
		
		Long targetRno = 1L;
		
		int result = mapper.delete(targetRno);
		
		assertEquals(result, 1);
		
	}
	
	//@Test
	public void testRead() {
		
		Long targetRno = 5L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo.toString());
		
	}
	
	
	
	//@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			//게시물의 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer " + i);
			
			mapper.insert(vo);
		});
		
	}
	
	//@Test
	public void testMapper() {
		log.info(mapper.toString());
	}
	
	
	
}
