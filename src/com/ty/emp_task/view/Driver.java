package com.ty.emp_task.view;

import java.util.Scanner;

import com.ty.emp_task.controler.UserControler;
import com.ty.emp_task.dto.User;

public class Driver {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		UserControler userControler = new UserControler();
		userControler.saveUser(new User(101, "Dinga", "Dinga@abc.in", "Dinga@123", "MANAGER"));
		System.out.println("Welecome To Employee App");
		while (true) {
			System.out.println("1)Login\n2)Exist\nSelect Your Choice");
			int choice = read.nextInt();
			switch (choice) {
			case 1:
				login(read, userControler);
				break;

			case 2:
				System.exit(0);
				break;

			default:
				break;
			}
		}

	}

	private static void login(Scanner read, UserControler userControler) {
		System.out.println("Enter the Email Id:-");
		read.nextLine();
		String email = read.nextLine();
		System.out.println("Enter the Password");
		String password = read.nextLine();
		User user = userControler.findUserByEmailAndPassword(email, password);
		if (user != null && user.getUserRole().equalsIgnoreCase("MANAGER")) {
			UserView.managerOperations(read, userControler);
		} else if (user != null && user.getUserRole().equalsIgnoreCase("Employee")) {
			UserView.employeeOperations(read, userControler, user);
		}
	}
}
