package com.hcl.user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.hcl.user.dto.Credentials;

@RestController
public class UserController {	
	
	@PostMapping("/users/login")
	public ResponseEntity<String> login(@Valid @RequestBody Credentials credentials) {
		 return new ResponseEntity<String>("login failed", HttpStatus.OK);
	}
	
}
