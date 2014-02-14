package February;

public class RomanToInteger {
	
	public static void main(String argp[]){
		RomanToInteger r=new RomanToInteger();
		String s="DCXXI";
		System.out.println(r.romanToInt(s));
	}

	public int romanToInt(String s) {
		char[] chs = s.toCharArray();
		int res = 0;
		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			switch (c) {
			case 'I':
				res += 1;
				break;
			case 'V':
				res += 5;
				break;
			case 'X':
				res += 10;
				break;
			case 'L':
				res += 50;
				break;
			case 'C':
				res += 100;
				break;
			case 'D':
				res += 500;
				break;
			case 'M':
				res += 1000;
				break;
			}
		}
		if(s.contains("IV")){
			res-=2;
		}
		if(s.contains("IX")){
			res-=2;
		}
		if(s.contains("XL")){
			res-=20;
		}
		if(s.contains("XC")){
			res-=20;
		}
		if(s.contains("CD")){
			res-=200;
		}
		if(s.contains("CM")){
			res-=2000;
		}
		
		return res;
	}
}
