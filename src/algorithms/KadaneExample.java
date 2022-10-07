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
	
	public static SlidingWindowAnswer kadaneSlidingWindowSolution(int[] input) {
		// O(n)
		int maxSum = input[0];
		int currentSum = 0;
		int L = 0;
		int maxL = 0;
		int maxR = 0;
		
		SlidingWindowAnswer ans = new SlidingWindowAnswer();
		
		for(int R=0; R<=input.length-1; R++) {
			
			if (currentSum < 0) {
				currentSum = 0;
				L = R;
			}
			
			currentSum += input[R];
			
			if (maxSum < currentSum) {
				maxSum = currentSum;
				ans.setL(L);
				ans.setR(R);
			}
		}
		
		return ans;
	}
	
	public static void workTheExample(int[] input, int x) {
		
		int answer = 0;
		
		printInput(input);
		
		switch(x) {
			case 1:
				System.out.println("The answer for the input array is: " + basicSolution(input));
				break;
			case 2:
				System.out.println("The answer for the input array is: " + kadaneSolution(input));
				break;
			case 3:
				SlidingWindowAnswer ans =  kadaneSlidingWindowSolution(input);
				System.out.println("The answer for the input array is: L - " + ans.getL() + "  R - " + ans.getR());
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
		
		
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int[] input1 = {
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, 0, -5, 63, -100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, 1, -5, 63, -100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, 55, 1, 2, 3, 5, -4, 2, -5, 63, -100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, -55, 1, 2, 3, 5, -4, 3, -5, 63, -100, 2, 5, 6, 8,
						1, 4, 23, -9, 12, 24, -55, 1, 2, 3, 5, -4, 4, -5, 63, -100, 2, 5, 6, 8
				       };
		int[] input2 = { 4, -1, 2, -7, 3, -4};
		int[] input3 = { -4, -1, -2, -7, -3, -4};
		
		workTheExample(input1, 3);

	}
	
	private static class SlidingWindowAnswer {
		int l = -1;
		int r = -1;
		
		protected void setL(int l_input) {
			l = l_input;
		}
		
		protected void setR(int r_input) {
			r = r_input;
		}
		
		protected int getL() {
			return l;
		}
		
		protected int getR() {
			return r;
		}
	}

}
