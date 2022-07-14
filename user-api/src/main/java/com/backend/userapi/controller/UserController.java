package com.backend.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.userapi.dto.UserDTO;

@RestController
public class UserController {
	
	public static List<UserDTO> user = new ArrayList<>();

	@GetMapping("/")
	public String message() {
		return "Hello World!";
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return user;
	}
	
	@GetMapping("/users/{cpf}")
	public UserDTO getUsersFiltro(@PathVariable String cpf) {
		for(UserDTO userFilter : user) {
			if(userFilter.getCpf().equals(cpf)) {
				return userFilter;
			} 
		}
		return null;
	}
	
	@PostMapping("/newUser")
	UserDTO inserir(@RequestBody UserDTO userDTO) {
		userDTO.setDateRegister(new Date());
		return userDTO;
	}
	
	@DeleteMapping("/users/{cpf}")
	public boolean delete(@PathVariable String cpf) {
		for(UserDTO userFilter : user) {
			if(userFilter.getCpf().equals(cpf)) {
				user.remove(userFilter);
				return true;
			}
		}
		return false;
	}
	
	@PostConstruct
	public void initiateList() {
		
		UserDTO user1 = new UserDTO();
		user1.setName("Vinicius");
		user1.setCpf("123");
		user1.setAddress("Rua a");
		user1.setEmail("vinicius@email.com");
		user1.setTelphone("3532-2254");
		inserir(user1);
		
		UserDTO user2 = new UserDTO();
		user2.setName("Tiago");
		user2.setCpf("234");
		user2.setAddress("Rua b");
		user2.setEmail("tiago@email.com");
		user2.setTelphone("2541-6587");
		inserir(user2);
		
		UserDTO user3 = new UserDTO();
		user3.setName("Roberto");
		user3.setCpf("345");
		user3.setAddress("Rua c");
		user3.setEmail("roberto@email.com");
		user3.setTelphone("4485-2246");
		inserir(user3);
		
		user.add(user1);
		user.add(user2);
		user.add(user3);
	}
}
