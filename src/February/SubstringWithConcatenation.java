package February;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringWithConcatenation {

	public static void main(String args[]) {
		SubstringWithConcatenation s = new SubstringWithConcatenation();
		String L[] = { "foo", "bar" };
		System.out.println(s.findSubstring("barfoothefoobarman", L));
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S.isEmpty() || L.length == 0) {
			return result;
		}
		// length of each node in L
		int k = L[0].length();
		int num = L.length;
		Map<String, Integer> map = new HashMap<>();
		for (String s : L) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}

		}
		for (int i = 0; i + num * k <= S.length(); i++) {
			Map<String,Integer>tmpmap=new HashMap<>(map);
			for(int j=0;j<num;j++){
				String tmpstr=S.substring(i+j*k,i+j*k+k);
				if(tmpmap.containsKey(tmpstr)){
					int counter=tmpmap.get(tmpstr);
					if(counter<=1){
						tmpmap.remove(tmpstr);
					}else{
						tmpmap.put(tmpstr, counter-1);
					}
				}
			}
			if(tmpmap.isEmpty()){
				result.add(i);
			}
		}

		return result;
	}
}
