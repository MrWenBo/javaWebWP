package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestData {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		MybatisWenDao dao = context.getBean("mybatisWenDao", MybatisWenDao.class);
		
		List<Wen> wenlist = dao.getUserList();
		for (Wen wen : wenlist) {
			System.out.println(wen.getFirstName()+" "+wen.getLastName());
		}
		
		/*//dao.createTabel();
		dao.insertData(2,"Yu","pig");
		System.out.println(dao.count());
		List<Wen> wens = dao.getWenList();
		for (Wen wen : wens) {
			System.out.println(wen.getId()+wen.getFristName()+wen.getLastName());
		}*/

		((ConfigurableApplicationContext) context).close();
	}

}
