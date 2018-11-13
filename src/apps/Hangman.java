package apps;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Hangman {

	public static void main(String[] args) {
	
		
		// Randomize the word somewhere here...
		String new_word = "arty";
		
		HangPerson hangMan = new HangPerson(new_word);


		
		Scanner shit = new Scanner(System.in);
		String userInput;
		int turn = 1;
		boolean foundMatch = false;
		String[] savedLetters = new String[100];
		
		
		
		while (turn <= hangMan.numOfTurns) {
			// Reset foundMatch
			foundMatch = false;
			
			System.out.print("\nGuess a letter (turn " + turn + ")? ");
			userInput = shit.nextLine();
						
			
			
			// Check if user entered letter twice
			if ( didUserRepeatLetter(savedLetters, userInput) ) {
				// if true, tell user they entered that letter already
				System.out.println("You already entered " + userInput + ". Try a different letter.");
				
			} else {

				// Store user letter
				savedLetters[turn-1] = userInput;
				
				// Check letter
				for (int i=0; i < hangMan.secretWord.length(); i++) {
					// Convert letter (char) to string
					String secretLetter = Character.toString(hangMan.secretWord.charAt(i));
					
					if ( secretLetter.compareToIgnoreCase(userInput) == 0 ) {
						foundMatch = true;
						hangMan.updateMaskedWordLetter(i, userInput);
					}
				}
			
				
				if (foundMatch) { // No turn is taken away
					
					// Check if winner
					if ( hangMan.isWordComplete() ) {
						// Unveil the masked word
						hangMan.displayMaskedWord();
						
						System.out.println("Congrats, you win!!");
						
						// Get out of loop
						turn = hangMan.numOfTurns + 1;

					} else {
						// Display masked word
						hangMan.displayMaskedWord();
					}
					
				} else { // Lost a turn
					
					// Check if it was the last turn
					if (turn == (hangMan.numOfTurns)) {
						System.out.println("\nGame over");
						turn++;
					} else {
						// next turn, start incrementing
						hangMan.drawHangMan(turn);
						turn++;
						
						// Display masked word
						hangMan.displayMaskedWord();
					}
				}
				
			}

		}


		
		// Close scanner
		shit.close();
	}
	
	
	
	// TODO - find a better solution
	public static boolean didUserRepeatLetter(String[] arryLetters, String userLetter) {
		boolean letterRepeated = false;
		
		for (int i=0; i < arryLetters.length; i++) {
			if ( arryLetters[i] != null ) {
				if ( arryLetters[i].compareToIgnoreCase(userLetter) == 0 ) {
					return true;
				}
			}
		}
		
		return letterRepeated;
	}
	
	

}