package Nov;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []A={1,2,3,1,1,2,2};
		SingleNumberSolution s=new SingleNumberSolution();
		System.out.println(s.singleNumber(A));
	}

}

class SingleNumberSolution {
	public int singleNumber(int[] A) {
		int ones = 0, twos = 0, xthrees = 0;
		for (int i = 0; i < A.length; ++i) {
			twos |= (ones & A[i]);
			ones ^= A[i];
			xthrees = ~(ones & twos);
			ones &= xthrees;
			twos &= xthrees;
		}

		return ones;
	}
}