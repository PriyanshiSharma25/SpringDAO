package com.rays.dao;

import com.rays.DTO.userDTO;

public interface userDAOInt {
	
	public long add(userDTO dto);
	
	public void update(userDTO dto);
	
	public void delete(userDTO dto);
	
	public userDTO findByPk(int pk);
	

}
