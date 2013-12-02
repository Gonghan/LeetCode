package Dec;

public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class RemoveDuplicatesfromSortedArraySolution {
    public int removeDuplicates(int[] A) {
        //create two pointers
        //first pointers: place to insert a new unique value
        //second poiners: next new value(skip duplicate ones)
        //1,2,3,3,3,4,4,5,5
        //      f   s
        //first_pointer, if equals previous one, stop and wait for next unique one
        //if next>=current first pointer, find new second
        //second, traverse and find a new value, if end of array, return
        
        int first=0;
        int second=0;
        while(second<A.length){
            first++;
            second=findNextNew(A,second);
            if(second!=-1){
                A[first]=A[second];
            }else{
                return first;
            }
        }
        return first;
    }
    
    //find a new value counting from second
    //return the index of that new value
    //return -1 => wrong, exception, or end of array
    private int findNextNew(int[] A, int second){
        if(A==null){
            return -1;
        }
        //last element or out of array
        if(second>=A.length-1){
            return -1;
        }
        for(int i=second+1;i<A.length;i++){
            if(A[i]!=A[second]){
                return i;
            }
        }
        //after second all same =second,
        //so return -1, no new elements
        return -1;
    }
}