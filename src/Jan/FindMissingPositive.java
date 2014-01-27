package Jan;

public class FindMissingPositive {
	
	public static void main(String args[]){
		FindMissingPositive f=new FindMissingPositive();
		int A[]={3,4,-1,1};
		System.out.println(f.firstMissingPositive(A));
	}

	public int firstMissingPositive(int[] A) {

		for (int i = 0; i < A.length; i++) {
			int value = A[i];
			if (value <= A.length && value > 0 && value != i + 1
					&& A[value - 1] != value) {
				swap(A, value - 1, i);
				i--;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}

	private void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}
