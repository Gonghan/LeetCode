package Jan;

public class DecodeWays {

	public static void main(String args[]) {
		DecodeWays d = new DecodeWays();
		int val = d.numDecodings("11");
		System.out.println(val);
	}

	public int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		if (s.length() == 1) {
			if (Integer.parseInt(s) == 0) {
				return 0;
			}
			return 1;
		}
		// cache records the number of ways, s.substring(0,n)
		int cache[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int current = s.charAt(i) - '0';
			if (i == 0) {
				// s="1";
				if (current == 0) {
					return 0;
				}
				cache[0] = 1;
				continue;
			}
			// current digit and the one digit before current
			String twoDigits = s.substring(i - 1, i + 1);
			int twoValues = Integer.parseInt(twoDigits);
			if (check(twoValues) == false) {
				return 0;
			}
			if (i == 1) {
				if(hasTwoMean(twoValues)){
					cache[1]=2;
				}else{
					cache[1]=1;
				}
				continue;
			}
			if (twoValues <= 10 || twoValues==20) {
				cache[i - 1] = cache[i - 2];
				cache[i] = cache[i - 1];
				continue;
			}
			if(hasTwoMean(twoValues)){
				cache[i]=cache[i-1]+cache[i-2];
				continue;
			}
			cache[i]=cache[i-1];

		}
//		for (int i : cache) {
//			//System.out.println(i);
//		}
		return cache[s.length() - 1];
	}

	// four conditions:
	// AB=>A,B or AB return 2;1+(1-9),2+(1-6)
	// AB=>AB return 1 c[i]=c[i-2],c[i-1]=c[i-2],AB<10
	// AB=>A,B return 3 c[i]=c[i-1]
	// AB=>Error, return -1
	private boolean check(int n) {
		if (n % 10 == 0 && n != 10 && n != 20) {
			return false;
		}
		return true;
	}

	private boolean hasTwoMean(int n) {
		if (n > 10 && n < 20) {
			return true;
		}
		if (n > 20 && n < 27) {
			return true;
		}
		return false;
	}
}
