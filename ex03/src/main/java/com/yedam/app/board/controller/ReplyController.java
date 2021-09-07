package com.yedam.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;
import com.yedam.app.board.service.ReplyService;

import lombok.extern.java.Log;

@RequestMapping("/reply/*")
@RestController
@Log
public class ReplyController {
	
	@Autowired ReplyService service;
	
	//post : 파라미터 문자열 ?id=100
	// put : json 만 가능함. -> { id : 100, pw: "111", name: "choi"}
	@PutMapping("/") 
	public ReplyVO modify(@RequestBody ReplyVO vo) {		
		service.modify(vo);
		return service.get(vo.getRno());
	}
	
	@DeleteMapping("/{rno}")		
	public boolean remove(@PathVariable("rno") Long rno) {
		int removeCount = service.remove(rno);
		log.info("Reply delete count : " + removeCount);
		return removeCount == 1 ? true : false;
	}
	
	@PostMapping("/")		
	public ReplyVO create(ReplyVO vo) {
		
		log.info("ReplyVO : " + vo);
		int insertCount = service.register(vo);
		log.info("Reply insert count : " + insertCount);
		log.info("Reply insert : " + vo.toString());
		return service.get(vo.getRno());
	}
	
	// 인수 두개 => 전체
	@GetMapping("/{bno}/{page}")		
	public List<ReplyVO> getList(
			@PathVariable("bno") long bno,
			@PathVariable("page") int page) {
		
		Criteria cri = new Criteria(page, 10);
		return service.getList(cri, bno);
	}
	
	// 단건 조회
	@GetMapping("/{rno}")		
	public ReplyVO get(@PathVariable("rno") long rno) {
		return service.get(rno);
	}
	
}
