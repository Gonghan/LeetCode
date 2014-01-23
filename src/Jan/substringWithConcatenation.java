package Jan;

import java.util.ArrayList;
import java.util.HashMap;

public class substringWithConcatenation {
	
	public static void main(String args[]){
		substringWithConcatenation s=new substringWithConcatenation();
		String[] L={"foo", "bar"};
		System.out.println(s.findSubstring("barfoothefoobarman", L));
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<String> cache=new ArrayList<String>();
		int length = L.length * (L[0].length());
		for (int i = 0; i < S.length() - length; i++) {
			String tmp = S.substring(i, i + length);
			if(cache.contains(tmp)){
				result.add(i);
			}
			if (checkSubString(tmp, L) == true) {
				result.add(i);
				cache.add(tmp);
			}
		}
		return result;
	}

	private boolean checkSubString(String s, String[] L) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int length=L[0].length();
		for (String tmp : L) {
			if(map.containsKey(tmp)){
				map.put(tmp, map.get(tmp)+1);
			}else{
				map.put(tmp, 1);
			}
		}
		for (int i = 0; i <= s.length()-length; i = i + length) {
			String tmp = s.substring(i, i + length);
			if(map.containsKey(tmp)){
				if(map.get(tmp)==1){
					map.remove(tmp);
				}else{
					map.put(tmp, map.get(tmp)-1);
				}
			}
		}
		if (map.size() == 0) {
			return true;
		}
		return false;
	}
}
