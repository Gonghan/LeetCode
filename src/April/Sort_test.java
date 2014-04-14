package April;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class Sort_test {

	Sort sort;

	@Before
	public void init() {
		sort = new Sort();
	}
		
	@Test
	public void testInsertSort() {
		int A[]={3,2,1};
		int A_cloned[] = A.clone();
		sort.insertSort(A);
		Arrays.sort(A_cloned);
		for (int i = 0; i < A.length; i++) {
			if (A_cloned[i] != A[i]) {
				fail("Insert sort wrong");
			}
		}
	}
	
	@Test
	public void testBubbleSort() {
		int A[]={3,2,1};
		int A_cloned[] = A.clone();
		sort.bubbleSort(A);
		Arrays.sort(A_cloned);
		for (int i = 0; i < A.length; i++) {
			if (A_cloned[i] != A[i]) {
				fail("Insert sort wrong");
			}
		}
	}
	@Test
	public void testMergeSort() {
		int A[]={3,2,1,34,0,56,87,16};
		int A_cloned[] = A.clone();
		sort.mergeSort(A);
		Arrays.sort(A_cloned);
		for (int i = 0; i < A.length; i++) {
			if (A_cloned[i] != A[i]) {
				fail("Insert sort wrong");
			}
		}
	}
	
	@Test
	public void testQuickSort() {
		int A[]={3,2,1,34,0,56,87,16};
		int A_cloned[] = A.clone();
		sort.quickSort(A);
		Arrays.sort(A_cloned);
		for (int i = 0; i < A.length; i++) {
			if (A_cloned[i] != A[i]) {
				fail("Insert sort wrong");
			}
		}
	}
}
