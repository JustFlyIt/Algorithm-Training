/**
 * The NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
*/

package algorithms.PrefixSums;

public class RangeSumQuery2D {
	private int numPrefixes[][];

	public RangeSumQuery2D(int[][] nums) {
		numPrefixes = new int[nums.length+1][nums.length+1];
		int rows = nums.length;
		int cols = nums.length;
		int prefix = 0;
		int above = 0;
		
		for (int r=0; r<rows; r++) {
			prefix = 0;
			for (int c=0; c<cols; c++) {
				prefix += nums[r][c];
				above = numPrefixes[r][c+1];
				numPrefixes[r+1][c+1]= prefix + above;
			}
		}
		
		System.out.println("print for debug breakpoint.");
	}

	public int sumRange(int row1, int col1, int row2, int col2) {
		
		row1++;
		row2++;
		col1++;
		col2++;
		
		int bottomRight = numPrefixes[row2][col2];
		int above = numPrefixes[row1 - 1][col2];
		int left = numPrefixes[row2][col1 - 1];
		int topLeft = numPrefixes[row1 - 1][col1 - 1]; 
		
		return bottomRight - above - left + topLeft;
	}
}
