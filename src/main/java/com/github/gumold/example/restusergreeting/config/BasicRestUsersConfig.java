package com.github.gumold.example.restusergreeting.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "basic-rest-users")
public class BasicRestUsersConfig {
	private String url;
}
