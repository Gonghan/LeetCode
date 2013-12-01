package Nov;

public class JumpGame {

}

class JumpGameSolution {
    public boolean canJump(int[] A) {
        int currentMax=0;
        for(int i=0;i<A.length;i++){
            currentMax=Math.max(currentMax-1,A[i]);
            if(currentMax==0 && i!=A.length-1){
                return false;
            }
        }
        return true;
    }
}