package algorithms;

import java.util.HashMap;
import java.util.Map;

import util.PrintSupport;

public class FixedSizedSlidingWindow {
	
	public enum solutionOptions { bruteForce, mapping };
	
	public static boolean basicSolution(int[] input, int k) {
		// O(n*k)
		int checkLimit = 0;
		
		for(int L=0; L<=input.length-1; L++) {
			if ((L + k) < input.length)
				checkLimit = (L + k) - 1;
			else 
				checkLimit = input.length-1;
			
			for(int R=L+1; R<=checkLimit; R++) {
				if (input[L] == input[R])
					return true;
			}
		}
				
		return false;
	}
	
	public static boolean mappingSolution(int[] input, int k) {
		System.out.println("mappingSolution\n");
		Map<Integer, Integer> windowMap = new HashMap<>();
		int L = 0;
		
		for(int R=0; R<=input.length-1; R++) {
			// We only care about the values within the current window.  If we have looked at all of the  values
			// in the window then we will remove the left hand element of the window and shift right.
			if ((R - L + 1) > k) {
				windowMap.remove(input[L]);
				L++;
			}
			
			// IMPORTANT
			// This is only for two values equal in the window.  If for three values the algorithm will need to change
			// This criteria is not related to 'k'; 'k' only specifies the size of the window, not how many duplicate
			// values to look for within the window.
			if (windowMap.containsValue(input[R])) {
				return true;
			}
			
			windowMap.put(R, input[R]);
		}
		
		return false;
	}
	
	public static void workTheExample(int[] inputArray, solutionOptions option, int windowSize) {
		PrintSupport.printArray(inputArray);
		
		switch(option) {
			case bruteForce:
				System.out.println("There are two elements within a window of size k " + "(" + windowSize + ") that are equal: " + basicSolution(inputArray, windowSize));
				break;
			case mapping:
				System.out.println("There are two elements within a window of size k " + "(" + windowSize + ") that are equal: " + mappingSolution(inputArray, windowSize));
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}

	public static void main(String[] args) {
		System.out.println("Sliding Window Example...\n");
		//int[] input = { 1, 2, 3, 2, 3, 3};
		int[] input = { 1, 2, 3, 5, 5, 5};
		//int[] input = { 1, 2, 3, 4, 5, 6};
		
		int windowSize = 2;
		
		workTheExample(input, solutionOptions.mapping, windowSize);
	}
}
