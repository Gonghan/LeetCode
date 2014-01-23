package Jan;

public class TrapRainWater {
	
	public static void main(String args[]){
		int []A={0,1,0,2,1,0,1,3,2,1,2,1};
		TrapRainWater t=new TrapRainWater();
		int result=t.trap(A);
		System.out.println(result);
	}
	
	int allSum=0;
	public int trap(int[] A){
		int result=0;
		int sum=0;
		for(int i:A){
			sum+=i;
		}
		if(A==null || A.length==0){
		    return 0;
		}
		int top=findTop(A,0,A.length-1);
		allSum+=A[top];
		//left side
		findLeft(A,top);
		findRight(A,top);
		result=allSum-sum;
		return result;
	}
	
	private void findLeft(int[]A,int previous){
		if(previous==0){
			return;
		}
		int leftTop=findTop(A,0,previous-1);
		allSum+=A[leftTop]*(previous-leftTop);
		findLeft(A,leftTop);
	}
	
	private void findRight(int[]A,int previous){
		if(previous==A.length-1){
			return;
		}
		int rightTop=findTop(A,previous+1,A.length-1);
		allSum+=A[rightTop]*(rightTop-previous);
		findRight(A,rightTop);
	}
	
	//return the index of the maximum from A[start] to A[end]
	private int findTop(int []A,int start,int end){
		int maxIndex=-1;
		int maxValue=Integer.MIN_VALUE;
		for(int i=start;i<=end;i++){
			if(A[i]>maxValue){
				maxValue=A[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}

	public int trap2(int[] A) {
        int max=0;
        for(int i:A){
            if(max<i){
                max=i;
            }
        }
        int result=0;
        for(int i=1;i<=max;i++){
            int previous=-1;
            for(int j=0;j<A.length;j++){
                int current=A[j];
                if(current<i){
                    continue;
                }
                if(current>=i&& previous==-1){
                    previous=j;
                }else{
                    result+=j-previous-1;
                    previous=j;
                }
                
            }
        }
        return result;
    }
}
