package com.github.gumold.example.restusergreeting.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "basic-rest-users")
public class BasicRestUsersConfig {
	private String url;
}
