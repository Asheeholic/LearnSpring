package com.yedam.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;

// pojo : 상속X
@Controller // -> @Component 상속해서 @Controller, @Service, @Repository(=dao)
@RequestMapping("/sample/*")
@Log
public class SampleController {
	
	@RequestMapping("/ex09")
	@ResponseBody // 자바객체 -> json 스트링 변환
	public SampleVO ex07(SampleVO sample) {
		sample.setName("홍길동");
		sample.setAge(50);
		return sample;
	}
	
	@RequestMapping("/ex06/{name}/{age}")
	public void ex06(@PathVariable String name,
			@PathVariable int age) {
		log.info("name = " + name);
		log.info("age = " + age);

	}
	// http://localhost/sample/ex06/chichi/30
	// INFO: name = chichi, INFO: age = 30
	
	@GetMapping("/ex05")
	public void ex05(SampleVoList list) {
		log.info("vo : " + list.toString());
	}
	// 
	
	
	// 3과 4의 결과가 같음.
	@GetMapping("/ex04")
	public void ex04(@RequestParam List<String> ids) {
		log.info("id : " + ids.toString());
	}
	
	@GetMapping("/ex03")
	public void ex03(@RequestParam String[] ids) {
		// String[] ids = request.getParameterValues("ids");
		log.info("id : " + Arrays.toString(ids));
	}
	
	@GetMapping("/ex02")
	public void ex02(@RequestParam(name = "username") String name , 
					 @RequestParam(required = false, defaultValue = "10") int age
					 ) {
		//String name = request.getParameter("username") // 변수명도 일치해야함
		log.info("name = " + name);
		log.info("age = " + age);
	}
	
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("sam") SampleVO vo, Model model) { // dto = vo = do
		log.info(vo.toString());
		// model.addAttribute("sampleVO", vo);
		// 파라미터로 받은건 자동으로 모델로 들어가기 때문에 
		// 굳이 Model model | model.addAttribute("sampleVO", vo);
		// 안해도 model에 담아짐.
		
		model.addAttribute("pageNo", "10");
		
		return "sample/ex01";
	}
	// http://localhost/sample/ex01?name=chichi&age=30&dueDate=2020-10-10
	// INFO: SampleVO(name=chichi, age=30, dueDate=Sat Oct 10 00:00:00 KST 2020)

	//@RequestMapping("/a")
	@GetMapping("/a")
	public String basic1() { 
		log.info("basic....a...");
		return "sample/basica"; // jsp 뷰페이지 리턴 (이걸 좀 더 많이 씀)
	}
	@RequestMapping("/b")
	public void basic2() { // void 일경우 url과 일치하는 뷰페이지로 이동함.
		log.info("basic....b...");
	}
}
