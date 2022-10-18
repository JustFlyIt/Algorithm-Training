package algorithms;

import java.util.HashMap;
import java.util.Map;

public class BasicVariableLengthSlidingWindow {
	
	public static void printInput(int[] input) {
		for (int i=0; i<input.length; i++) {
			if (i==0)
				System.out.print("Input: " + input[i]);
			else
				System.out.print(", " + input[i]);
		}
		
		System.out.println();
	}
	
	public static int basicSolution(int[] input) {
		// O(n)
		int longestArrayLength = 0;
		int R = 0;
		
		for(int L=0; L<=input.length-1; L++) {
			if (input[L] == input[R]) {
				longestArrayLength++;
			}
			
			R = L + 1;
			while (R < input.length-1) {
				R++;
				if (input[L] == input[R]) {
					longestArrayLength++;
				} else {
					longestArrayLength--;
					L = R;
					break;
				}
			}
			
		}
				
		return longestArrayLength;
	}
	
	public static boolean mappingSolution(int[] input) {
		System.out.println("mappingSolution");
		return false;
	}
	
	public static void workTheExample(int[] input, int x) {
		
		printInput(input);
		
		switch(x) {
			case 1:
				System.out.println("The length of the longest subarray, with the same value in each position is: " + basicSolution(input));
				break;
			case 2:
				System.out.println("The length of the longest subarray, with the same value in each position is: " +  mappingSolution(input));
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}

	public static void main(String[] args) {
		int[] input = { 4, 2, 2, 2, 2, 2, 3, 3, 3};
		//int[] input = { 1, 2, 3, 5, 5, 5};
		//int[] input = { 1, 2, 3, 4, 5, 6};
		
		workTheExample(input, 1);
	}
}
