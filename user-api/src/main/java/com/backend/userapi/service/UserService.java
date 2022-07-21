package com.backend.userapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.userapi.dto.UserDTO;
import com.backend.userapi.model.User;
import com.backend.userapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO>getAll() {
		List<User> user = userRepository.findAll();
		return user.stream().map(UserDTO::convert).collect(Collectors.toList());
	}
	
	public UserDTO findById(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return UserDTO.convert(user.get());
		}
		return null;
	}
	
	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}
	
	public UserDTO delete(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			userRepository.delete(user.get());
		}
		return null;
	}
	
	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if(user != null) {
			return UserDTO.convert(user);
		}
		return null;
	}
	
	public List<UserDTO> queyByName(String name) {
		List<User> user = userRepository.queryByNameLike(name);
		return user.stream().map(UserDTO::convert).collect(Collectors.toList());
	}
}
