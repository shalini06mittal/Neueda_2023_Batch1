package com.demo.boot.SpringBootProject.basic05.db.users.dal;

import  com.demo.boot.SpringBootProject.basic05.db.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Get all users
 * Get a user with ID
 * Get user settings
 * Get a particular key from the Map
 * Add/Update user setting
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
