package Nov;

import java.util.ArrayList;

/**
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * 
 * @author Gonghan
 * 
 */
public class PascalTriangle {

	public static void main(String[] args) {
		
	}

}

class PascalTriangleSolution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // The nth list should be { C0,n-1, C1,n-1, C2, n-1,....,Cn-1,n-1     }
        // or Matrix[n,j]=Matrix[n-1,j-1]+Matrix[n-1,j]...Better
        
        //initialize the matrix
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        //create n subarrayList
        for(int i=0;i<numRows;i++){
            result.add(new ArrayList<Integer>());
        }
        //Extreme cases
        // 1. numRows=0=> return result;
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                addToMatrix(i,j,result);
            }
        }
        return result;
        
    }
    
    private void addToMatrix(int n,int j,ArrayList<ArrayList<Integer>> result){
        //Bad case
        if(j>n){
            return;
        }
        //first list
        if(n==0){
            result.get(n).add(1);
            return;
        }
        //Matrix[n,j]=Matrix[n-1,j-1]+Matrix[n-1,j]
        int value=getFromMatrix(n-1,j-1,result)+getFromMatrix(n-1,j,result);
        result.get(n).add(value);
    }
    
    private int getFromMatrix(int n,int j,ArrayList<ArrayList<Integer>> result){
        if(n<0 || j<0){
            return 0;
        }
        //first and last element
        if(j>n){
            return 0;
        }
        return result.get(n).get(j);
    }
}
