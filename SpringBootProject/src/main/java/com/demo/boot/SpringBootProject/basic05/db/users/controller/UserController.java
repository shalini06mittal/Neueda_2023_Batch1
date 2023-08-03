package com.demo.boot.SpringBootProject.basic05.db.users.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.boot.SpringBootProject.basic05.db.users.dal.UserDAL;
import com.demo.boot.SpringBootProject.basic05.db.users.dal.UserRepository;
import com.demo.boot.SpringBootProject.basic05.db.users.model.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	private final UserDAL userDAL;

	public UserController(UserRepository userRepository, UserDAL userDAL) {
		this.userRepository = userRepository;
		this.userDAL = userDAL;
	}

	public User addNewUsers(User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	public User getUser(String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findById(userId).orElse(null);
	}

	public Object getAllUserSettings(String userId) {
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			return userDAL.getAllUserSettings(userId);
		} else {
			return "User not found.";
		}
	}

	/**
	 * Notice in the above query, we got the user object,
	 * then extracted the complete Setting map (which could have contained 1000s of objects)
	 * and finally got our own value.
	 * This is a downside for Spring Data query when we use it as straight API.
	 * @param userId
	 * @param key
	 * @return
	 */
	public String getUserSettingrepo(String userId,  String key) {
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			return user.getUserSettings().get(key);
		} else {
			return "User not found.";
		}
	}


	public String getUserSetting( String userId,  String key) {
		return userDAL.getUserSetting(userId, key);
	}


	public String addUserSetting( String userId,  String key,  String value) {
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			user.getUserSettings().put(key, value);
			userRepository.save(user);
			return "Key added";
		} else {
			return "User not found.";
		}
	}
}