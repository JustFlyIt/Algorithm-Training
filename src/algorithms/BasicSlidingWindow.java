package algorithms;

import java.util.HashMap;
import java.util.Map;

import util.PrintSupport;

public class BasicSlidingWindow {
	
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
	
	public static boolean mappingSolution(int[] input, int k) {
		System.out.println("mappingSolution");
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
		
		PrintSupport.printArray(input);
		
		switch(x) {
			case 1:
				System.out.println("The answer for the input array is: " + basicSolution(input));
				break;
			case 2:
				System.out.println("There are two elements within a window of size k that are equal: " +  mappingSolution(input, 2));
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 2, 3, 3};
		//int[] input = { 1, 2, 3, 5, 5, 5};
		//int[] input = { 1, 2, 3, 4, 5, 6};
		
		workTheExample(input, 2);
	}
}
