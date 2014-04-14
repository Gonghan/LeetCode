package Jan;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class atoi_test {
	atoi_solution a;

	@Before
	public void preObject(){
		a=new atoi_solution();
	}
	
	@Test
	public void test() {
		String s1="";
		assertEquals("\"\" => 0",0,a.atoi(s1));
		
		String s2="  -0012a42";
		assertEquals(-12, a.atoi(s2));
		
		String s3="2147483648";
		assertEquals(2147483647,a.atoi(s3));
		
		String s4="abc";
		assertEquals(0,a.atoi(s4));
		
		String s5="-2147483649";
		assertEquals(-2147483648,a.atoi(s5));
		
		String s6="-abc";
		assertEquals(0,a.atoi(s6));
		
		String s7="   +  432";
		assertEquals(0,a.atoi(s7));
		
		String s8="   +1  432";
		assertEquals(1,a.atoi(s8));
		
		String s9="++1";
		assertEquals(0,a.atoi(s9));
		
		String s10="-11919730356x";
		assertEquals(-2147483648,a.atoi(s10));
	}

}
