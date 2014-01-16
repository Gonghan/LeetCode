package Jan;

public class test {

	public static void main(String args[]){
		test t=new test();
		String str="abc";
		t.passedByWhat(str);
		System.out.println(str.hashCode());
	}
	public void passedByWhat(String s){
		System.out.println(s.hashCode());
		s="123";
		System.out.println(s.hashCode());
	}
}
