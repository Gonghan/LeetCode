package Nov;

public class SortColors {

	public static void main(String[] args) {
		SortColorsSolution s=new SortColorsSolution();
		int A[]={1,2,0,0,1,0,2};
		s.sortColors(A);
	}

}

class SortColorsSolution {
	public void sortColors(int[] A) {
		int last_one = -1;
		int first_two = A.length;
		for (int i = 0; i < A.length; i++) {
			while (A[i] != 1) {
				if (i >= first_two) {
					return;
				}
				if (i <= last_one) {
					break;
				}
				if (A[i] == 0) {
					swap(A, i, last_one + 1);
					last_one++;
					continue;
				}
				if (A[i] == 2) {
					swap(A, i, first_two - 1);
					first_two--;
					continue;
				}
			}
		}
	}

	private void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}