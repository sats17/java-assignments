package com.github.sats17.inheritance.part1;

/**
 * @author sats17
 *
 */
public class Manager extends Employee {

	private double petrolAllowance;
	private double foodAllowance;
	private double otherAllowance;
	
	/**
	 * @param name
	 * @param basicSalary
	 */
	/**
	 * @param name
	 * @param basicSalary
	 */
	public Manager(String name, double basicSalary) {
		super(name, basicSalary);
		this.petrolAllowance = basicSalary * 8 / 100;
		this.foodAllowance = basicSalary * 13 / 100;
		this.otherAllowance = basicSalary * 3 / 100;
		

	}

	/**
	 * @return petrolAllowance
	 */
	public double getPetrolAllowance() {
		return petrolAllowance;
	}

	/**
	 * @param petrolAllowance
	 */
	public void setPetrolAllowance(double petrolAllowance) {
		this.petrolAllowance = petrolAllowance * 8 / 100;
	}

	/**
	 * @return foodAllowance
	 */
	public double getFoodAllowance() {
		return foodAllowance;
	}

	/**
	 * @param foodAllowance
	 */
	public void setFoodAllowance(double foodAllowance) {
		this.foodAllowance = foodAllowance * 13 / 100;
	}

	/**
	 * @return otherAllowance
	 */
	public double getOtherAllowance() {
		return otherAllowance;
	}

	/**
	 * @param otherAllowance
	 */
	public void setOtherAllowance(double otherAllowance) {
		this.otherAllowance = otherAllowance * 3 / 100;

	}

	@Override
	public String displayEmpDetails() {

		return  super.displayEmpDetails()
				+ "\n" + "Employee Petrol Allowance :-" + this.petrolAllowance + "\n" + "Employee Food Allowance :-"
				+ this.foodAllowance + "\n" + "Employee Other Allowance :-" + this.otherAllowance;
	}

	/**
	 * Setting gross salary.
	 */
	@Override
	public double grossSalCalculator() {
		double grossSal = super.grossSalCalculator() + this.foodAllowance
				+ this.otherAllowance + this.petrolAllowance;
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
