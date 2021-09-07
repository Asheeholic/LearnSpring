package com.yedam.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;
import com.yedam.app.board.mapper.ReplyMapper;

import lombok.extern.java.Log;

@Log
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("register... : " + vo.toString());
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("register... : " + rno.toString());
		return mapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		log.info("register... : " + rno.toString());
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("update... : " + vo.toString());
		return mapper.update(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("get Reply List of a Board " + bno.toString());
		return mapper.getListWithPaging(cri, bno);
	}

}
