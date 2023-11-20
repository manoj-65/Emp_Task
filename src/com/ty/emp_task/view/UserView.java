package com.ty.emp_task.view;

import java.util.Scanner;

import com.ty.emp_task.controler.UserControler;
import com.ty.emp_task.dto.Task;
import com.ty.emp_task.dto.User;

public class UserView {

	public static void managerOperations(Scanner read, UserControler userControler) {
		boolean flag = true;
		while (flag) {
			System.out.println("1)Add Employee\n2)Assign Task\n3)Find User\n4)Exist\nEnter the Choice");
			int choice = read.nextInt();
			switch (choice) {
			case 1:
				readUser(read, userControler);
				break;
			case 2:
				assignTask(read, userControler);
				break;
			case 3:
				getUser(read, userControler);
				break;
			case 4:
				flag = false;
				break;

			default:
				System.out.println("Invalied Choice!!");
				break;
			}
		}
	}

	private static void readUser(Scanner read, UserControler userControler) {
		User user = new User();
		System.out.println("Enter the Employee Id:-");
		user.setUserId(read.nextInt());
		System.out.println("Enter the Employee Name:-");
		read.nextLine();
		user.setUserName(read.nextLine());
		System.out.println("Enter the Employee Email:-");
		user.setUserEmail(read.nextLine());
		user.setUserPassword("emp" + user.getUserId());
		user.setUserRole("EMPLOYEE");
		user = userControler.saveUser(user);
		System.out.println("Employee Info Saved\n" + user);
	}

	private static void assignTask(Scanner read, UserControler userControler) {
		System.out.println("Enter the Employee Id:-");
		int employeeId = read.nextInt();
		User user = userControler.findUserById(employeeId);
		if (user != null) {
			Task task = new Task();
			System.out.println("Enter the Task Id");
			task.setTaskId(read.nextInt());
			System.out.println("Enter the Task DeadLine");
			read.nextLine();
			task.setDeadLine(read.nextLine());
			System.out.println("Enter thee Task Description");
			task.setDescription(read.nextLine());
			user = userControler.saveTask(user, task);
			System.out.println("Task Added \n" + user);
		}
		System.out.println("User With the Given Id = " + employeeId + " not exists");
	}

	private static void getUser(Scanner read, UserControler userControler) {
		System.out.println("Enter the UserId:-");
		User user = userControler.findUserById(read.nextInt());
		if (user != null) {
			System.out.println("User Info :-" + user);
		}
		System.out.println("User With the Given Id not exists");

	}

	public static void employeeOperations(Scanner read, UserControler userControler, User user) {
		System.out.println("Task Assigined Are:-\n" + user.getTasks());
	}

}
