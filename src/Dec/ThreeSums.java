package Dec;

public class ThreeSums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeSumsSolution s=new ThreeSumsSolution();
		int target=-1;
		int num[]={1,1,-1,-1,3};
		System.out.println(s.threeSumClosest(num, target));

	}

}
class ThreeSumsSolution {
    public int threeSumClosest(int[] num, int target) {
        int closest=Integer.MAX_VALUE/2;
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                for(int k=j+1;k<num.length;k++){
                    int subsum=num[i]+num[j]+num[k];
                    if(Math.abs(subsum-target)<Math.abs(closest-target)){
                        closest=subsum;
                    }
                }
            }
        }
        return closest;
        
    }
}