package Nov;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}

class AddBinarySolution {
    public String addBinary(String a, String b) {
        //reverse
        StringBuffer sbA=new StringBuffer(a);
        StringBuffer sbB=new StringBuffer(b);
        sbA.reverse();
        sbB.reverse();
        StringBuffer result=new StringBuffer();
        int i=0;
        int carrier=0;
        while(true){
            int bitA=0;
            int bitB=0;
            if(i>=sbA.length() && i>=sbB.length() && carrier==0){
                break;
            }
            if(i<sbA.length()){
                bitA=sbA.charAt(i)-'0';
            }
            if(i<sbB.length()){
                bitB=sbB.charAt(i)-'0';
            }
            int tmp=bitA+bitB+carrier;
            if(tmp>=2){
                carrier=1;
                tmp=tmp-2;
            }else{
                carrier=0;
                
            }
            result.append(tmp);
            i++;
        }
        return result.reverse().toString();
    }
}