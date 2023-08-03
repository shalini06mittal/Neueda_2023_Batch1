package  com.demo.boot.SpringBootProject.basic05.db.users.dal;

import java.util.List;

import com.demo.boot.SpringBootProject.basic05.db.users.model.User;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
}