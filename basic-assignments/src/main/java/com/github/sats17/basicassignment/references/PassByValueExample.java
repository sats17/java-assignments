package com.github.sats17.basicassignment.references;

/**
 * In java we have pass by value mechanism, but we can see object values is getting changed that is because current variable holds
 * address of object. So when we pass variable to method params address gets copy to new variable and when we try to update
 * any field of object(by using .<instance member>) it will get updated at object level(heap).
 * 
 * @author sats17
 *
 */
public class PassByValueExample {

	/**
	 * Helper method 
	 * 
	 * @param user
	 */
	public static void passByValueMethod(User user) {
		System.out.printf("\nUser which is passed to method passByValueMethod has address is %s",user.toString());
		user.x = 20; // here local variable user 
		System.out.printf("\nWe have updated value of user in method %s, updated value %s",user.toString(),user.x);
		System.out.println("\nCreating new user object and assigning it to user variable which is inside method");
		user = new User(); // Creating new user object and assigning it to user variable which is inside method
		System.out.printf("After assigning new object to user variable it's address is %s",user.toString());
		user.x = 30;
		System.out.printf("\nAlso, we have updated the value of user %s with value ",user.toString(), user.x);
	}

	public static void main(String[] args) {
		User user = new User();
		System.out.printf("Default value of x in user at time of object creations is %s and user is %s \n", user.x,
				user.toString());
		user.x = 10;
		System.out.printf("Updated value of x in user by %s  and value is %s", user.toString(), user.x);
		System.out.printf("\n \n");
		System.out.printf("Passing user reference variable %s to a method ",user.toString());
		passByValueMethod(user);
		System.out.println("\nNow we are outside of method");
		System.out.println("Now value of x in user reference variable is "+user.x);
		System.out.println("This is because current user address is still same as earlier "+user.toString());
		System.out.println("revisit to above statements to check");
	}

}
