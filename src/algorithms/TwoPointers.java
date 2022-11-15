package algorithms;

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
	
	public static int removeDuplicatesFromSortedArray(int[] inputNumbers) {
		// O(n)
		/* 	Constraints
		 * 	1 <= nums.length <= 3 * 104
		 * -100 <= inputNumbers[i] <= 100
		 * inputNumbers is sorted in non-decreasing order.
		*/
		
		int L = 0;
		int R = 0;
		int numberOfElements = inputNumbers.length - 1;
		int numberUnique = 1;
		
		while (true) {
			if (!(inputNumbers[L] == inputNumbers[R])) {
				System.out.print(inputNumbers[L] + "  ");
				inputNumbers[++L] = inputNumbers[R];
				numberUnique++;
			}
			
			R++;
			
			if (R > numberOfElements) { 
				// Print the last unique value
				System.out.print(inputNumbers[L] + "  ");
				while (L < numberOfElements) {
					inputNumbers[++L] = '_';
					System.out.print("_ ");
				}
			
				break;
			}
		}
		
		return numberUnique;
	}
	
	public static int removeDuplicatesFromSortedArrayII(int[] inputNumbers) {
		// O(n)
		/* 	Constraints
		 * 	1 <= nums.length <= 3 * 104
		 * -100 <= inputNumbers[i] <= 100
		 * inputNumbers is sorted in non-decreasing order.
		*/
		
		int L = 0;
		int R = 0;
		int numberOfElements = inputNumbers.length;
		int numberUnique = 0;
		int twoTries = 2;
		
		while (true) {
			if (inputNumbers[L] == inputNumbers[R]) {
				if (twoTries != 0) {
					numberUnique++;
					twoTries--;
					L++;
				} else {
					twoTries = 2;
					L = R;
				}
			} else {
				inputNumbers[L] = inputNumbers[R];
				L++;
				numberUnique++;
				twoTries--;
			}
			
			R++;
			
			if (R == numberOfElements) { 
				while (L <= numberOfElements-1) {
					inputNumbers[L++] = -1;
				}
			
				break;
			}
		}
		
		PrintSupport.printArray(inputNumbers);
		
		return numberUnique;
	}
	
	public static void main(String[] args) {
		int x = 4;
		
		switch(x) {
			case 1:
				String inputString = "A man, a plan, a canal: Panama11";
				System.out.println("Input string: " + inputString);
				System.out.println("Is the input a palindrome: " + validPalindrome(inputString));
				break;
			case 2:
				int inputInArray[] = {1, 2, 3, 3, 4, 6, 8};
				int target = 11;
				int ans[] = {-1, -1};
				
				PrintSupport.printArray(inputInArray);
				ans = twoSumII_InputArrayIsSorted(inputInArray, target);
				System.out.println("Has the target (" + target + ") sum indices: L - " + ans[0] + "  R - " + ans[1]);
				twoSumII_InputArrayIsSorted(inputInArray, target);
				break;
			case 3:
				int inputWithDuplicates[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
				System.out.print("Input - ");
				PrintSupport.printArray(inputWithDuplicates);
				System.out.print("String with duplicates removed: ");
				int numberUnique = removeDuplicatesFromSortedArray(inputWithDuplicates);
				System.out.println("\nNumber unique: " + numberUnique);
				break;
			case 4:
				//int inputWithDuplicatesII[] = {0, 0, 0, 1, 1, 1, 2, 3, 3};
				int inputWithDuplicatesII[] = {1, 1, 1};
				//int inputWithDuplicatesII[] = {1, 2, 2};
				System.out.print("Input - ");
				PrintSupport.printArray(inputWithDuplicatesII);
				System.out.print("String with duplicates (II) removed: ");
				int numberUniqueII = removeDuplicatesFromSortedArrayII(inputWithDuplicatesII);
				System.out.println("\nNumber unique II: " + numberUniqueII);
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}
}
