package Jan;

import java.util.HashSet;
import java.util.Set;

/*
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
        int writeIndex=0;
        if(A==null || A.length==0){
            return 0;
        }
        Set<Integer>set=new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
            int value=A[i];
            if(!set.contains(value)){
                set.add(value);
                A[writeIndex]=value;
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
