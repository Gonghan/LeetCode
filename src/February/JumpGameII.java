package February;

public class JumpGameII {
	
	public static void main(String args[]){
		JumpGameII j=new JumpGameII();
		int[]A={2,3,1,1,4};
		System.out.println(j.jump(A));
	}

	public int jump(int[] A) {
		int len = A.length;
		int steps = 0;
		int curr=0;
		int last = 0;
		for (int i = 0; i < len; i++) {
			if (i > last) {
				steps++;
				last=curr;
			}
			curr = Math.max(curr, i + A[i]);
		}
		return steps;
	}
}
