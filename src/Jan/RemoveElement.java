package Jan;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
        int length=A.length;
        int j=0;
        for(int i=0;i<length;i++){
            if(A[i]!=elem){
                A[j]=A[i];
                j++;
            }
        }
        return j;
    }
}
