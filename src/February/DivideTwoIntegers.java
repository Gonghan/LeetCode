package February;

import java.util.ArrayList;

public class DivideTwoIntegers {

	public static void main(String args[]) {
		System.out.println(new DivideTwoIntegers().divide(1,1));
	}

	public int divide(int dividend, int divisor) {
		int sign1 = 1;
		int sign2 = 1;
		long ldend = (long) dividend;
		long ldsor=(long)divisor;
		if (dividend == 0) {
			return 0;
		}
		if (dividend < 0) {
			sign1 = -1;
			ldend = (long) dividend;
			ldend = 0 - ldend;
		}
		if (divisor < 0) {
			sign2 = -1;
			ldsor=0-ldsor;
		}
		// construct 2^30
		int two30 = get2s(30);
		// return dividend/divisor;
		long tmp = ldsor;
		ArrayList<Long> bilist = new ArrayList<>();
		bilist.add(tmp);
		while (tmp < two30) {
			tmp = tmp + tmp;// tmp==2^i*divisor
			bilist.add(tmp);// bilist[i]=2^i*divisor
		}
		int result = 0;
		while (ldend >= ldsor) {
			for (int i = bilist.size() - 1; i >= 0; i--) {
				if (ldend >= bilist.get(i)) {
					result += get2s(i);
					ldend = ldend - bilist.get(i);
				}
			}
		}
		if (sign1 == sign2) {
			return result;
		} else {
			return 0 - result;
		}
	}

	private int get2s(int v) {
		int tmp = 1;
		for (int i = 1; i <= v; i++) {
			tmp = tmp + tmp;//
		}
		return tmp;
	}
}
