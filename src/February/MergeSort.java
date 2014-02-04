package February;

import java.util.Arrays;

public class MergeSort {

	private int helper[];

	public int[] mergeSort(int[] A) {
		helper = Arrays.copyOfRange(A, 0, A.length);
		mergeSort(0, A.length - 1, A);
		return A;
	}

	private void mergeSort(int low, int high, int[] A) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(low, mid, A);
			mergeSort(mid + 1, high, A);
			merge(low, mid, high, A);
		}

	}

	private void merge(int low, int mid, int high, int[] A) {
		for (int i = low; i <= high; i++) {
			helper[i] = A[i];
		}

		int l = low;// index of the pointer in the first half
		int m = mid + 1;// index second half
		int k = l;// the index for writing
		while (l <= mid && m <= high) {
			if (helper[l] <= helper[m]) {
				A[k] = helper[l];
				l++;
			} else {
				A[k] = helper[m];
				m++;
			}
			k++;
		}
		for (; l <= mid; l++) {
			A[k] = helper[l];
			k++;
		}
	}
}
