package February;

import java.util.ArrayList;
import java.util.Collections;

public class MedianOfTwoSortedArrays {

	public static void main(String args[]) {
		int A[] = { 1, 2, 3, 8 };
		int B[] = { 4, 5, 6, 7 };
		System.out.println(new MedianOfTwoSortedArrays()
				.findMedianSortedArrays(A, B));
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		ArrayList<Integer> array = new ArrayList<>();
		for (int a : A) {
			array.add(a);
		}
		for (int b : B) {
			array.add(b);
		}
		Collections.sort(array);
		int size = array.size();
		if (size == 0) {
			return 0;
		}
		if (size % 2 == 0) {
			return 1.0d * (array.get(size / 2) + array.get(size / 2 - 1)) / 2;
		} else {
			return array.get(size / 2);
		}
	}
}
