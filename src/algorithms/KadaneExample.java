package algorithms;

public class KadaneExample {
	
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
	
	public static void workTheExample(int[] input) {
		
		printInput(input);
		System.out.println("The answer for the input array is: " + basicSolution(input));
		
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int[] input1 = {
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, -14 , -5, 63, 100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, -14 , -5, 63, 100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, -14 , -5, 63, 100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, -14 , -5, 63, 100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, -14 , -5, 63, 100, 2, 5, 6, 8
				       };
		int[] input2 = { 4, -1, 2, -7, 3, 4};
		int[] input3 = { -4, -1, -2, -7, -3, -4};
		
		workTheExample(input3);

	}

}
