package trivia;

// Custom class called Question
public class Question {

	// Properties for the Question class
	String prompt;
	String choices;
	String answer;

	
	// Constructor with 3 required arguments
	public Question(String p, String c, String a) {
		
		// passing the arguments value to the class' properties
		prompt = p;
		choices = c;
		answer = a;
	}

}
