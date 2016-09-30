package com.spring.wen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContainer {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("application-context.xml");
		
		//ScrewDriver sDriver=context.getBean("screwDriver", ScrewDriver.class);

		Header header= context.getBean("header", StraightHeader.class);
		System.out.println(header.getInfo());
		header.dowork();
		
		ScrewDriver screwDriver=context.getBean("screwDriver",ScrewDriver.class);
		screwDriver.use();
		
		((ConfigurableApplicationContext)context).close();
		
		/*ScrewDriver sDriver1=context.getBean("screwDriver", ScrewDriver.class);
		sDriver1.use();
		ScrewDriver screwDriver=new ScrewDriver();
		screwDriver.use();*/
	}
}
