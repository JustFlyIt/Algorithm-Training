package encryption;

import java.util.HashMap;
import java.util.Map;

public class AESMeasurement {
	
	public enum solutionOptions { bruteForce, mapping };
	
	public static void printInputArray(int[] inputArray) {
		for (int i=0; i<inputArray.length; i++) {
			if (i==0)
				System.out.print("Input Array: " + inputArray[i]);
			else
				System.out.print(", " + inputArray[i]);
		}
		
		System.out.println();
	}
	
	public static boolean bruteForceSlidingWindow(int[] input, int k) {
		// O(n2)
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
	
	public static boolean hashSlidingWindowSolution(int[] input, int k) {
		System.out.println("hashSlidingWindowSolution");
		Map<Integer, Integer> windowMap = new HashMap<>();
		int L = 0;
		
		for(int R=0; R<=input.length-1; R++) {
			
			if ((R - L + 1) > k) {
				windowMap.remove(input[L]);
				L++;
			}
			
			
			if (windowMap.containsValue(input[R])) {
				return true;
			}
			
			windowMap.put(R, input[R]);
		}
		
		return false;
	}
	
	public static void workTheExample(int[] inputArray, solutionOptions option, int windowSize) {
		
		printInputArray(inputArray);
		
		switch(option) {
			case bruteForce:
				System.out.println("There are two elements within a window of size k " + "(" + windowSize + ") that are equal: " + bruteForceSlidingWindow(inputArray, windowSize));
				break;
			case mapping:
				System.out.println("There are two elements within a window of size k " + "(" + windowSize + ") that are equal: " + hashSlidingWindowSolution(inputArray, windowSize));
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		//int[] input = { 1, 2, 3, 2, 3, 3};
		//int[] input = { 1, 2, 3, 5, 5, 5};
		int[] input = { 1, 2, 3, 4, 5, 6};
		
		int windowSize = 2;
		
		workTheExample(input, solutionOptions.mapping, windowSize);
	}
}
