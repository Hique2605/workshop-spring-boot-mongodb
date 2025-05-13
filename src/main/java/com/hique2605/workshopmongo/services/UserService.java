package com.hique2605.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hique2605.workshopmongo.domain.User;
import com.hique2605.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired	
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll(); 
	}
	
}
