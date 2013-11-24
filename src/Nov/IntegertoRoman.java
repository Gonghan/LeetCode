package Nov;

public class IntegertoRoman {

}
class IntegertoRomanSolution {
    // I 1
    // V 5
    // X 10
    // L 50
    // C 100
    // D 500
    // M 1000
    public String intToRoman(int num) {
        //how many thousands
        String result="";
        if(num>=1000){
            int thousands=num/1000;
            for(int i=0;i<thousands;i++){
                result+="M";
            }
            num=num-1000*thousands;
        }
        if(num>=500){
            if(num>=900){
                result+="CM";
                num-=900;
                
            }else{
                result+="D";
                num=num-500;
            }
        }
        if(num>=100){
            if(num>=400){
                result+="CD";
                num-=400;
            }else{
                int hundreds=num/100;
                for(int i=0;i<hundreds;i++){
                    result+="C";
                }
                num=num-hundreds*100;
            }
        }
        if(num>=50){
            if(num>=90){
                result+="XC";
                num-=90;
            }else{
                result+="L";
                num=num-50;
            }
        }
        if(num>=10){
            if(num>=40){
                result+="XL";
                num-=40;
            }else{
                int tens=num/10;
                for(int i=0;i<tens;i++){
                    result+="X";
                }
                num=num-tens*10;
            }
        }
        if(num>=5){
            if(num==9){
                result+="IX";
                return result;
            }else{
                result+="V";
                num=num-5;
            }
        }
        if(num==4){
            result+="IV";
            return result;
        }else{
            for(int i=0;i<num;i++){
                result+="I";
            }
        }
        return result;
        
    }
}