package algorithms;

import java.util.HashMap;
import java.util.Map;

public class BasicSlidingWindow {
	
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
		// O(n2)
		int maxSum = input[0];
		int currentSum = 0;
		
		for(int i=0; i<=input.length-1; i++) {
			currentSum = 0;
			
			for(int j=i; j<=input.length-1; j++) {
				currentSum += input[j];
				if (maxSum < currentSum)
					maxSum = currentSum;
			}
		}
				
		return maxSum;
	}
	
	public static int kadaneSolution(int[] input) {
		// O(n)
		int maxSum = input[0];
		int currentSum = 0;
		
		for(int i=0; i<=input.length-1; i++) {
			
			if (currentSum < 0)
				currentSum = 0;
			
			currentSum += input[i];
			
			if (maxSum < currentSum)
				maxSum = currentSum;
		}
				
		return maxSum;
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
	
	public static void workTheExample(int[] input, int x) {
		
		printInput(input);
		
		switch(x) {
			case 1:
				System.out.println("The answer for the input array is: " + basicSolution(input));
				break;
			case 2:
				System.out.println("The answer for the input array is: " + kadaneSolution(input));
				break;
			case 3:
				System.out.println("There are two elements within a window of size k that are equal: " +  hashSlidingWindowSolution(input, 2));
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
		
		workTheExample(input1, 3);

	}
}
