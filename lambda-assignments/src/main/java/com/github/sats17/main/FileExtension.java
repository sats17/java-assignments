package com.github.sats17.main;

import java.io.File;
import java.util.ArrayList;

public class FileExtension {
	
	public static ArrayList<String> add(String path){
		
		File filePath = new File(path);
		ArrayList<String> paths = new ArrayList<String>();
		File[] files = filePath.listFiles((filter,string) -> filter.isFile());
		for(File file:files) {
			paths.add(file.getName()+".txt");
		}
		return paths;
		
	}

	public static void main(String[] args) {
		System.out.println(add("."));

	}

}
