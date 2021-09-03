package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.board.service.BoardService;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 전체조회
	@RequestMapping("/list")
	public void list(Model model) {
		model.addAttribute("list" , boardService.getList());
		log.info("list enter");
	}
}
