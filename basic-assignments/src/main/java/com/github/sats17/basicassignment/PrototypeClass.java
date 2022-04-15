package com.github.sats17.basicassignment;

import java.util.HashMap;
import java.util.Map;

public class PrototypeClass implements Cloneable {
	
	private String name;
	private Map<String, String> dbData;

	@Override
	protected PrototypeClass clone() throws CloneNotSupportedException {
		PrototypeClass clonedClass = new PrototypeClass();
		clonedClass.setDbData(new HashMap<>());
		this.dbData.forEach((key, value) -> {
			clonedClass.getDbData().put(key, value);
		});
		return clonedClass;
	}

	/**
	 * Suppose data is loading from DB
	 */
	public void load() {
		this.dbData = new HashMap<>();
		dbData.put("test", "test1");
		dbData.put("test12", "asf");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getDbData() {
		return dbData;
	}

	public void setDbData(Map<String, String> dbData) {
		this.dbData = dbData;
	}
	
	
	
	
	@Override
	public String toString() {
		return "PrototypeClass [name=" + name + ", dbData=" + dbData + "]";
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		PrototypeClass originalClass = new PrototypeClass();
		originalClass.load();
		PrototypeClass clonedClass = originalClass.clone();
		originalClass.getDbData().remove("test");
		System.out.println("Original class data "+originalClass.toString());
		System.out.println("Cloned class data "+clonedClass.toString());
		System.out.println("Cloned instance address "+clonedClass.hashCode());
		System.out.println("Original instance address "+originalClass.hashCode());
	}
	
	
}
