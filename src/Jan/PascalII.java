package Jan;

import java.util.ArrayList;

public class PascalII {

	public ArrayList<Integer> getRow(int rowIndex) {
		int k = rowIndex;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < k + 1; i++) {
			if (i == 0) {
				result.add(1);
				continue;
			}
			int previous = result.get(result.size() - 1);
			double tmp = 1.0d * previous * (k - i + 1) / i;
			int current = (int) tmp;
			result.add(current);
		}
		return result;
	}

}
