package apps;


public class HangPerson {

	
	int numOfTurns = 8;
	String secretWord;
	String[] maskedWord;
	String spacer = "    ";
			
	private static String[] bodyParts = new String[6];
	/*
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|     /|\\");
		System.out.println("|     / \\");
		System.out.println("|");
	*/
	
	
	
	// CONSTRUCTOR
	public HangPerson(String word) {
		// The word to guess
		secretWord = word;
		
		// Mask the word to guess
		setMaskedWord(secretWord);
	}

	
	// ---------------------------------------------------
	public void setMaskedWord(String word) {
		// Let's store it in an array
		maskedWord = new String[word.length()];
		
		// Mask the letters of the secret word with an underscore
		for (int i=0; i < word.length(); i++) {
			maskedWord[i] = "_";
		}
	}
	public String getMaskedWord() {
		String cleanMaskedWord = "";
		
		// Mask the letters of the secret word with an underscore
		for (int i=0; i < maskedWord.length; i++) {
			cleanMaskedWord += maskedWord[i];
		}
		
		return cleanMaskedWord;
	}
	
	public void displayMaskedWord() {
		System.out.print("The Word: ");
		
		for (int i=0; i < maskedWord.length; i++) {
			System.out.print(maskedWord[i] + " ");
		}
		
		System.out.println("\n");
	}
	

	public void updateMaskedWordLetter(int position, String letter) {
		maskedWord[position] = letter;
	}
	// ---------------------------------------------------
	

	
	
	public boolean isWordComplete() {
		if ( secretWord.compareToIgnoreCase(getMaskedWord()) == 0 ) {
			return true;
		}
				
		return false;
	}
	
	
	
	
	
	
	

	public void drawHangMan(int turn) {
		switch (turn) {
			case 1 :
				drawPost();
				break;
			case 2 :
				drawHead();
				break;
			case 3 :
				drawTorso();
				break;
			case 4 :
				drawBothArms(false); // Will only draw 1
				break;
			case 5 :
				drawBothArms(true);
				break;
			case 6 :
				drawBothLegs(false); // Will only draw 1
				break;
			case 7 :
				drawBothLegs(true);
				break;
			case 8 :
				drawNoose();
				break;
			default :
				// ?
		}
	}
	
	
	
	
	
	

	private void drawPost() {
		bodyParts[0] = spacer + " ______";
		bodyParts[1] = spacer + "|";
		bodyParts[2] = spacer + "|";
		bodyParts[3] = spacer + "|";
		bodyParts[4] = spacer + "|";
		bodyParts[5] = spacer + "|";
		
		displayStage();
	}

	private void drawNoose() {
		bodyParts[1] = spacer + "|      |   <--- you dead";
		displayStage();
	}
	
	private void drawHead() {
		bodyParts[2] = spacer + "|      O";
		displayStage();
	}

	private void drawTorso() {
		bodyParts[3] = spacer + "|      |";
		displayStage();
	}

	private void drawBothArms(boolean includeBothArms) {
		if (includeBothArms) {
			bodyParts[3] = spacer + "|     /|\\";
		} else {
			bodyParts[3] = spacer + "|     /|";
		}
		
		displayStage();
	}
	
	private void drawBothLegs(boolean includeBothLegs) {
		if (includeBothLegs) {
			bodyParts[4] = spacer + "|     / \\";
		} else {
			bodyParts[4] = spacer + "|     /";
		}

		displayStage();
	}
	
	private void displayStage() {
		System.out.println("\n");
		
		for( int i=0; i < bodyParts.length; i++ ) {
			System.out.println( bodyParts[i] );
		}

		System.out.println("-------------------------------------------\n");
	}

	
}