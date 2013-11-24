package Nov;

import java.util.ArrayList;
//this is a stupid question.

public class ZigZagConversion {

	public static void main(String args[]){
		ZigZagConversionSolution s=new ZigZagConversionSolution();
		System.out.println(s.convert2("PAYPALISHIRING", 4));
	}
	
}
class ZigZagConversionSolution {
    public String convert(String s, int nRows) {
        //create a arrayList<arrayList<string>> to store this complex structure
        // create nrows arraylist
        ArrayList<ArrayList<String>>result=new ArrayList<ArrayList<String>>();
        for(int i=0;i<nRows;i++){
            result.add(new ArrayList<String>());
        }
        char []charArray=s.toCharArray();
        //decide which arraylist to append
        int array_index=0;
        for(int i=0;i<charArray.length;i++){
            array_index=array_index%nRows;
            char ch=charArray[i];
            //array_index=odd and array size=odd, so add a space
            if((array_index==0 || array_index==nRows-1) && isOdd(result.get(array_index).size())){
                result.get(array_index).add(" ");
                array_index++;
            }
            array_index=array_index%nRows;
            result.get(array_index).add(""+ch);
            array_index++;
        }
        //convert arrayList<arraylist> to string
        String output="";
        for(ArrayList<String> list:result){
            for(String str:list){
                if(str.equals(" ")){
                    continue;
                }
                output+=str;
            }
        }
        return output;
    }
    
    public String convert2(String s, int nRows) {  
    	   if (nRows == 1) return s;  
    	   
    	   StringBuilder ss = new StringBuilder();  
    	   int n = nRows + nRows - 2;  
    	   // rest rows  
    	   for (int i = 0; i < nRows; ++i) {  
    	     int cur = i;  
    	     while (cur < s.length()) {  
    	       ss.append(s.charAt(cur));  
    	       cur += n;  
    	       if (i > 0 && i < nRows - 1 && (cur - i - i) < s.length()) {  
    	         ss.append(s.charAt(cur - i - i));  
    	       }  
    	     }  
    	   }  
    	   return ss.toString();  
    	 }  
    
    private boolean isOdd(int value){
        return value%2==1;
    }
}