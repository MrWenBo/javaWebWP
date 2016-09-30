package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.spring.aop.Caculator.*(..)) && args(a,..)")
	private void arithmeticDolog(JoinPoint js, int a) {
		System.out.println(a + " : " + js.toString());
	}
}
