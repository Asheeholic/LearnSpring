package com.yedam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno); // 특정 댓글읽기
	
	public int delete(Long rno);
	
	public int update(ReplyVO vo);
	
	public List<ReplyVO> getListWithPaging(
				@Param("cri") Criteria cri,
				@Param("bno") Long bno
			);
	
}
