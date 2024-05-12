package com.github.sats17.basicassignment.designPattern;

public class StaticBuilderPattern {
	private String key;
	private String value;

	private StaticBuilderPattern() {
		// Private constructor to prevent direct instantiation
	}

	// Getter methods
	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	// Static method to create a builder instance
	public static Builder builder() {
		return new Builder();
	}

	// Builder class for fluent object creation
	public static class Builder {
		private String key;
		private String value;

		private Builder() {
			// Private constructor to enforce usage of builder() method
		}

		// Setter methods with method chaining
		public Builder key(String key) {
			this.key = key;
			return this;
		}

		public Builder value(String value) {
			this.value = value;
			return this;
		}

		// Build method to instantiate KeyValue object
		public StaticBuilderPattern build() {
			StaticBuilderPattern keyValue = new StaticBuilderPattern();
			keyValue.key = this.key;
			keyValue.value = this.value;
			return keyValue;
		}
	}

	@Override
	public String toString() {
		return "KeyValue{" + "key='" + key + '\'' + ", value='" + value + '\'' + '}';
	}

	public static void main(String[] args) {
		// Create a KeyValue object using the builder pattern
		StaticBuilderPattern keyValue = StaticBuilderPattern.builder().key("name").value("John Doe").build();

		// Print the created KeyValue object
		System.out.println(keyValue);
	}
}
