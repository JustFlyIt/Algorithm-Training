package algorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.PrintSupport;

public class BasicVariableLengthSlidingWindow {
	
	public static int findLongestSubArray(int[] input) {
		// O(n)
		int length = 0;
		int L = 0;
			    
		for (int R = 0; R<=input.length-1; R++) {
			if (input[L] != input[R])
				L = R; 
			
			//Has a longer sub-array been found?
			//What is longer, the current length or the update?
			if (length < R - L + 1)
				length = R - L + 1;
		}
			   
		return length;
	}
	
	public static int findMinimumSubArrayWithTarget(int[] input, int target) {
		//O(n)
		System.out.println("findMinimumSubArrayWithTarget");
		
		float length = Float.MAX_VALUE;
		int L = 0;
		int total = 0;
		
		for (int R = 0; R <= input.length-1; R++) {
			total += input[R];
			while (total >= target) {
				if ((R-L+1) < length)
					length = R-L+1;
				
				total-=input[L];
				L += 1;
			}
		}
		
		if (length == Float.MAX_VALUE)
			return 0;
		else
			return (int)length;
	}

	
	public static int findLongestSubstringWORepeatCharacters(String inputString) {
		//O(n)
		System.out.println("findLongestSubstringWORepeatCharacters");
		
		int L = 0;
		int subStringLength = 0;
		int maxLength = 0;
		char currentChar;

		for (int R = 0; R<= inputString.length()-1; R++) {
			while (R <= inputString.length()-1) {
				currentChar = inputString.charAt(R);
				int cIndex = inputString.indexOf(currentChar, L);
				if (cIndex == R) {
					R++;
					subStringLength = R - L;
					if (subStringLength > maxLength)
						maxLength = subStringLength;
				} else if (cIndex != -1) {
					L = cIndex + 1;
					break;
				}
			}
		}
		
		return maxLength;
	}

	public static int findLongestSubstringReplaceCharacter(String inputString, int replaceNum) {
		//O(26*n)
		/* 
		 * This example uses a hash map for counting characters.  It could have used and 
		 * integer array of size 26 but I wanted the practice of using a hash map and didn't 
		 * want to allocate and array of 26.
		 */
		System.out.println("findLongestSubstringReplaceCharacter");
		int L = 0;
		int answer = 0;
		Character currentChar;
		int maxCount = 0;
		
		Map<Character, Integer> count = new HashMap<>();

		System.out.println("Input String - " + inputString);
		
		for (int R = 0; R <= inputString.length() -1; R++) {
			currentChar = Character.valueOf(inputString.charAt(R));
			if (!count.containsKey(currentChar))
				count.put(currentChar, 1);
			else 
				count.put(currentChar, count.get(currentChar) + 1);
			
			int charCount = count.get(currentChar);
			maxCount = Math.max(charCount, maxCount);
						
			if ((R - L + 1 - maxCount) > replaceNum) {
				currentChar = Character.valueOf(inputString.charAt(L));
				count.put(currentChar, count.get(currentChar) - 1);
				L++;
			}

			answer = Math.max(R - L + 1, answer);
		}
		
		System.out.println();
	    for (Character i : count.keySet()) {
	        System.out.println("key: " + i + " value: " + count.get(i));
	      }
		System.out.println();

		System.out.println("MaxCount - " + maxCount);
			   
		return answer;
	}
	
	public static void main(String[] args) {
		int[] inputNum = { 4, 2, 2, 2, 2, 2, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1};
		int x = 4;
		//int replaceNum = 0;
		//int replaceNum = 1;
		int replaceNum = 1;
		//String inputString = "abczaxvghjcbb";
		//String inputString = "bbbbb";
		//String inputString = "nfpdmpi";
		//String inputString = "pwwkew";
		String inputString = "AABABBA";
		//String inputString = "ABAB";
		//String inputString = "ABAA";
		//String inputString = "ABBBBCCCCCCCCCC";
		//String inputString = "AAABBAAAAA";
		//int[] input = { 1, 2, 3, 5, 5, 5};
		//int[] input = { 1, 2, 3, 4, 5, 6};
		
		switch(x) {
			case 1:
				PrintSupport.printArray(inputNum);
				System.out.println("The length of the longest subarray, with the same value in each position is: " + findLongestSubArray(inputNum));
				break;
			case 2:
				PrintSupport.printArray(inputNum);
				System.out.println("The shortest sub-array containing sum target is: " +  findMinimumSubArrayWithTarget(inputNum, 16));
				break;
			case 3:
				System.out.println("The longest substring without repeating characters is: " +  findLongestSubstringWORepeatCharacters(inputString));
				break;
			case 4:
				System.out.println("The longest substring without repeating characters is (including replacement): " +  findLongestSubstringReplaceCharacter(inputString, replaceNum));
				break;
			default:
				System.out.println("Valid Solution Not Specified");
				return;
		}
	}
}
