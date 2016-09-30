package com.spring.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MybatisWenDao {

	@Results({
		@Result(property="id",column="id"),
		@Result(property="firstName",column="first_name"),
		@Result(property="lastName",column="last_Name")
})
	@Select("select * from wen where first_name=#{firstName}")
	public Wen getUser(String firstName);

	@Results({
			@Result(property="id",column="id"),
			@Result(property="firstName",column="first_name"),
			@Result(property="lastName",column="last_Name")
	})
	@Select("select * from wen")
	public List<Wen> getUserList();
}
