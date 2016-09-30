package com.spring.jdbc;

import org.apache.ibatis.annotations.Update;

public interface transferMoney {
	
	@Update("update balance from UserBalance where sreUserId=#{UserId}")
	public UserBalance transferMoney(long sreUserId,long targetUserId, double count);
}
