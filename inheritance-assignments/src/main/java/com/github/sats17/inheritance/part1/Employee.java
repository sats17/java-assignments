package com.github.sats17.inheritance.part1;

/**
 * @author sats17
 *
 */
public class Employee {

	private int empId;
	private String empName;
	private double basicSal, HRA, PF;
	private double medical = 500;
	private double PT = 200;
	private double netSal, grossSal;

	/**
	 * Default Constructor
	 */
	Employee() {
		++this.empId;
	}

	/**
	 * @param empName
	 * @param basicSal
	 */
	public Employee(String empName, double basicSal) {
		this();
		this.empName = empName;
		this.basicSal = basicSal;
		this.HRA = basicSal / 2;
		this.PF = basicSal * 12 / 100;
	}

	/**
	 * @return empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return basicSal
	 */
	public double getBasicSal() {
		return basicSal;
	}

	/**
	 * @param basicSal
	 */
	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}

	/**
	 * @return HRA
	 */
	public double getHRA() {
		return HRA;
	}

	public void setHRA(double HRA) {
		this.HRA = HRA;
	}

	/**
	 * @return medical
	 */
	public double getMedical() {
		return medical;
	}

	/**
	 * @return PF
	 */
	public double getPF() {
		return this.PF;
	}

	public void setPF(double PF) {
		this.PF = PF;
	}

	/**
	 * @return PT
	 */
	public double getPT() {
		return this.PT;
	}

	/**
	 * @return netSal
	 */
	public double getNetSal() {
		return netSal;
	}

	/**
	 * @param netSal
	 */
	public void setNetSal(double netSal) {
		this.netSal = netSal;
	}

	/**
	 * @return grossSal
	 */
	public double getGrossSal() {
		return grossSal;
	}

	/**
	 * @param grossSal
	 */
	public void setGrossSal(double grossSal) {
		this.grossSal = grossSal;
	}
	
	/**
	 * @return grossSal
	 */
	public double grossSalCalculator() {
		this.grossSal = this.basicSal + this.HRA + this.medical;
		return this.grossSal;
	}
	
	/**
	 * Setting net salary.
	 */
	public double netSalCalculator() {
		double netSal = grossSalCalculator() - (this.PF + this.PT);
		this.setNetSal(netSal);
		return netSal;
	}

	/**
	 * @return
	 */
	public String displayEmpDetails() {
		return "Employee ID :-" + this.empId + "\n" + "Employee Name :-" + this.empName + "\n"
				+ "Employee Basic Salary :-" + this.basicSal + "\n" + "Employee Medical :-" + this.medical
				+ "\n" + "Employee PF :-" + this.PF + "\n" + "Employee PT :-" + this.PT + "\n"
				+ "Employee Gross Salary :-" + this.grossSal + "\n" + "Employee Net Salary :-" + this.netSal;
	};

	

}
