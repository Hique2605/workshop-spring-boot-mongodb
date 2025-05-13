package com.hique2605.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hique2605.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")			//geralmente o caminho é usado no plural 
public class UserResource {
	
	
	@RequestMapping(method=RequestMethod.GET) //ou "@GetMappin" funciona igual
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "Maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
		
	}
}
