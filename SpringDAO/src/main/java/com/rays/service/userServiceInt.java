package com.rays.service;

import com.rays.DTO.userDTO;

public interface userServiceInt {
	public long add(userDTO dto);
	public void update(userDTO dto);
	public void delete(userDTO dto);
	public void sendEmail();
	
	public userDTO findByPk(int pk);
}
