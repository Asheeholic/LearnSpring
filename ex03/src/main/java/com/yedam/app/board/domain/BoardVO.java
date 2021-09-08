package com.yedam.app.board.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	
	private long bno; 			// 게시글 번호
	private String title; 		// 제목
	private String content;		// 내용
	private String writer;		// 작성자
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date regdate;		// 작성일자
	@JsonIgnore
	private Date updatedate;	// 수정일자
	
	private int replyCnt;
	
}
