package com.ty.emp_task.controler;

import java.util.ArrayList;
import java.util.List;

import com.ty.emp_task.dto.Task;
import com.ty.emp_task.dto.User;

public class UserControler {

	private List<User> listUsers;

	public User saveUser(User user) {
		if (listUsers == null) {
			listUsers = new ArrayList<>();
		}
		listUsers.add(user);
		return user;
	}

	public User updateUser(int userId, User user) {
		User existingUser = findUserById(userId);
		if (existingUser != null) {
			modifyUser(existingUser, user);
			return existingUser;
		}
		return null;
	}

	private void modifyUser(User existingUser, User user) {
		if (user.getUserName() != null) {
			existingUser.setUserName(user.getUserName());
		}
		if (user.getUserEmail() != null) {
			existingUser.setUserEmail(user.getUserEmail());
		}
		if (user.getUserPassword() != null) {
			existingUser.setUserPassword(user.getUserPassword());
		}
	}

	public User findUserById(int userId) {
		for (User user : listUsers) {
			if (user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}

	public List<User> findAll() {
		return listUsers;
	}

	public User findUserByEmailAndPassword(String email, String password) {
		for (User user : listUsers) {
			if (user.getUserEmail().equalsIgnoreCase(email) && user.getUserPassword().equalsIgnoreCase(password)) {
				return user;
			}
		}
		return null;
	}

	public User saveTask(User user, Task task) {
		if (user.getTasks() == null) {
			List<Task> tasks = new ArrayList<>();
			user.setTasks(tasks);
		}
		user.getTasks().add(task);

		return user;
	}
}
