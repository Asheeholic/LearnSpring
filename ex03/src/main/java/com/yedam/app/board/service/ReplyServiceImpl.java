package com.yedam.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyPageVO;
import com.yedam.app.board.domain.ReplyVO;
import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.mapper.ReplyMapper;

import lombok.extern.java.Log;

@Log
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired private ReplyMapper replyMapper;
	@Autowired private BoardMapper boardMapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("register... : " + vo.toString());
		boardMapper.updateReplyCnt(vo.getBno(), 1L);
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("register... : " + rno.toString());
		return replyMapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		log.info("register... : " + rno.toString());
		ReplyVO vo = replyMapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1L);
		return replyMapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("update... : " + vo.toString());
		return replyMapper.update(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("get Reply List of a Board " + bno.toString());
		return replyMapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageVO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageVO(
				replyMapper.getCountByBno(bno),
				replyMapper.getListWithPaging(cri, bno)
		);
	}

}
