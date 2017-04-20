package com.helloSQL.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMyBatis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 声明配置⽂件的⺫录渎职
	 	 String resource = "conf.xml";
	 	 //2. 加载应⽤配置⽂件
	 	 InputStream is = HelloMyBatis.class.getClassLoader().getResourceAsStream(resource);
	 	 // 3. 创建SqlSessonFactory
	 	 SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	 	 // 4. 获取Session
	 	 SqlSession session = sessionFactory.openSession();
	 	 try {
			 // 5. 获取操作类
			 GetUserInfo getUserInfo =session.getMapper(GetUserInfo.class);
			 // 6. 完成查询操作
			 User user = getUserInfo.getUser(1);
			 System.out.println(user.getId() + " " + user.getUserName() + " "+ user.getCorp());
	 	 } finally {
			 // 7.关闭Session
			 session.close();
	 	 }
	}

}
