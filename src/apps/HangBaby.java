package apps;


public class HangBaby {

	
	public int numOfTurns = 8;									// Number of times a user can guess
	private String secretWord;									// The word for the user to guess
	private StringBuilder maskedWord = new StringBuilder();		// Copy the secret word by substituting each letter with an underscore.
																// Underscores eventually get replaced by it's real letter as user guesses correctly
	private String spacer = "    ";								// Used as left padding for drawing post/hang person		
	private String[] bodyParts = new String[6];
	/*  
		Contains the structure of building the post/hang person.
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|     /|\\");
		System.out.println("|     / \\");
		System.out.println("|");
	*/
	
	
	
	
	
	/* 
	 *********************************************************************
	 * Constructor
	 *********************************************************************
	 */
	public HangBaby(String word) {
		// The word to guess
		secretWord = word;
		
		// Mask the letters of the secret word to the StringBuilder variable.
		// Regular expression is used to replace letters a-z with _
		maskedWord.append( secretWord.replaceAll("[a-zA-Z]", "_") );
	}

	

	/* 
	 *********************************************************************
	 * Methods
	 *********************************************************************
	 */
	public void displayMaskedWordProgress() {
		// Display masked word with a space between each letter
		System.out.print( "The Word: " + maskedWord.toString().replace("", " ").trim() );
		System.out.println("\n");
	}
	
	public boolean checkLetter(String userLetter) {
		boolean foundLetter = false;
		
		for (int i=0; i < secretWord.length(); i++) {
			// Convert letter (char) to string
			String secretLetter = Character.toString( secretWord.charAt(i) );
			
			// Check if letter from secretWord matches user's letter
			if ( secretLetter.compareToIgnoreCase(userLetter) == 0 ) {
				foundLetter = true;
				
				// Update letter in masked word
				maskedWord.replace(i, i+1, userLetter);
			}
		}
		
		return foundLetter;
	}

	public boolean isWordComplete() {
		if ( secretWord.compareToIgnoreCase(maskedWord.toString()) == 0 ) {
			return true;
		}
				
		return false;
	}



	/* 
	 *********************************************************************
	 * Methods - Build/draw post and hang person
	 *********************************************************************
	 */
	public void displayHangMan(int turn) {
		switch (turn) {
			case 1 :
				addPost();
				break;
			case 2 :
				addHead();
				break;
			case 3 :
				addTorso();
				break;
			case 4 :
				addBothArms(false); // Will only draw 1
				break;
			case 5 :
				addBothArms(true);
				break;
			case 6 :
				addBothLegs(false); // Will only draw 1
				break;
			case 7 :
				addBothLegs(true);
				break;
			case 8 :
				addNoose();
				break;
			default :
				// ?
		}
		
		
		// Print out hang man in console
		System.out.println("\n");
		for( int i=0; i < bodyParts.length; i++ ) {
			System.out.println( bodyParts[i] );
		}
		System.out.println("-------------------------------------------");
	}

	private void addPost() {
		bodyParts[0] = spacer + " ______";
		bodyParts[1] = spacer + "|";
		bodyParts[2] = spacer + "|";
		bodyParts[3] = spacer + "|";
		bodyParts[4] = spacer + "|";
		bodyParts[5] = spacer + "|";
	}

	private void addNoose() {
		bodyParts[1] = spacer + "|      |   <--- you dead";
	}
	
	private void addHead() {
		bodyParts[2] = spacer + "|      O";
	}

	private void addTorso() {
		bodyParts[3] = spacer + "|      |";
	}

	private void addBothArms(boolean includeBothArms) {
		if (includeBothArms)
			bodyParts[3] = spacer + "|     /|\\";
		else
			bodyParts[3] = spacer + "|     /|";
	}
	
	private void addBothLegs(boolean includeBothLegs) {
		if (includeBothLegs)
			bodyParts[4] = spacer + "|     / \\";
		else
			bodyParts[4] = spacer + "|     /";
	}
	
}