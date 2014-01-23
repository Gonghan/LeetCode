package Jan;

public class UniquePathsII {
	
	public static void main(String args[]){
		UniquePathsII u=new UniquePathsII();
		int[][]grid={{0,0,0},{0,1,0},{0,0,0},{0,0,0}};
		int result=u.uniquePathsWithObstacles(grid);
		System.out.println(result);
	}

	int cache[][];
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        cache=new int[111][111];
        return travel(0,0,obstacleGrid);
    }
	
	private int travel(int x, int y,int [][]grid){
		//
		int gridHeight=grid[0].length;
		int gridWidth=grid.length;
		
		if(cache[x][y]!=0){
			return cache[x][y];
		}
		
		if(x>=gridWidth || y>=gridHeight){
			return 0;
		}
		if(x==gridWidth-1 && y==gridHeight-1){
			return 1;
		}
		int current=grid[x][y];
		
		if(current==1){
			return 0;
		}
		int tmp1=travel(x+1,y,grid);
		cache[x+1][y]=tmp1;
		int tmp2=travel(x,y+1,grid);
		cache[x][y+1]=tmp2;
		return tmp1+tmp2;
	}
}
