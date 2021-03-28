package com.github.sats17.inheritance.part1;

/**
 * @author sats17
 *
 */
public class MarketingExecutive extends Employee {

	private int kmTravel;
	private int tourAllowance;
	private int telephoneAllowance = 1500;

	/**
	 * @param name
	 * @param basicSalary
	 * @param kmTravel
	 */
	public MarketingExecutive(String name, double basicSalary, int kmTravel) {
		super(name, basicSalary);
		this.kmTravel = kmTravel;
		this.tourAllowance = kmTravel * 5;
		grossSalCalculator();
		netSalCalculator();
		
	}

	/**
	 * @return kmTravel
	 */
	public int getKmTravel() {
		return kmTravel;
	}

	/**
	 * @param kmTravel
	 */
	public void setKmTravel(int kmTravel) {
		this.kmTravel = kmTravel * 5;
	}

	/**
	 * @return tourAllowance
	 */
	public int getTourAllowance() {
		return tourAllowance;
	}

	/**
	 * @param tourAllowance
	 */
	public void setTourAllowance(int tourAllowance) {
		this.tourAllowance = tourAllowance;
	}

	/**
	 * @return telephoneAllowance
	 */
	public int getTelephoneAllowance() {
		return telephoneAllowance;
	}

	/**
	 * @param telephoneAllowance
	 */
	public void setTelephoneAllowance(int telephoneAllowance) {
		this.telephoneAllowance = telephoneAllowance;
	}

	@Override
	public String displayEmpDetails() {
		return super.displayEmpDetails()
				+ "\n" + "Employee Tour Allowance :-" + this.tourAllowance + "\n" + "Employee Telephone Allowance :-"
				+ this.telephoneAllowance;
	}

	/**
	 * Setting gross salary.
	 */
	@Override
	public double grossSalCalculator() {
		double grossSal = super.grossSalCalculator() + this.telephoneAllowance
				+ this.tourAllowance;
		super.setGrossSal(grossSal);
		return grossSal;

	}
	
	/**
	 * Setting net salary.
	 */
	public double netSalCalculator() {
		return super.netSalCalculator();
	}

}
