package Dec;


public class TwoSum {

}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Arrays.sort(numbers);
        int[]result=new int[2];
        for(int first=0;first<numbers.length;first++){
            for(int second=first+1;second<numbers.length;second++){
                int sum=numbers[first]+numbers[second];
                    if(sum==target){
                        result[0]=first+1;
                        result[1]=second+1;
                        return result;
                    }
                
            }
        }
        
        return result;
    }
}