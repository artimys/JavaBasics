package trivia;

import java.util.Scanner;

public class TriviaWithArray {

	public static void main(String[] args) {
		Scanner shit = new Scanner(System.in);
		String userResponse;
		int score = 0;
		
		String[] questions = new String[] {
			"What color is the sun?\na) red\nb) yellow",	// index 0
			"What color is the sky?\na) red\nb) blue",		// index 1
			"Is Jean super gay?\na) True\nb) False"			// index 2
		};
		String[] answers = new String[] {
				"b",	// index 0 
				"b",	// index 1
				"a" 	// index 2
		};
		

		for (int i=0; i < questions.length; i++) {
			// Display question with multiple choice
			System.out.println("\n" + questions[i]);

			// Get user's input
			System.out.print("Your answer: ");
			userResponse = shit.nextLine();

			if (userResponse.compareToIgnoreCase(answers[i]) == 0) {
				// Add 1 to score
				score++;
				// play audio for correct answer
			} else {
				// play audio for incorrect answer
			}
		}

		System.out.println("\n\nResults");
		System.out.println("----------------------");
		System.out.println("You got " + score + "/" + questions.length + " correct.");

		shit.close();
	}

}