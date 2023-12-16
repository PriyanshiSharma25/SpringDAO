package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.DTO.userDTO;

@Repository
public class userDAOJDBCImpl implements userDAOInt {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public long add(userDTO dto) {

		String sql = "INSERT INTO USER VALUES(?,?,?,?,?)";
		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}

	public void update(userDTO dto) {
		String sql = "UPDATE USER SET FIRST_NAME=?, LAST_NAME=? ,LOGIN=? ,PASSWORD=? WHERE ID=?";
		int pk = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(),dto.getPassword(), dto.getId());
	}

	public void delete(userDTO dto) {
		String sql = "DELETE FROM USER WHERE ID=?";
		int pk = jdbcTemplate.update(sql, dto.getId());
	}

	public userDTO findByPk(int pk) {
		String sql = "SELECT ID, FIRST_NAME ,LAST_NAME ,LOGIN ,PASSWORD FROM USER WHERE ID =?";
		Object[] params = {pk};
		List list = jdbcTemplate.query(sql,params, new UserMapper());
		
		userDTO dto = null;
		
		if (list.size()>0) {
			dto =(userDTO) list.get(0);
		}
		return dto;
	}

}
