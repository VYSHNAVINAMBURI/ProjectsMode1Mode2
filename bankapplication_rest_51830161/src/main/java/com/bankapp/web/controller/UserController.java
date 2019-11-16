package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;
import com.bankapp.model.service.exceptions.UserNotFoundException;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userService;
	//here it is only accesed by admin we use admin url for accesing that for that we use like this..
	@GetMapping(path="user/allusers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@PostMapping(path = "user/adduser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) {

		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
	}

	@DeleteMapping(path = "user/deleteuser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> deleteUser(@PathVariable(name = "id") Long id) {
		/*
		 * Book book =
		 * bookservice.findBookById(id).orElseThrow(BookNotFoundException::new);
		 */
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "user/userid/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByID(@PathVariable(name="id")Long id){
		User user=userService.findUserById(id).orElseThrow(UserNotFoundException::new);
		userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}

