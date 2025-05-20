package com.hique2605.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hique2605.workshopmongo.domain.Post;
import com.hique2605.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")			//geralmente o caminho é usado no plural 
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //ou "@GetMappin" funciona igual
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
