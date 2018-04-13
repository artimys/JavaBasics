package apps;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		
		
		String[][] multipleChoices = new String [][] {
			{"a0", "a1", "a2", "a3"},
			{"b0", "b1", "b2", "b3"},
			{"c0", "c1", "c2", "c3"},
			
		};
		

		for (int i=0; i < multipleChoices.length; i++) {
			System.out.println("Array: " + i);
						
			for (int m=0; m < multipleChoices[i].length; m++) {
				System.out.println(multipleChoices[i][m]);
			} // end loop for m
			
		} // end loop for i
		
		
	} // end public static void main

} // end MultiDimensionalArray class
