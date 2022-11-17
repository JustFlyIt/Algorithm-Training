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
		int L = 0;
		int numberOfElements = inputNumbers.length - 1;
		
		for (int R=0; R <= numberOfElements; R++) {
			if (inputNumbers[L] != inputNumbers[R])
				inputNumbers[++L] = inputNumbers[R];
		}

		int numberUnique = L+1;

		while (L < numberOfElements) 
			inputNumbers[++L] = -1;
		
		PrintSupport.printArray(inputNumbers);
		
		return numberUnique;
	}
	
	public static int removeDuplicatesFromSortedArrayII(int[] inputNumbers) {
	    int numberUnique = inputNumbers.length;
        int L = 2;
		
		if (inputNumbers.length >= 3) {
	        for (int R = 2; R < inputNumbers.length; R++) {
	            if (inputNumbers[R] != inputNumbers[L-2])
	            	inputNumbers[L++] = inputNumbers[R];
	        }
		}

		numberUnique = L;

		while (L < inputNumbers.length) 
			inputNumbers[L++] = -1;
			
		PrintSupport.printArray(inputNumbers);

		return numberUnique;		
	}
	
	public static int ContainerWithMostWaterSlow(int[] height) {
        int currentVolume = 0; 
        int maxVolume = 0;
        int currentSide = 0;
        int length = height.length - 1;
		
        for (int R = length; R >= 0; R--) {
        	for (int L = 0; L < height.length; L++) {
	        	if (height[L] < height[R]) 
	        		currentSide = height[L];
	        	else 
	            	currentSide = height[R];
	        	
	        	currentVolume = currentSide * (R - L);
	        	if (currentVolume > maxVolume)
	        		maxVolume = currentVolume;
        	}
		}

		return maxVolume;		
	}
	
	public static int ContainerWithMostWaterFast(int[] height) {
		// O(n)
        int maxVolume = 0;
		int R = height.length - 1;
		int L = 0;
		 
		while (L != R) {
	        	maxVolume = Math.max(maxVolume, Math.min(height[L], height[R]) * (R - L));
	        	
	        	if (height[L] <= height[R])
	        		L++;
	        	else
	        		R--;
		}

		return maxVolume;		
	}

	public static void main(String[] args) {
		int x = 5;
		
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
				//int inputWithDuplicatesII[] = {0, 0, 0, 0, 0, 1, 1, 1, 2, 3, 3};
				int inputWithDuplicatesII[] = {1, 1, 1, 2, 2, 3};
				//int inputWithDuplicatesII[] = {0, 0, 1, 1, 1, 1, 2, 3 ,3};
				//int inputWithDuplicatesII[] = {1, 1, 1};
				//int inputWithDuplicatesII[] = {1, 2, 2};
				System.out.print("Input - ");
				PrintSupport.printArray(inputWithDuplicatesII);
				System.out.print("String with duplicates (II) removed: ");
				int numberUniqueII = removeDuplicatesFromSortedArrayII(inputWithDuplicatesII);
				System.out.println("\nNumber unique II: " + numberUniqueII);
				break;
			case 5:
				int ratings[] = {1, 1};
				//int ratings[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
				//int ratings[] = {1, 8, 6, 112, 5, 100, 3, 8, 7};
				System.out.print("Ratings Input - ");
				PrintSupport.printArray(ratings);
				int volume = ContainerWithMostWaterFast(ratings);
				System.out.println("\nVolume: " + volume);
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}
}
