package com.helloSQL.test;

import java.io.InputStream;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMyBatisAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String resouce = "confAnnotation.xml";
		InputStream is = HelloMyBatisAnnotation.class.getClassLoader().getResourceAsStream(resouce);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		Configuration configuration = sessionFactory.getConfiguration();
		configuration.addMapper(GetUserInfoAnnotation.class);
		SqlSession session = sessionFactory.openSession();
		
		try {
			GetUserInfoAnnotation getUserInfo = session.getMapper(GetUserInfoAnnotation.class);
			User user = getUserInfo.getUser(2);
			System.out.println(user.getId() + " " + user.getUserName() + " "+ user.getCorp());
		} finally {
			session.close();
		}
	}

}
