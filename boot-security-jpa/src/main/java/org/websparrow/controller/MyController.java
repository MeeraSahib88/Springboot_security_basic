package org.websparrow.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.entity.User;
import org.websparrow.repository.UserRepository;

@RestController
public class MyController {

	
	@Autowired
	UserRepository userRepository;
	@GetMapping("/admin")
	public String admin() {
		return "<h2>Welcome Admin!</h2>";
	}

	@GetMapping("/user")
	public String user() {
		return "<h2>Welcome User!</h2>";
	}

	@GetMapping("/all")
	public String all() {
		return "<h2>Hello Everyone!</h2>";
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody User user){
		User user2=new User();
		user2.setUserName(user.getUserName());
		user2.setPassword(user.getPassword());
		user2.setActive(true);
		user2.setRoles(user.getRoles());
		userRepository.save(user2);
		return ResponseEntity.ok(user2);
	}
}