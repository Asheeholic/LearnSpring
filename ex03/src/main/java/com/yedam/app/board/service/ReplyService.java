package com.yedam.app.board.service;

import java.util.List;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyPageVO;
import com.yedam.app.board.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno); // 특정 댓글읽기
	
	public int remove(Long rno);
	
	public int modify(ReplyVO vo);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageVO getListPage(Criteria cri, Long bno);
	
}
