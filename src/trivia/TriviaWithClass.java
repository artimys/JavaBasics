package trivia;

import java.util.Scanner;

public class TriviaWithClass {

	public static void main(String[] args) {
		Scanner shit = new Scanner(System.in);
		String userResponse;
		int score = 0;

		Question[] questions = new Question[] {
				new Question("What color is the sun?", "a) red\nb) yellow", "b"),	// custom class Question (prompt, multiple-choice, answer)
				new Question("What color is the sky?", "a) red\nb) blue", "b"),
				new Question("Is Jean super gay?", "a) True\nb) False", "a")
		};

		
		for (int i=0; i < questions.length; i++) {
			System.out.println("\n" + questions[i].prompt);
			System.out.println(questions[i].choices);

			System.out.print("Your answer: ");
			userResponse = shit.nextLine();

			if (userResponse.compareToIgnoreCase(questions[i].answer) == 0) {
				score++;
			}
		}

		System.out.println("\n\nResults");
		System.out.println("----------------------");
		System.out.println("You got " + score + "/" + questions.length + " correct.");
		
		shit.close();
	}

}
