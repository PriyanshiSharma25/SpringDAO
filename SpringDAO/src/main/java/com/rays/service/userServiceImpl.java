package com.rays.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.DTO.userDTO;
import com.rays.dao.userDAOInt;
import com.rays.dao.userDAOInt;

@Service
public class userServiceImpl implements userServiceInt{
	
	@Autowired
	private userDAOInt dao = null;
	
	@Autowired
	private JavaMailSender mailSender;

//	@Transactional(propagation  = Propagation.REQUIRED)
	public long add(userDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}
	@Transactional(propagation  = Propagation.REQUIRED)
	public void update(userDTO dto) {
		 dao.update(dto);
	}

	public void delete(userDTO dto) {
		dao.delete(dto);
	}

	public userDTO findByPk(int pk) {
		userDTO dto = dao.findByPk(pk);
	 return dto;
		
	}
	
	public void sendEmail() {
		MimeMessage msg = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo("priyusharma256@gmail.com");
			helper.setSubject("test subject");
			helper.setText("text msg",true);
			
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
}
