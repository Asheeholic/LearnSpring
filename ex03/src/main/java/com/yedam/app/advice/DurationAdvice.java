package com.yedam.app.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
//@Aspect
public class DurationAdvice {
	
	@Around("LogAdvice.allPointcut()") // 다른 클래스의 포인트컷을 가져옴
	public Object logTime( ProceedingJoinPoint pjp ) { // 전체 조인포인트를 말함.
		
		long start = System.currentTimeMillis();
		
		Object obj = null;
		
		try {
			obj = pjp.proceed(); // 서비스 메소드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		long end = System.currentTimeMillis();
		
		log.info(" Total run time : " + (end-start));
		
		return obj;
	}
	
}
