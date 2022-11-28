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
			for (int c=0; c<cols-1; c++) {
				prefix += nums[r][c];
				above = numPrefixes[r][c+1];
				numPrefixes[r+1][c+1]= prefix + above;
			}
		}
		
		System.out.println("print for debug breakpoint.");
	}

	public int sumRange(int row1, int col1, int row2, int col2) {
		
		int total = 0;
		//prefixIntRight = numPrefixes[right];
		//t prefixIntLeft = 0;
		
		// (left > 0)
			//efixIntLeft = numPrefixes[left-1];
		
		return 0; //fixIntRight - prefixIntLeft;
	}
}
