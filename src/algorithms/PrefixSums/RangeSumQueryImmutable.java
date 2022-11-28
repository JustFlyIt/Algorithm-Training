/**
 * The NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
*/

package algorithms.PrefixSums;

public class RangeSumQueryImmutable {
	private int numPrefixes[];

	public RangeSumQueryImmutable(int[] nums) {
		int total = 0;
		numPrefixes = new int[nums.length];
		
		for (int n=0; n<nums.length; n++) {
			total += nums[n];
			numPrefixes[n] = total;
		}
	}

	public int sumRange(int left, int right) {
		int prefixIntRight = numPrefixes[right];
		int prefixIntLeft = 0;
		
		if (left > 0)
			prefixIntLeft = numPrefixes[left-1];
		
		return prefixIntRight - prefixIntLeft;
	}
}
