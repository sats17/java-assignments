package com.github.sats17.main;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class StringUpperCaseConverter {

	public static ArrayList<String> convert(ArrayList<String> data) {
		data.replaceAll(string -> string.toUpperCase());
		return data;
	}
}
