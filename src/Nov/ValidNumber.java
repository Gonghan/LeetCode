package Nov;

public class ValidNumber {
	
	public static void main(String args[]){
		ValidNumberSolution s=new ValidNumberSolution();
		System.out.println(s.isNumber(" 005047e+6"));
	}
}
class ValidNumberSolution {
	public boolean isNumber(String s) {
        String p="[-+]?(([0-9]+)|([0-9]*\\.[0-9]+)|([0-9]+\\.[0-9]*))(e[-+]?[0-9]+)?";
        return s.trim().matches(p);
    }
}