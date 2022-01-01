package com.github.sats17;

/**
 * This is example of Eager singleton class
 * 
 * @author Sats17
 *
 */
public class SingletonClass {
	
	private static SingletonClass singletonInstance = null;
	
	/**
	 * Private constructor, so no one can initialize this class with new keyword.
	 */
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		if(singletonInstance == null) { // First level validation for null. 
			synchronized (SingletonClass.class) { // Due to thread safety, we are having synchronized block here. 
				if(singletonInstance == null ) { // Second level validation, due to synchronized block this will valid only for single thread at a time.
					singletonInstance = new SingletonClass();
				}
			}
		}
		return singletonInstance;
	}
	
	public static void main(String[] args) {
		System.out.println("Let's validate singleton class");
		SingletonClass firstInstance = SingletonClass.getInstance();
		System.out.println("First instance address "+firstInstance.hashCode());
		SingletonClass secondInstance = SingletonClass.getInstance();
		System.out.println("Second instance address "+secondInstance.hashCode());
	}
}
