package com.github.sats17.collections.model;

public class CellPhone {

	private String company;
	private String model;
	private String description;
	private String operatingSystem;
	private double price;

	/**
	 * @param company
	 * @param model
	 * @param description
	 * @param operatingSystem
	 * @param price
	 */
	public CellPhone(String company, String model, String description, String operatingSystem, double price) {
		super();
		this.company = company;
		this.model = model;
		this.description = description;
		this.operatingSystem = operatingSystem;
		this.price = price;
	}

	/**
	 *@return result
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
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
		CellPhone other = (CellPhone) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (operatingSystem == null) {
			if (other.operatingSystem != null)
				return false;
		} else if (!operatingSystem.equals(other.operatingSystem))
			return false;
		return true;
	}

}
