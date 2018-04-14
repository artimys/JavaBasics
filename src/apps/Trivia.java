package apps;

import java.util.Scanner;

public class Trivia {
	
	private static Scanner shit;


	public static void main(String[] args) {
		shit = new Scanner(System.in);
		String userResponse;
		int numOfCorrectAnswers = 0;
		// Array of questions
		String[] questions = {
			"Solve equation, 2 + 1 = ",
			"Hold old are you?",
			"What is your gender?",
			"Is Jean gay?",
			"Is Jean REALLY gay?",
			"Does Jean have balls?"
		};
		
		// Multiple choices
		String[][] multipleChoices = new String [][] {
			{"a) 1", "b) 2", "c) 3", "d) 4"},
			{"a) 1", "b) 2", "c) 3", "d) 4"},
			{"a) 1", "b) 2", "c) 3", "d) 4"},
			{"a) 1", "b) 2", "c) 3", "d) 4"},
			{"a) 1", "b) 2", "c) 3", "d) 4"},
			{"a) 1", "b) 2", "c) 3", "d) 4"}
		};
		
		// Array of answers
		String[] answers = { "2", "1", "2", "0", "1", "2" };
		
		
		// Introduction line
		System.out.println("There are " + questions.length + " questions. Don't fuck up.");
		
		
		// Loop through questions
		for (int i=0; i < questions.length; i++) {
			
			// Print question
			System.out.println("\n" + (i+1) + ". " + questions[i]);
			// Display multiple choices
			for (int m=0; m < multipleChoices[i].length; m++) {
				System.out.println("   " + multipleChoices[i][m]);
			}
			
			// Prompt and get answer from user
			System.out.println("\nYour answer:");
			userResponse = shit.nextLine();
			
			// Convert letter answer to array index
			switch (userResponse) {
				case "a":
					userResponse = "0";
					break;
				case "b":
					userResponse = "1";
					break;
				case "c":
					userResponse = "2";
					break;
				case "d":
					userResponse = "3";
					break;
				default:
					userResponse = "Invalid value";
					break;
			}

			if (userResponse.compareToIgnoreCase(answers[i]) == 0) {
				numOfCorrectAnswers++;
			}
			
		} // end for loop
		
		
		// Display results
		System.out.println("\n\nYou got " + numOfCorrectAnswers + "/" + questions.length + " right.");
		
		
	} // end public static void main

} // end public Trivia class
