/**
 * Program to check every permutation of weights to determine
 * which is most optimal for inserting the names in mydata.txt
 * 
 * @author: Isa Alatovic
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Optimize {
    private static int minProbes = 1000000; // Arbitrarily large number to start with
    private static int numOfPerms = 0; // Number of permutations that have the same minimum probe count
	private static ArrayList<String> names = new ArrayList<>(); // List to store names from mydata.txt

    /**
     * Method to generate the nth permutation of the weights. This is done by converting n in base 10 to base 5
     * (with leading zeros so that the length is 9) and then using the digits of that number as the weights.
     * @param n
     * @return int[] weights
     */
    private static int[] weightsPerm(int n) {
        String numstring = String.format("%9s", Integer.toString(n, 5)).replace(' ', '0');
        int[] weights = new int[numstring.length()];
		for (int i = 0; i < numstring.length(); i++) {
			weights[i] = Character.getNumericValue(numstring.charAt(i)); // Convert char to int
		}
        return weights;
    }

    /**
     * Method to get names from mydata.txt
     *
     */
    private static void getData() {
    	try {
			Scanner fileIn = new Scanner(new File("mydata.txt"));
			while (fileIn.hasNextLine()) {
				String name = fileIn.nextLine();
				names.add(name); // Add name to the list
			}
			fileIn.close();

		} catch (Exception e) {
			System.out.println("File not found.");
		}

    }

	/**
	 * Method to load names into the hash table
	 * 
	 * @param table
	 */
	private static void loadData(LPHashTable table) {
		for (String name : names) {
			table.insert(name); // Insert each name into the hash table
		}
	}

	/**
	 * Experiment method to find the optimal weights for the hash function.
	 * This method iterates through all permutations of weights (0-4) for a hash table of size 37.
	 */
    public static void experiment() {
        for (int i = 0; i < 1953125; i++) { // 5^9 = 1953125 = number of permutations of weights
            int[] weights = weightsPerm(i); 
            LPHashTable table = new LPHashTable(37);
            table.setWeights(weights); //Set weights for hash function
			table.resetProbeCount(); //Set probe count to 0

			loadData(table);
            
			int probeCount = table.getProbeCount();
            if (probeCount < minProbes) { // Update minProbes if current probe count is less
                minProbes = probeCount;
				numOfPerms = 1; // Reset numOfPerms to 1 for the new minimum
			} else if (probeCount == minProbes) { // If the current probe count is equal to the minimum, increment numOfPerms
				numOfPerms++;
			}
        }

		System.out.println(String.format("%d %d", minProbes, numOfPerms)); // Print the minimum probe count and number of permutations with that count
    }

	/**
	 * Main method to run the experiment.
	 * @param args
	 */
	public static void main(String[] args) {
		//long startTime = System.currentTimeMillis(); // Record start time
		getData(); // Load data from mydata.txt
		experiment(); // Call the experiment method to run the optimization
		//long endTime = System.currentTimeMillis(); // Record end time
		//System.out.println("Time taken: " + (endTime - startTime) + " ms"); // Report time taken

	}

}
