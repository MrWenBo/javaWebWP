package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

	public static void main(String[] args) {
		
				ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

				AccountDao dao = context.getBean("accountDao", AccountDao.class);
			
				try {
					dao.transferMorney(10001, 10002, 520.00);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				List<Account> accounts = dao.accountList();
				for (Account account : accounts) {
					System.out.println(account.getUser()+":"+account.getBalance());
				}

				((ConfigurableApplicationContext) context).close();
	}

}
