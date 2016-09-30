package com.helloSQL.test;

import org.apache.ibatis.annotations.Select;

public interface GetUserInfoAnnotation {

	@Select("select * from user where id = #{id}")
	public User getUser(int id);

}
