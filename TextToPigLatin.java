import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Program: Text to Pig Latin
* File: TextToPigLatin.java
* Summary: Reads text from a file and outputs each word and its Pig Latin equivalent. 
* Author: Chris Hyde
* Date: November 3, 2017 
**/

public class TextToPigLatin {

	public static void main(String[] args) {
		// Variables
		// If text file is moved change filePath to new file location directory.
		String filePath = "J:\\\\GCU\\\\Programming 1(CST-105)\\\\Assignments\\\\Week3CHyde\\\\week3_workspace\\\\ProgrammingExercise4\\\\src\\\\Exercise4_Text.txt";
		String entireText = "";
		
		// Try-Catch to make sure file is present. 
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

			String readLine = "";

			// Start while loop
			while ((readLine = bufferedReader.readLine()) != null) {
				entireText += readLine; // Set each line that is read to the entireText String variable.
			} 
			// End while loop

			bufferedReader.close(); // Close the Buffered Reader
		}
		catch (IOException e) { // Catch starts
			e.printStackTrace();
		} // Catch ends. 

		//Run the method printTranslation
		printTranslation(entireText);

	}

	// Method for getting each word from the entireText variable and printing it along side its Pig Latin Equivalent. 
	public static void printTranslation(String entireText) {
		String[] wordArray = entireText.split(" "); // split entireText by white space.

		// Loop through every word in the wordArray and print it to console with it's Pig Latin equivalent in a formated fashion.
		for (String word : wordArray) {

			System.out.printf("%-16s%-16s\n", word, translate(word)); // Print the original word and translation in formated rows to console.
		}

	}
	
	// Method for translating each word into Pig Latin
	public static String translate(String word) {
		// Method variables.
		int vowelIndex = 0;
		int wordLength = word.length();
		String pigLatin = "";

		// Loop through the word marking at what point the first vowel is.
		for (int i = 0; i < wordLength; i++) {
			// Gets the char at i and sets it to lower case for comparing to vowels.
			char letter = Character.toLowerCase(word.charAt(i));

			// If a letter of a word equals a vowel break loop
			if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
				vowelIndex = i; // Set the value of firstVowel the index of the character in the word.
				break; // Exit loops
			}

		}

		// Rearrange word into Pig Latin.
		// First test if it starts with a vowel
		if (vowelIndex == 0) {
			pigLatin = word + "way"; // Put way on end of any word starting with a vowel.
		} else {
			// Create substring of characters to add to the end of the word.
			String toEnd = word.substring(0, vowelIndex);
			
			// Create a substring of the new start of the word.
			String newStart = word.substring(vowelIndex, wordLength);

			// Combine both substrings together and add ay.
			pigLatin = newStart + toEnd + "ay";
		}

		return pigLatin.toUpperCase(); // returns the word translated into Pig Latin
	}

}
