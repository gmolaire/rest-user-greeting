package com.github.gumold.example.restusergreeting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.gumold.example.restusergreeting.client.BasicRestUsersClient;
import com.github.gumold.example.restusergreeting.client.dto.User;

@Controller
@RequestMapping("/v1")
public class GreetingController {

	@Autowired
	BasicRestUsersClient userClient;

	@GetMapping("/_greet")
	@ResponseStatus(HttpStatus.OK)
	public String greet(@RequestParam(required = false) final String username) {
		User user = userClient.getUser(username);
		return user == null ? "Hello Johna Doe" : "Hello " + user.getFirstName();
	}
}
