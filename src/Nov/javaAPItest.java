package Nov;

public class javaAPItest {

	public static void main(String args[]){
		APITest t=new APITest();
		//t.testClone();
		t.strings();
		
	}
}

class APITest{
	
	//test the usage of clone
	public void testClone(){
		Dog d=new Dog("XX");
		try {
			Dog d2=(Dog)d.clone();
			d2.bark();
			System.out.println(String.format("D2 and d are different= %b",d2==d));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//test the differences among string, stringbuilder, stringbuffer
	public void strings(){
		//String
		String str="hello";
		String str2=str;
		str="suck";
		String str3="hello";
		String str4=getStr();
		System.out.println(String.format("str2==str3: %b", str2==str3));
		System.out.println(String.format("str3==str4: %b", str3==str4));
		
		//substring
		String str5=str3.substring(1);
		System.out.println(str5);
		
	}
	
	private String getStr(){
		String tmp="hel";
		String tmp2="lo";
		String tmp3=tmp+tmp2;
		return tmp3;
	}
}

class Dog implements Cloneable{
	private String name;
	public Dog(String name){
		this.name=name;
	}
	public void bark(){
		System.out.println(String.format("My name is %s. Wawawa",this.name));
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}