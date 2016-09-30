package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		Caculator caculator = context.getBean("caculator", Caculator.class);
		System.out.println(caculator.add(1, 2));
		System.out.println(caculator.sub(5, 4));
		((ConfigurableApplicationContext) context).close();
	}

}
