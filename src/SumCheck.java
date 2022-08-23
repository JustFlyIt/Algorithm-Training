/******************************************************************************************************
 * 
 * August 23, 2022
 * 
 * Two Sum - This is a demonstration of enhancing an algorithm to improve solution performance.
 * 
 * This Java program show two ways to complete the compoonents of a sum given the sum and the first
 * component.  With the sum and the first component the two methods return the the second component
 * if it is in the provided list of integers.
 * 
 * The difference between the two methods is that the first method, twoSum, is very slow.  The second
 * method, twoSumEnhanced is extremely fast.
 * 
 * The first method, twoSum, uses two linear searches two search for the missing compoonent.  This
 * is manifested in the use of two for loops that result in a time complexity of Big O equals n 
 * squared (quadtractic).
 * 
 * The second method, twoSumEnhanced removes the nested for loop and provides a solution that only
 * iterates the search array one time.  This provides a time complexity of Big O equals n.
 * 
 * The second method solution approaches each number in the search array and asks, what is needed to
 * get to the target number.  That value is added to a hashmap such that the complete of the current
 * search array value is added an an index to the hashmap.  The value mapped to that index is the 
 * index of the search array value that when added to the complement will provide the target value.  So
 * if the search array were { 5, 2, 4} and the target value was 6, the the first entry in the 
 * hashmap will be (1,0).  1 is the complement and 0 is the index to the search array element that 
 * when added to the complement will equal the target value.  So, for each value in the search array
 * the hashmap is searched for the value.  If the value exists, the complement for the provide sum 
 * component has been found.
 * 
 * In both cases the indices of the components to the search array are returned.
 * 
 * This example is based on the demonstration found at this link:
 * 
 * https://www.youtube.com/watch?v=Yyyi12oaK94&t=1198
 * 
 * LeetCode Exercise in Java Tutorial - Two Sum FAST Solution
 * Coding With John
 */

import java.util.HashMap;
import java.util.Map;

public class SumCheck {

	public static void main(String[] args) {
		System.out.println("Starting SubCheck.main...");
		int[] searchIntegers = {5, 6, 2, 1, 7, 9, 12, 43, 56, 3, 54, 100, 40};
		int sumTarget = 9;
		
		SumCheck check = new SumCheck();
		int[] solution = check.twoSum(searchIntegers, sumTarget);
		
		if (solution != null) {
			System.out.println("Solution found");
			System.out.println(solution[0] + ", " + solution[1]);
		} else {
			System.out.println("Solution not found");
		}
	}
	
	public int[] twoSum(int[]searchArray, int target) {	
		for (int i=0; i<searchArray.length; i++) {
			for (int j=i+1; j<searchArray.length; j++ ) {
				if (searchArray[i] + searchArray[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		
		return null;
	}

	public int[] twoSumEnhanced(int[]searchArray, int target) {	
		System.out.println("twoSumEnhanced");
		Map<Integer, Integer> complements = new HashMap<>();
		for (int i=0; i<searchArray.length; i++) {
			Integer complementIndex = complements.get(searchArray[i]);
			if (complementIndex != null ) {
				return new int[] {i, complementIndex};
			}
			
			complements.put(target - searchArray[i], i);
		}
		
		return null;
	}
	
	
}
