package com.github.gumold.example.restusergreeting.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.github.gumold.example.restusergreeting.client.dto.User;
import com.github.gumold.example.restusergreeting.config.BasicRestUsersConfig;

import lombok.extern.slf4j.Slf4j;
import wiremock.org.apache.commons.lang3.StringUtils;

@Slf4j
@Component
public class BasicRestUsersClient {

	@Autowired
	BasicRestUsersConfig basicRestUsersConfig;

	public User getUser(String username) {
		RestTemplate restTemplate = new RestTemplate();

		// Short circuit this if username is not defined
		if (StringUtils.isBlank(username)) {
			return null;
		}

		try {
			// TODO: Fix the URL so it gets generated properly
			return restTemplate.getForEntity(basicRestUsersConfig.getUrl() + "/users/" + username, User.class)
					.getBody();
		} catch (HttpClientErrorException exception) {
			log.warn("user {} doesn't seem to either exist", username, exception);
		} catch (RuntimeException exception) {
			// TODO: Manage the errors less vaguely
			log.error("something not quite normal is happening. Is the user service up?", exception);
		}
		return null;
	}
}
