package com.github.sats17.collections.model;

public class Student implements Comparable<Student> {

	private String name;
	private String favFood;

	/**
	 * @param string
	 * @param favFood
	 */
	public Student(String string, String favFood) {
		this.name = string;
		this.favFood = favFood;
	}

	/**
	 *@return boolean
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 *@return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 *@return boolean
	 *compare by name
	 */
	@Override
	public int compareTo(Student obj) {

		return this.name.compareTo(obj.name);
	}

	/**
	 *@return String
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	/**
	 * @return the favFood
	 */
	public String getFavFood() {
		return favFood;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param favFood the favFood to set
	 */
	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}

	



}
