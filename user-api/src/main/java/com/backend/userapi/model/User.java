package com.backend.userapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.backend.userapi.dto.UserDTO;

@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cpf;
	private String address;
	private String email;
	private String telphone;
	private Date dateRegister;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Date getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}
	
	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setCpf(userDTO.getCpf());
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setTelphone(userDTO.getTelphone());
		user.setDateRegister(userDTO.getDateRegister());
		
		return user;
	}
}
