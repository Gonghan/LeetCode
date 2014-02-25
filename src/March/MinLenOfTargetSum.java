package March;

import java.util.Arrays;

public class MinLenOfTargetSum {

	public int getMinList(int[] nums, int target) {
		Arrays.sort(nums);
		return getMinList(nums, target, 0);
	}

	private int getMinList(int[] nums, int target, int currLen) {
		if (target == 0) {
			return currLen;
		}
		if (target < 0 || nums.length == 0) {
			return Integer.MAX_VALUE / 2;
		}
		int minLen = Integer.MAX_VALUE / 2;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				minLen = Math.min(
						minLen,
						getMinList(
								Arrays.copyOfRange(nums, i + 1, nums.length),
								target - nums[i], currLen + 1));
			}
		}
		if(minLen>=Integer.MAX_VALUE/2){
			return -1;
		}
		return minLen;
	}

	public static void main(String args[]) {
		MinLenOfTargetSum m = new MinLenOfTargetSum();
		int[] nums = { 1, 2, 6, 6, 9, 9 };
		int target = 112;
		System.out.println(m.getMinList(nums, target));
	}
}
