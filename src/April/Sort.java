package April;

public class Sort {
	public int[] insertSort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int curr = A[i];
			for (int j = 0; j < i; j++) {
				if (curr < A[j]) {
					int tmp = A[j];
					A[j] = curr;
					curr = tmp;
				}
			}
			A[i] = curr;
		}

		return A;
	}

	public int[] bubbleSort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length - i - 1; j++) {
				if (A[j] > A[j + 1]) {
					int tmp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = tmp;
				}
			}
		}
		return A;
	}

	public int[] mergeSort(int[] A) {
		return mergeSort(A, 0, A.length - 1);
	}

	private int[] mergeSort(int[] A, int i, int j) {
		if (i == j) {
			return A;
		}
		int mid = (i + j) / 2;
		mergeSort(A, i, mid);
		mergeSort(A, mid + 1, j);
		merge(A, i, mid, j);
		return A;
	}

	private void merge(int[] A, int i, int mid, int j) {
		// merge A[i:mid],A[mid+1:j]
		int[] newA = new int[j - i + 1];
		int index = 0;
		int p1 = i;
		int p2 = mid + 1;
		while (p1 <= mid || p2 <= j) {
			if (p1 > mid) {
				newA[index] = A[p2];
				p2++;
			} else if (p2 > j) {
				newA[index] = A[p1];
				p1++;
			} else if (A[p1] < A[p2]) {
				newA[index] = A[p1];
				p1++;
			} else {
				newA[index] = A[p2];
				p2++;
			}
			index++;
		}
		for (int p = i; p <= j; p++) {
			A[p] = newA[p - i];
		}
	}

	public int[] quickSort(int[] A) {
		quickSort(A, 0, A.length - 1);
		return A;
	}

	private void quickSort(int[] A, int low, int high) {
		int i = low;
		int j = high;
		int pivot =(i + j) / 2;
		while (i <= j) {
			while (A[i] < A[pivot]) {
				i++;
			}
			while (A[j] > A[pivot]) {
				j--;
			}
			if (A[i] <= A[j]) {
				swap(A, i, j);
				i++;
				j--;
			}
		}
		if(low<j){
			quickSort(A,low,j);
		}
		if(i<high){
			quickSort(A,i,high);
		}

	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
