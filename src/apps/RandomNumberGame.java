package apps;


import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {


	private static Scanner shit;


	public static void main(String[] args) {


		// variables to contain game settings
		shit = new Scanner(System.in);
		int intUserResponse = 0;
		int intNumOfGuesses = 4;
		int intNumOfFails = 0;
		// variables that control the random number and its range
		int min = 1;
		int max = 20;
		Random rand = new Random();
		int intRandomAnswer = rand.nextInt(max) + min; 
		

		// output the rules of the game
		System.out.println("Guess a number between " + min + " and " + max + ".\n");


		int i = 1;
		while (i <= intNumOfGuesses) {
			// prompt message for user response
			System.out.println("\nEnter a number:");
			intUserResponse = shit.nextInt();
			

			// if the user's response equals the answer then
			// display 'game over' message and exit out of the loop
			if (intUserResponse == intRandomAnswer) {
				System.out.println("\nYou got it!! GAME OVER");
				break;

			// otherwise lets give the user hints 
			// based off their response
			} else {
				intNumOfFails += 1;
				System.out.println(intNumOfFails + " of " + intNumOfGuesses + " guesses used");
				
				if (i == intNumOfGuesses) {
					System.out.println("\nOut of attempts, you suck. number was " + intRandomAnswer);
					break;

				} else if (intUserResponse < intRandomAnswer) {
					System.out.println("hint: go higher2");
				} else if (intUserResponse < intRandomAnswer) {
					System.out.println("hint: go higher1");
				} else if (intUserResponse > intRandomAnswer) {
					System.out.println("hint: go lower");
				}

			}

			// counter that controls loop
			i++;
		}
	}

}
