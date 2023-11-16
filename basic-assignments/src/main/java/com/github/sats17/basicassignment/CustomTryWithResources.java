package com.github.sats17.basicassignment;

/**
 * To use try with resources, the connection object must have implements AutoCloseable interface with close() method.
 * Close method should have logic to close the connections.
 * Most of the Database connections already implements this methods, hence they can be used with try with resources.
 * @author Sats17
 *
 */
public class CustomTryWithResources implements AutoCloseable {

	public void dbCall(boolean shouldExceptionThrow) throws Exception {
		if(shouldExceptionThrow) {
			System.out.println("Something went wrong in db connection");
			throw new Exception("Throwing exception");
		}
		System.out.println("Assume I am calling db");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Let's assume I am closing db connection");
	}
	
	public static void main(String[] args) {
		try(CustomTryWithResources closingObj = new CustomTryWithResources()) {
			closingObj.dbCall(false);
		} catch(Exception e ) {
			System.out.println(e);
		}
	}

}
