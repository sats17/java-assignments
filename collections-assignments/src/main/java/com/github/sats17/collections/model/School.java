package com.github.sats17.collections.model;

/**
 * @author sats17
 *
 */
public class School {

	private String name;
	private String city;
	private String district;
	private int schoolRanking;

	/**
	 * @param name
	 * @param city
	 * @param district
	 * @param schoolRanking
	 */
	public School(String name, String city, String district, int schoolRanking) {
		super();
		this.name = name;
		this.city = city;
		this.district = district;
		this.schoolRanking = schoolRanking;
	}

	/**
	 *@return boolean
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
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
		School other = (School) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
