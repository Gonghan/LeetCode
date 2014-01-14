package Jan;

public class MaximumSubarray {
	
	public int maxSubArray(int[] A) {
        //First, set a variable for the result
        //Second, traverse each node and record the max sub array ending with the current one
        //To accomplish this step, check the current one and the sum of current and the max sub array ending with the previous node
        //For example, -1,2,-3,4
        //Max sub sum, -1,2,-1,4.
        int result=Integer.MIN_VALUE/2;
        int max_subarray=0;
        for(int i=0;i<A.length;i++){
            int current=A[i];
            max_subarray=Math.max(current,current+max_subarray);
            if(max_subarray>result){
                result=max_subarray;
            }
        }
        return result;
    }
}
