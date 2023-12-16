package com.rays.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rays.DTO.userDTO;

public class UserMapper implements RowMapper<userDTO> {

	public userDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		userDTO user = new userDTO();
		user.setId(rs.getInt(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setLogin(rs.getString(4));
		user.setPassword(rs.getString(5));
		
		return user;
	}

}
