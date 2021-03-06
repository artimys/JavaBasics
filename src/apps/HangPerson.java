package apps;


public class HangPerson {

	
	public int numOfTurns = 8;			// Number of times a user can guess
	private String secretWord;			// The word for the user to guess 
	private String[] maskedWord;		// Copy's the secret word by replacing each letter with an underscore. 
										// Underscores eventually get replaced by it's real letter as user guesses correctly
	private String spacer = "    ";		// Used as left padding for drawing post/hang person
			
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
	public HangPerson(String word) {
		// The word to guess
		secretWord = word;
		
		// Mask the word to guess
		setMaskedWord(secretWord);
	}



	/* 
	 *********************************************************************
	 * Setter/Getter
	 *********************************************************************
	 */
	private void setMaskedWord(String word) {
		// Let's store it in an array
		maskedWord = new String[word.length()];
		
		// Mask the letters of the secret word with an underscore
		for (int i=0; i < word.length(); i++) {
			maskedWord[i] = "_";
		}
	}
	private String getMaskedWord() {
		String cleanMaskedWord = "";
		
		// Mask the letters of the secret word with an underscore
		for (int i=0; i < maskedWord.length; i++) {
			cleanMaskedWord += maskedWord[i];
		}
		
		return cleanMaskedWord;
	}
	


	/* 
	 *********************************************************************
	 * Methods
	 *********************************************************************
	 */
	public void displayMaskedWordProgress() {
		System.out.print("The Word: ");
		
		for (int i=0; i < maskedWord.length; i++) {
			System.out.print(maskedWord[i] + " ");
		}
		
		System.out.println("\n");
	}
	
	public boolean checkLetter(String userLetter) {
		boolean foundLetter = false;
		
		for (int i=0; i < secretWord.length(); i++) {
			// Convert letter (char) to string
			String secretLetter = Character.toString( secretWord.charAt(i) );
			
			if ( secretLetter.compareToIgnoreCase(userLetter) == 0 ) {
				foundLetter = true;
				
				// Update letter in masked word
				maskedWord[i] = userLetter;
			}
		}
		
		return foundLetter;
	}

	public boolean isWordComplete() {
		if ( secretWord.compareToIgnoreCase(getMaskedWord()) == 0 ) {
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