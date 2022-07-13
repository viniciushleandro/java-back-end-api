package com.backend.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.userapi.dto.UserDTO;

@RestController
public class UserController {

	@GetMapping("/")
	public String message() {
		return "Hello World!";
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return user;
	}
	
	public static List<UserDTO> user = new ArrayList<>();
	
	@PostConstruct
	public void initiateList() {
		
		UserDTO user1 = new UserDTO();
		user1.setName("Vinicius");
		user1.setCpf("123");
		user1.setAddress("Rua a");
		user1.setEmail("vinicius@email.com");
		user1.setTelphone("3532-2254");
		user1.setDateRegister(new Date());
		
		UserDTO user2 = new UserDTO();
		user2.setName("Tiago");
		user2.setCpf("123");
		user2.setAddress("Rua b");
		user2.setEmail("tiago@email.com");
		user2.setTelphone("2541-6587");
		user2.setDateRegister(new Date());
		
		UserDTO user3 = new UserDTO();
		user3.setName("Roberto");
		user3.setCpf("123");
		user3.setAddress("Rua c");
		user3.setEmail("roberto@email.com");
		user3.setTelphone("4485-2246");
		user3.setDateRegister(new Date());
		
		user.add(user1);
		user.add(user2);
		user.add(user3);
	}
}
