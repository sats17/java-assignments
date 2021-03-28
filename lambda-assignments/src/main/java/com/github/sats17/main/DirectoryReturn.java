package com.github.sats17.main;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class DirectoryReturn {
	public static ArrayList<String> getSubDirectory(String filePath) throws IOException {
		File fileObj = new File(filePath);
		ArrayList<String> paths = new ArrayList<String>();
	
		File[] files = fileObj.listFiles(File::isDirectory);
		for(File file:files) {
			paths.add(file.getPath());
		}
		return paths;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(getSubDirectory("."));
	}

}
