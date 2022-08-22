
public class SumCheck {

	public static void main(String[] args) {
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

	
	
}