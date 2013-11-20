package Nov;

public class Palindromic {

	public static void main(String[] args) {
		PalindromicSolution solution=new PalindromicSolution();
		long start=System.currentTimeMillis();
		String result=solution.longestPalindrome("aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa");
		long end=System.currentTimeMillis();
		System.out.println("Time spent: "+(end-start)+"ms");
		System.out.println(result);
	}

}

class PalindromicSolution {

    public String longestPalindrome(String s) {
        // Two types of palindrome substring:
        //  1. even length
        //  2. odd length
        // To find the longest palindrome substring, just find the mid one or two letters.
        // 1. even length
        //      ABCCBA
        //      s[i]=C
        //      if s[i+1]=C then
        //          s[i-1]=s[i+2] extend substring
        //          s[i-2]=s[i+3] extend substring
        // 2. odd length
        //      ABCBA
        //      s[i]=C
        //      =>s[i-1]=s[i+1]
        
        String longest="";
        char strArray[]=s.toCharArray();
        for(int i=0;i<strArray.length;i++){
            String even=checkEven(i,strArray);
            String odd=checkOdd(i,strArray);
            if(even.length()>longest.length()){
                longest=even;
            }
            if(odd.length()>longest.length()){
                longest=odd;
            }
        }
        return longest;
    }
    
    //ABCCBA
    private String checkEven(int index,char[] strArray){
        String result="";
        int strLength=strArray.length;
        //index of strArray should be in 0~strLength-1
        result+=strArray[index];

        //check strArray[index-tmp] =? strArray[index+1-tmp]
        int tmp=0;
        //all in the array, avoid array[-1] or array[x>=length]
        while(index-tmp>=0 && index+1-tmp<strLength){
            if(strArray[index-tmp]==strArray[index+1-tmp]){
                result=strArray[index-tmp]+result+strArray[index-tmp];
            }
            tmp++;
        }
        return result;
    }
    
    //ABCBA
    private String checkOdd(int index,char[] strArray){
        String result="";
        int strLength=strArray.length;
        //index of strArray should be in 0~strLength-1
        result+=strArray[index];
        
        int tmp=1;
        
        while(index-tmp>=0 && index+tmp<strLength){
            if(strArray[index-tmp]==strArray[index+tmp]){
                result=strArray[index-tmp]+result+strArray[index-tmp];
            }
            tmp++;
        }
        return result;
    }
}
