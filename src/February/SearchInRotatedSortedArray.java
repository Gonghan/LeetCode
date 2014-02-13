package February;

public class SearchInRotatedSortedArray {

	public boolean search(int[] A, int target) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return true;
			}
		}
		return false;
	}
}
