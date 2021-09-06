package com.yedam.app.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Criteria {

	// 초기값 지정
	private int pageNum = 1;
	private int amount = 10;
	private String type;
	private String keyword;
	
	public Criteria() {}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
}
