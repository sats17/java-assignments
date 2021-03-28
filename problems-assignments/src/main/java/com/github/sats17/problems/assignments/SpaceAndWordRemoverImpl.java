package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class SpaceAndWordRemoverImpl {

	public static String refractorer(String string, String word,int position) throws WrongInputException {
		
		// Splittig array with space or more space found.
		String[] wordsArr = string.split("\\W+");
		
		if(position > wordsArr.length) {
			throw new WrongInputException("Please Enter correct position.");
		}
		if(!wordsArr[position - 1].equals(word)) {
			throw new WrongInputException("Your given word and position not matched.");
		}
		String updatedString = "";
		
		for(int i = 0;i < wordsArr.length;i++) {
			/*
			 * If given word and position matches to current iterator,
			 * then simply ignore it.
			 */
			if(wordsArr[i].equals(word) && i == position - 1) {
				continue;
			}	
			/*
			 * If current iterator is last of array , 
			 * then do not add space to last to it.
			 */
			else if(i == wordsArr.length - 1) {
				updatedString = updatedString+wordsArr[i];
			}
			/*
			 * Here we just updating string by adding 
			 */
			else {
				updatedString = updatedString+wordsArr[i]+" ";
			}
		}
		return updatedString;
	}

}
