package algorithms;

import java.util.HashMap;
import java.util.Map;

import util.PrintSupport;

public class TwoPointers {
	
	public static boolean validPalindrome(String inputString) {
		// O(n)
		inputString = inputString.replaceAll("[^a-zA-Z0-9]", "");
		inputString = inputString.toLowerCase();
	    
		int L = 0;
		int R = inputString.length() - 1;
		char rightChar, leftChar;
		
		while (L < R) {
			leftChar = inputString.charAt(L);
			rightChar = inputString.charAt(R);

			if (leftChar == rightChar) {
				L++;
				R--;
			} else {
				return false;
			}
		}
			   
		return true;
	}

	public static int[] twoSumII_InputArrayIsSorted(int[] inputNumbers, int target) {
		// O(n)
		/* 	Constraints
		 * 2 <= numbers.length <= 3 * 104
		 * -1000 <= numbers[i] <= 1000
		 * numbers is sorted in non-decreasing order
		 * -1000 <= target <= 1000
		 * Tests are for exactly one solution
		*/
		
		int L = 0;
		int R = inputNumbers.length - 1;
		int currentSum = 0;
		
		while (L < R) {
			currentSum = inputNumbers[L] + inputNumbers[R];
			if (currentSum == target) {
				break;
			} else if (currentSum < target) {
				L++;
			} else {
				R--;
			}
		}
			   
		return new int[] {++L, ++R};
	}
	
	public static void main(String[] args) {
		String inputString = "A man, a plan, a canal: Panama11";
		//String inputString = "AABBBBAA";
		//int inputInArray[] = {1, 2, 3, 3, 4, 6, 8};
		//int target = 11;
		int inputInArray[] = {2, 7, 11, 35};
		int target = 9;
		int ans[] = {-1, -1};
		
		int x = 2;
		
		switch(x) {
		case 1:
			System.out.println("Input string: " + inputString);
			System.out.println("Is the input a palindrome: " + validPalindrome(inputString));
			break;
		case 2:
			PrintSupport.printArray(inputInArray);
			ans = twoSumII_InputArrayIsSorted(inputInArray, target);
			System.out.println("Has the target (" + target + ") sum indices: L - " + ans[0] + "  R - " + ans[1]);
			twoSumII_InputArrayIsSorted(inputInArray, target);
			break;
		default:
			System.out.println("Valid Solution Not Specified");
			return;
		}
	}
}
