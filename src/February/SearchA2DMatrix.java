package February;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int height=matrix.length;
        int width=matrix[0].length;
        for(int i=0;i<height;i++){
            if(target>matrix[i][width-1]){
                continue;
            }
            for(int j=0;j<width;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
