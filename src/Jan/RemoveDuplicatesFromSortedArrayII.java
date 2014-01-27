package Jan;

/*
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		// the index for traversing
		int tIndex = 0;
		// the index for writing
		int wIndex = 0;
		boolean duplicated = false;
		for (; tIndex < A.length; tIndex++) {
			if (tIndex == 0) {
				// tIndex++;
				wIndex++;
				continue;
			}
			if (A[tIndex] == A[tIndex - 1]) {
				if (duplicated == false) {
					duplicated = true;
				} else {
					// tIndex++;
					continue;
				}
			} else {
				duplicated = false;
			}
			A[wIndex] = A[tIndex];
			// tIndex++;
			wIndex++;
		}
		return wIndex;
	}

}
