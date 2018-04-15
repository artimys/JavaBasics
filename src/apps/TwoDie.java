package apps;

import java.util.Random;

public class TwoDie {

	public static void main(String[] args) {
		Random die = new Random();
		// Variables to hold each die roll
		int die_one_roll;
		int die_two_roll;
		// Variable to hold number of times a double was rolled
		int rolled_double_score = 0;
		
		// Loop 25 times, starting at 1
		for (int i=1; i <= 25; i++) {
			// Get random number between 1 and 6 for each die
			die_one_roll = die.nextInt(6) + 1;
			die_two_roll = die.nextInt(6) + 1;
			
			// Display iteration and die rolls
			System.out.println("\nIteration: " + i);
			System.out.println("Die 1: " + die_one_roll);
			System.out.println("Die 2: " + die_two_roll);
			
			// 
			if (die_one_roll == die_two_roll) {
				rolled_double_score++;
				System.out.println("You rolled a double!!"); // Test line to see if rolled double
			}
			
		}

		// Game is over and displaying how many times two die rolled double
		System.out.println("\nGame Over");
		System.out.println("You rolled a double " + rolled_double_score + " times.");
	}

}