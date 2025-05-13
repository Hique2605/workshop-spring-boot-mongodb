package com.hique2605.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hique2605.workshopmongo.domain.User;
import com.hique2605.workshopmongo.dto.UserDTO;
import com.hique2605.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")			//geralmente o caminho é usado no plural 
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(method=RequestMethod.GET) //ou "@GetMappin" funciona igual
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
}
