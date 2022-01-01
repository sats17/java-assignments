package com.github.sats17;

/**
 * This is momos plate object
 * 
 * @author Sats17
 *
 */
public class BuilderDesignPattern {

	private int pieces;
	private String type;
	private boolean schezwanChutney;
	private boolean whiteSauce;

	public static class Builder {
		private int pieces;
		private String type;
		private boolean schezwanChutney;
		private boolean whiteSauce;

		public Builder() {
		}

		public Builder pieces(int pieces) {
			this.pieces = pieces;
			return this;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder schezwanChutney() {
			this.schezwanChutney = true;
			return this;
		}

		public Builder whiteSauce() {
			this.whiteSauce = true;
			return this;
		}

		public BuilderDesignPattern build() {
			return new BuilderDesignPattern(this);
		}
	}
	
	private BuilderDesignPattern(Builder pattern) {
		this.pieces = pattern.pieces;
		this.type = pattern.type;
		this.schezwanChutney = pattern.schezwanChutney;
		this.whiteSauce = pattern.whiteSauce;
	}
	
	@Override
	public String toString() {
		return "BuilderDesignPattern [pieces=" + pieces + ", type=" + type + ", schezwanChutney=" + schezwanChutney
				+ ", whiteSauce=" + whiteSauce + "]";
	}

	public static void main(String[] args) {
		Builder builder = new BuilderDesignPattern.Builder().pieces(5).type("veg");
		System.out.println(builder.build());
	}
}
