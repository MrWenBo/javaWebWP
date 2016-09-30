package com.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createTabel() {
		jdbcTemplate.execute("create table wen (id integer, first_name varchar(100), last_name varchar(100))");
	}

	public void insertData(int id,String firstName,String lastName) {
		this.jdbcTemplate.update("insert into wen values("+id+",?,?)", firstName, lastName);

	}

	public int count() {
		return this.jdbcTemplate.queryForObject("select count(*) from wen", Integer.class);
	}
	
	public List<Wen> getWenList() {
		return this.jdbcTemplate.query("select * from wen", new RowMapper<Wen>() {

			public Wen mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wen wen= new Wen();
				wen.setId(rs.getInt("id"));
				wen.setFristName(rs.getString("first_name"));
				wen.setLastName(rs.getString("last_name"));
				return wen;
			}
			
		});
	}

}
