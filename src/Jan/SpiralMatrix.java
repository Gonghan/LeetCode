package Jan;

import java.util.ArrayList;

public class SpiralMatrix {

	public static void main(String args[]){
		int [][]matrix={{1,2},{3,4}};
		System.out.println(new SpiralMatrix().spiralOrder(matrix));
	}
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0] == null
				|| matrix[0].length == 0) {
			return result;
		}
		ArrayList<Integer> tmp = null;
		int level = 0;
		while (true) {
			tmp = addLevel(matrix, level);
			if (tmp.size() == 0) {
				break;
			}
			result.addAll(tmp);
			level++;
		}
		return result;
	}

	// level 0-?
	private ArrayList<Integer>addLevel(int[][]matrix,int level){
        int width=matrix[0].length;
        int height=matrix.length;
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(level+1>(height+1)/2 || level+1>(width+1)/2){
        	return result;
        }
        //up
        for(int i=level;i<width-level;i++){
            result.add(matrix[level][i]);
        }
        //right
        for(int i=level+1;i<height-level;i++){
            result.add(matrix[i][width-level-1]);
        }
        //down
        for(int i=width-level-2;i>=level;i--){
        	if(height-level-1>level){
        		result.add(matrix[height-level-1][i]);
        	}
        }
        //left
        for(int i=height-level-2;i>level;i--){
        	if(level<width-level-1){
        		result.add(matrix[i][level]);
        	}
        }
        return result;
    }
}
