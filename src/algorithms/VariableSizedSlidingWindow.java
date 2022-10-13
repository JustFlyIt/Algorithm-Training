package algorithms;

import java.util.HashMap;
import java.util.Map;

public class VariableSizedSlidingWindow {
	
	public enum solutionOptions { simple, mapping };
	
	public static void printInputArray(int[] inputArray) {
		for (int i=0; i<inputArray.length; i++) {
			if (i==0)
				System.out.print("Input Array: " + inputArray[i]);
			else
				System.out.print(", " + inputArray[i]);
		}
		
		System.out.println();
	}
	
	public static int simpleVariableSlidingWindow(int[] input, int target) {
		// O(n)
		int checkLimit = 0;
		int ansLength = 0;
		
		for(int L=0; L<=input.length-1; L++) {
			if ((L + k) < input.length)
				checkLimit = (L + k) - 1;
			else 
				checkLimit = input.length-1;
			
			for(int R=L+1; R<=checkLimit; R++) {
				if (input[L] == input[R])
					return 1;
			}
		}
				
		return 0;
	}
	
	public static int hashVariableSlidingWindowSolution(int[] input, int target) {
		System.out.println("hashSlidingWindowSolution");
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
				return 1;
			}
			
			windowMap.put(R, input[R]);
		}
		
		return 0;
	}
	
	public static void workTheExample(int[] inputArray, solutionOptions option) {
		
		printInputArray(inputArray);
		
		switch(option) {
			case simple:
				System.out.println("Minimum length subarray, where the sum is greate than or equal to the target: " + simpleVariableSlidingWindow(inputArray, 6));
				break;
			case mapping:
				System.out.println("Minimum length subarray, where the sum is greate than or equal to the target: " + hashVariableSlidingWindowSolution(inputArray, 6));
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int[] input1 = { 1, 2, 3, 2, 3, 3};
		int[] input2 = { 1, 2, 3, 5, 5, 5};
		int[] input3 = { 1, 2, 3, 4, 5, 6};
		
		int windowSize = 2;
		
		workTheExample(input3, solutionOptions.mapping);
	}
}
