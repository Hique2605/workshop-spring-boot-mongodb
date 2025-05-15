package com.hique2605.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //ou "@GetMappin" funciona igual
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST) //ou "@PostMapping" funciona igual
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE) //ou "@DeleteMapping" funciona igual
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();	//resposta quando nao devolve nada é 204
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT) //ou "@PutMapping" funciona igual
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	
	

}
