package algorithms.PrefixSums;

import util.PrintSupport;

public class PrefixSumsTestController {

	public static void main(String[] args) {
		int currentCase = 2;

		switch (currentCase) {
		case 1:
			int nums[] = { -2, 0, 3, -5, 2, -1 };
			int left = 0;
			int right = 2;

			System.out.print("Input: "); 
			PrintSupport.printArray(nums);

			RangeSumQueryImmutable prefixArray = new RangeSumQueryImmutable(nums);
			int sum = prefixArray.sumRange(left, right);
			System.out.println("The sum of the elements included in Left (" + left + ") and Right (" + right + ") equals - " + sum);
		case 2:
			int matrix[][] = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
			int region1[] = {2, 1, 4, 3};
			int region2[] = {1, 1, 2, 2};
			int region3[] = {1, 2, 2, 4};

			RangeSumQuery2D obj = new RangeSumQuery2D(matrix);
			int matrixSum = obj.sumRange(2, 1, 4, 3);
			System.out.println("matrixSum = " +  matrixSum);
			//System.out.println("The sum of the elements included in Left (" + left + ") and Right (" + right + ") equals - " + sum);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			System.out.println("Valid Solution Not Specified");
			return;
		}
	}
}
