package apps;

import java.util.Scanner;

public class Trivia {
	

	private static Scanner shit;


	public static void main(String[] args) {
		shit = new Scanner(System.in);
		String UserResponse;
		// Array of questions
		String[] questions = {"What's your name?",
				"Hold old are you?",
				"What is your gender?",
				"Is Jean gay?",
				"Is Jean REALLY gay?",
				"Does Jean have balls?"
		};
		// Array of answers
		String[] answers = {"chris",
				"34",
				"male",
				"yes",
				"yes",
				"no"
		};
		
		
		// Intro line
		System.out.println("There are " + questions.length + " questions. Don't fuck up.");
		
		
		// Loop through questions
		for (int i=0; i < questions.length; i++) {
			
			// Print question
			System.out.println("\n" + (i+1) + ") " + questions[i]);
			// Get answer from user
			UserResponse = shit.nextLine();

			if (UserResponse.compareToIgnoreCase(answers[i]) == 0) {
				System.out.println("You're right");
			} else {
				System.out.println("Fucken wrong");
			} // end if else
			
		} // end for loop
		
		
		
		
	} // end public static void main

} // end public Trivia class
