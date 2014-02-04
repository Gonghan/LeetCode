package February;

public class Sqrt {
	
	public static void main(String args[]){
		Sqrt s=new Sqrt();
		System.out.println(s.sqrt(2147395599));
	}

	public int sqrt(int x) {
        if(x==0){
            return 0;
        }
        int result=0;
        //int base=1;
        int tmp=1;
        while(true){
            long v=(long) (1.0d*(result+tmp)*(result+tmp));
            if(v==x){
                break;
            }
            if(v>x){
                if(tmp==1){
                    return result;
                }
                result=result+tmp/2;
                tmp=1;
                continue;
            }
            tmp=tmp*2;
        }
        return result+tmp;
    }}
