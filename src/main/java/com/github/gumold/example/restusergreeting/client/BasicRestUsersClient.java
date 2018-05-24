package com.github.gumold.example.restusergreeting.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.github.gumold.example.restusergreeting.client.dto.User;
import com.github.gumold.example.restusergreeting.config.BasicRestUsersConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BasicRestUsersClient {

	@Autowired
	BasicRestUsersConfig basicRestUsersConfig;

	public User getUser(String username) {
		RestTemplate restTemplate = new RestTemplate();

		// Short circuit this if we have a null value
		if (username == null) {
			return null;
		}

		try {
			return restTemplate.getForEntity(basicRestUsersConfig.getUrl(), User.class).getBody();
		} catch (HttpClientErrorException exception) {
			log.warn("{} doesn't seem to either exist or not liked by the user holding service", username, exception);
		} catch (RuntimeException exception) {
			// TODO: Manage the errors less vaguely
			log.error("something not quite normal is happening. Is the user service up? If so, is the DTO up to date?",
					exception);
		}
		return null;
	}
}
