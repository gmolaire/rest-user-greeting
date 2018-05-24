package com.github.gumold.example.restusergreeting.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String id;

	private String firstName;
	private String lastName;

	private String email;

	private String location;
}
