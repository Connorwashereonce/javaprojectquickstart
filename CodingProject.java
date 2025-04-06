package codingProjectweek4;

public class CodingProject {

	public static void main(String[] args) {
		// Array of Ages
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		//subtract first age from last age in array
		int result = ages[ages.length - 1] - ages[0];
		//print result
		 System.out.println("After subtracting the first and last age we get: " + result);
	
		//  create the new ages2 array with 9 elements
	        int[] ages2 = {5, 20, 25, 40, 50, 35, 45, 13, 150};
	        
	        //  subtract the first element from the last element of ages2
	        int result2 = ages2[ages2.length - 1] - ages2[0];
	        System.out.println("After subtracting the first and last age in the array we get: " + result2);

	        // this shows dynamic indexing by accessing various array elements
	       
	        System.out.println("First element: " + ages2[0]);
	        System.out.println("Last element: " + ages2[ages2.length - 1]);
	        
	     // initialize the variable sum to store the sum of ages
	        int sum = 0;

	        // Loop through the ages2 array and calculate the sum
	        for (int i = 0; i < ages2.length; i++) {
	            sum += ages2[i]; 
	        }

	        
	        double average = (double) sum / ages2.length;

	        
	        System.out.println("The average age is: " + average);
	        
	        
	        // array of names
	        
	        String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};

	        // shows the average length of the names
	        int totalLetters = 0;
	        for (String name : names) {
	            totalLetters += name.length();
	        }
	        double averageLetters = (double) totalLetters / names.length;
	        System.out.println("Average number of letters per name in the array of names: " + averageLetters);

	        // creates a space between each name in the array
	        StringBuilder allNames = new StringBuilder();
	        for (int i = 0; i < names.length; i++) {
	            allNames.append(names[i]);
	            if (i < names.length - 1) {
	                allNames.append(" ");
	            }
	        }
	        System.out.println(allNames.toString());
	        
    //How do you access the last element of any array?
    // Answer: array[array.length - 1]
    //How do you access the first element?
    //Answer: array[0]
	        
	        //  new integer array to store name lengths
	        int[] nameLengths = new int[names.length];

	        // loop through the array
	        for (int i = 0; i < names.length; i++) {
	            nameLengths[i] = names[i].length();
	        }

	        // print
	        System.out.println("Lengths of each name:");
	        for (int length : nameLengths) {
	            System.out.println(length);
	        }
	        
	        int sum2 = 0;
	        for (int length : nameLengths) {
	            sum2 += length;
	        }

	        
	        System.out.println("Sum of all name lengths: " + sum2);
		
	}
	
	//method that takes an integer and a string and prints the word "int" amount of times:
	public static String repeatWord(String word, int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(word);
        }

        return result.toString();
    }//method which checks if the sum of numbers in an array is greater than 100
	public static boolean isSumGreaterThan100(int[] numbers) {
        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        return sum > 100;
   
	    }//method that decides whether or not you buy a drink based on the money in your pocket
	 public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
	        return isHotOutside && moneyInPocket > 10.50;
	    }
//my own method which determines if you can move into an apartment.
	 
	 public static boolean moveinto2bdApartment(double monthlyIncome, double roomateIncome) {
		 return roomateIncome > 2000 && monthlyIncome > 2000;
		 
	 }
}
	 

