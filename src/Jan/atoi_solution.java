package Jan;

public class atoi_solution {

	public int atoi(String str) {
		str = str.trim();
		int sign = 1;
		boolean allDigits = true;
		StringBuffer sb = new StringBuffer(str);
		if (sb.length() == 0) {
			return 0;
		}
		if (sb.charAt(0) == '-') {
			sign = -1;
		}
		if (sb.charAt(0) == '+') {
			sign = 1;
		}

		for (int i = 0; i < sb.length(); i++) {
			if(i==0){
				char first=sb.charAt(0);
				if(first=='-' || first=='+'){
					continue;
				}
			}
			char current = sb.charAt(i);
			if ((current >= '0' && current <= '9')) {
				// 0-9
			} else {
				//allDigits = false;
				sb=new StringBuffer(sb.substring(0,i));
				break;
			}
		}
		
		if (sb.length() == 0) {
			return 0;
		}
		int result = 0;
		try {
			result = Integer.parseInt(sb.toString());
		} catch (Exception e) {
			if (allDigits == true) {
				if(sb.length()==1 ){
					if(sb.charAt(0)=='-' || sb.charAt(0)=='+'){
						return 0;
					}
				}
				if (sign == 1) {
					return Integer.MAX_VALUE;
				}
				if (sign == -1) {
					return Integer.MIN_VALUE;
				}
				
			} else {
				return 0;
			}
		}
		return result;
	}
}
