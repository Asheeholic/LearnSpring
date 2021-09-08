package com.yedam.app.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component // 어디에도 속해 있지가 않음 그래서 빈 등록 해야함
//@Aspect
public class LogAdvice {
	
	// 이런식으로 어떤 주요한 서비스를 실행하기 전에 먼저 실행하거나 다 하고 난뒤의 실행을 해줄 수 있다.
	
	@Pointcut( "execution( * com.yedam.app..*ServiceImpl.*(..))" ) // 공통 포인트 컷을 선언함.
	public void allPointcut() {}
	
	
	@Before("allPointcut()")
	public void logBefore(JoinPoint jp) {
		log.info("[before]=========================");
		String methodName = jp.getSignature().getName(); // 메소드 이름
		Object[] arg = jp.getArgs(); // 인수 여러개 가져옴 [배열로]
		String str = methodName + " : arg = " + ( arg != null && arg.length>0 ? arg[0] : "");
		log.info(str);
	}
	
	@AfterReturning(
			pointcut = "allPointcut()", 
			returning = "obj" ) // 리턴값 설정하면 리턴 값 가져 올 수 있음.
	public void logAfter(JoinPoint jp, Object obj) {
		log.info("[after]=========================");
		String methodName = jp.getSignature().getName(); 
		String str = methodName + " : return = " + ( obj != null ? obj : "");
		log.info(str);
	}
	
}
