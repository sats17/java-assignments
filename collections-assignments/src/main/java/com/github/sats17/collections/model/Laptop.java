package com.github.sats17.collections.model;

public class Laptop {
	
	private String company;
	private String model;
	private String operatingType;
	private String processor;
	
	
	public Laptop(String company, String model, String operatingType, String processor) {
		super();
		this.company = company;
		this.model = model;
		this.operatingType = operatingType;
		this.processor = processor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		Laptop other = (Laptop) obj;
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
		return true;
	}
	
//	public static void main(String[] args) {
//		Laptop p = new Laptop("dell", "sats", "ubuntu", "i3");
//		Laptop s = new Laptop("dell","sats","ubuntu","i3");
//		if(s.equals(p)) {
//			System.out.println("True");
//			System.out.println("p="+p.hashCode());
//			System.out.println("s="+s.hashCode());
//		}
//		else {
//			System.out.println("False");
//			System.out.println("p="+p.hashCode());
//			System.out.println("s="+s.hashCode());
//		}
//	}
	
	
}
