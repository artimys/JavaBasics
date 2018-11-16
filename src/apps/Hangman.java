package apps;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {


		// Randomize the word somewhere here...
		HangBaby hangMan = new HangBaby("arty simon");

		Scanner shit = new Scanner(System.in);
		String userInput;
		boolean foundMatch = false;
		String[] savedLetters = new String[100]; // TODO - ugly
		int turn = 1;
		
		
		
		while (turn <= hangMan.numOfTurns) {
			// Reset flag foundMatch
			foundMatch = false;
			
			System.out.print("\nGuess a letter (turn " + turn + ")? ");
			userInput = shit.nextLine();
			
			
			
			// Check if user entered letter twice
			if ( didUserRepeatLetter(savedLetters, userInput) ) {
				
				// if true, tell user they entered that letter already
				System.out.println("You already entered " + userInput + ". Try a different letter.");
				
			} else {

				// Store user's letter
				savedLetters[turn-1] = userInput;
				
				// Check letter by passing user's input,
				// returns true if match found
				foundMatch = hangMan.checkLetter(userInput);
				
				if (foundMatch) { // No turn is taken away if guess is correct
					
					// Display to console current progress of masked word
					hangMan.displayMaskedWordProgress();
					
					// Check if winner
					if ( hangMan.isWordComplete() ) {
						System.out.println("Congrats, you win!!");
						
						// Get out of loop
						turn = hangMan.numOfTurns + 1;
					}
				
				} else { // Lost a turn

					// Display hang person and masked word
					hangMan.displayHangMan(turn);
					hangMan.displayMaskedWordProgress();
					
					// Check if this is last turn
					if (turn == (hangMan.numOfTurns)) {
						System.out.println("\nGame over");
					}
					
					// Continue to next turn
					turn++;
					
				} // end if foundMatch
			} // end if didUserRepeatLetter
		} // end while


		
		// Close scanner
		shit.close();
	}
	
	
	
	// TODO - find a better solution
	public static boolean didUserRepeatLetter(String[] arryLetters, String userLetter) {
		for (int i=0; i < arryLetters.length; i++) {
			if ( arryLetters[i] != null ) {
				if ( arryLetters[i].compareToIgnoreCase(userLetter) == 0 ) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	

}