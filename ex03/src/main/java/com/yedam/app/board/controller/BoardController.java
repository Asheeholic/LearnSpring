package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.domain.BoardVO;
import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.PageVO;
import com.yedam.app.board.service.BoardService;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/board/*")
@SessionAttributes("cri") // 알아서 세션에 저장한다.
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 전체조회
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		int total = boardService.getTotalCount(cri);
		model.addAttribute("cri", cri);
		model.addAttribute("pageMaker", new PageVO(cri, total));
		model.addAttribute("list" , boardService.getList(cri));
		log.info("list enter");
	}
	
	//단건조회(수정페이지)
	// 번호를 가져오면 됨.
	@GetMapping({"/get", "/modify"})
	public void get(Model model, BoardVO vo, @ModelAttribute("cri") Criteria cri) { // bno 파라미터 -> 커맨드 객체
		
		model.addAttribute("board", boardService.read(vo));
		log.info("get enter");
	}
	
	// 수정처리
	@PostMapping("/modify")
	public String modify(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify : " + vo);
		int result = boardService.update(vo);
		if(result == 1) {
			rttr.addFlashAttribute("result", "success");			
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list"; // 파라미터 전달 x

	}
	
	// 등록페이지
	@GetMapping("/register")
	public void registerForm() {}
	
	// 등록 처리
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("register : " + vo);
		
		int result = boardService.insert(vo);
		
		if(result == 1) {
			rttr.addFlashAttribute("result", "success");			
		}
		
		return "redirect:/board/list";
	}
	
	// 삭제 처리
	@PostMapping("/delete")
	public String delete(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("delete : " + vo);
		int result = boardService.delete(vo);
		if(result == 1) {
			rttr.addFlashAttribute("result", "success");			
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
}
