package com.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	/*public void insertData(int id,String user,Double balance) {
		this.jdbcTemplate.update("insert into account values("+id+",?,?)",user , balance);

	}
	
	public void resetMoney() {
		jdbcTemplate.update("update account set balance=1000");
	}*/
	
	public List<Account> accountList() {
		return this.jdbcTemplate.query("select * from account", new RowMapper<Account>() {

			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Account account = new Account();
				account.setUser(rs.getString("user"));
				account.setBalance(rs.getDouble("balance"));
				return account;
			}
		});
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void transferMorney(long srcUserId, long targetUserId, double count) {
		this.jdbcTemplate.update("update UserBalance set balance=balance-? where userId=?",srcUserId,targetUserId);
		this.jdbcTemplate.update("update UserBalance set balance=balance+? where userId=?",srcUserId,targetUserId);
	}
	
	
}
