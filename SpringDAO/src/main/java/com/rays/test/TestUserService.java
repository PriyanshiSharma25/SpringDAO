package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.DTO.userDTO;
import com.rays.service.userServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public userServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		TestUserService test = (TestUserService) context.getBean("testUserService");
		//test.testAdd();
		//test.testUpdate();
		//test.testfindByPk();
		//test.testDelete();
		test.testsendEmail();

	}

	private void testsendEmail() {
		service.sendEmail();
	}

	private void testDelete() {
		userDTO dto = new userDTO();
		dto.setId(3);
		service.delete(dto);
		System.out.println("data Deleted");
		
		
	}

	private void testfindByPk() {
    userDTO dto = service.findByPk(2);
    if(dto!=null) {
    	System.out.println(dto.getId());
    	System.out.println("  ," + dto.getFirstName());
    	System.out.println("  ," + dto.getLastName());
    	System.out.println("  ," + dto.getLogin());
    	System.out.println("  ," + dto.getPassword());
    }else {
    	System.out.println("user don't exist");
    }
	}

	private void testUpdate() {
		userDTO dto = new userDTO();
		dto.setId(2);
		dto.setFirstName("happy");
		dto.setLastName("jai");
		dto.setLogin("fd");
		dto.setPassword("123");
		
		
		 service.update(dto);

		System.out.println("data updated");
	}

	private void testAdd() {
		userDTO dto = new userDTO();

		dto.setId(4);
		dto.setFirstName("h");
		dto.setLastName("j");
		dto.setLogin("fd");
		dto.setPassword("123");

		long pk = service.add(dto);

		System.out.println(pk);

	}
}
