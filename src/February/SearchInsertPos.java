package February;
public class SearchInsertPos {
	
	public static void main(String args[]){
		SearchInsertPos s=new SearchInsertPos();
		int[]A={1,3};
		int i=s.searchInsert(A,2);
		System.out.println(i);
	}

	public int searchInsert(int[] A, int target) {
        if(A==null || A.length==0){
            return 0;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]==target){
                return i;
            }
            if(i==0){
                if(A[i]>target){
                    return i;
                }
            }
            if(i==A.length-1){
                if(A[i]<target){
                    return A.length;
                }
            }
            if(i==0){
                continue;
            }
            if(A[i-1]<target && target<A[i]){
                return i;
            }
        }
        return 0;
    }
}
