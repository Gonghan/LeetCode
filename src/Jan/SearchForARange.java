package Jan;

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchForARange {

	public int[] searchRange(int[] A, int target) {
		int result[] = new int[2];
		result[0] = -1;
		result[1] = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				result[0] = i;
				break;
			}
		}
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] == target) {
				result[1] = i;
				break;
			}
		}
		return result;
	}
}
