package February;

public class MergeSortedArray {
	
	public static void main(String args[]){
		MergeSortedArray m=new MergeSortedArray();
		int[]A=new int[10];
		int[]B=new int[10];
		A[0]=1;
		A[1]=2;
		A[2]=3;
		A[3]=4;
		B[0]=-4;
		B[1]=-3;
		B[2]=-2;
		
		m.merge(A, 4, B, 3);
		for(int i:A)
			System.out.println(i);
	}

	public void merge(int A[], int m, int B[], int n) {

		int helper[] = new int[A.length];
		int ia = 0;
		int ib = 0;
		int h = m + n;
		if (n == 0) {
			return;
		}
		for (int i = 0; i < h; i++) {
			if (ia > m - 1) {
				helper[i] = B[ib];
				ib++;
				continue;
			}
			if (ib > n - 1) {
				helper[i] = A[ia];
				ia++;
				continue;
			}
			int a = A[ia];
			int b = B[ib];
			if (a < b) {
				helper[i] = a;
				ia++;
			} else {
				helper[i] = b;
				ib++;
			}
		}
		for (int i = 0; i < h; i++) {
			A[i] = helper[i];
		}
	}
}
