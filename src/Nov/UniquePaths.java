package Nov;

public class UniquePaths {

	public static void main(String[] args) {
		UniquePathsSolution s=new UniquePathsSolution();
		int result=s.uniquePaths(10,10);
		System.out.println(result);
	}

}

class UniquePathsSolution {
	public int uniquePaths(int m, int n) {
        if(m<1 || n<1){
            
            return 0;
        }
        if(m==1 || n==1){
            //find destinaion
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
}
