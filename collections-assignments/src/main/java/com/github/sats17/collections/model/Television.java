package com.github.sats17.collections.model;

import com.github.sats17.collections.util.TelevisionType;

public class Television {

	private String company;
	private TelevisionType type;
	private boolean is3D;
	private double price;

	/**
	 * @param company
	 * @param type
	 * @param is3d
	 * @param price
	 */
	public Television(String company, TelevisionType type, boolean is3d, double price) {
		super();
		this.company = company;
		this.type = type;
		this.is3D = is3d;
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Television other = (Television) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
