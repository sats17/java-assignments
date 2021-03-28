package com.github.sats17.problems.assignments;

import java.util.Scanner;

public class UserLoginImpl {
	
	static Scanner sc = new Scanner(System.in);
	public static void login() {
		
		int counter = 0;
		while(counter < 4) {
			System.out.print("Enter Username :- ");
			String uName = sc.next().trim();
			System.out.print("Enter Password :- ");
			String uPassword = sc.next().trim();
			if(validator(uName, uPassword)) {
				System.out.println("Welcome");
				System.exit(0);
				break;
			}
			else {
				System.out.println("Wrong Credentials.");
				counter++;
			}
			System.out.println("Contact Admin.");
			System.exit(0);
		}
		
		
	}
	
	private static boolean validator(String name,String password) {
		if(name.equals("Sats17") && password.equals("12345")) {
			return true;
		}
		else {
			return false;
		}
	}

}
