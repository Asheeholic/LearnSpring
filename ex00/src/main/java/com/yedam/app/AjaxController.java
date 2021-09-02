package com.yedam.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 이름이 살짝 다름
@RestController // @Controller + @ResponseBody
public class AjaxController {
	
	@RequestMapping("/ex07")
	public SampleVO ex07(SampleVO sample) {
		//SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(50);
		return sample;
	}
	// http://localhost/ex07
	// 제이슨 형태로 출력
	
	@RequestMapping("/ex08")
	public List<SampleVO> ex08(SampleVO sample) {
		List<SampleVO> list = new ArrayList<>();
		list.add(new SampleVO("choi", 10, new Date()));
		list.add(new SampleVO("park", 20, new Date()));
		list.add(new SampleVO("kim", 30, new Date()));
		return list;
	}
	// http://localhost/ex08
	
}
