package February;

import java.util.ArrayList;

public class InsertInterval {

	public static void main(String args[]) {
		InsertInterval i = new InsertInterval();
		Interval A = new Interval(1, 5);
		Interval B = new Interval(6, 9);
		Interval C = new Interval(8, 9);
		Interval D = new Interval(5, 6);
		// Interval newInterval=new Interval();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(A);
		intervals.add(B);
		//intervals.add(C);
		ArrayList<Interval> result = i.insert(intervals, D);
		System.out.println(result);

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		Interval tmp = null;
		for (Interval i : intervals) {
			ArrayList<Interval> tmplist = null;
			if (result.size() == 0 && tmp==null) {
				tmplist = mergeTwo(i, newInterval);
			} else {
				// Interval tmpint=result.get(result.size()-1);
				// result.remove(result.size()-1);
				tmplist = mergeTwo(tmp, i);
			}
			if (tmplist.size() == 1) {
				tmp = tmplist.get(0);
			} else {
				result.add(tmplist.get(0));
				tmp=tmplist.get(1);
			}
			System.out.println(tmp);
		}
		if(tmp!=null){
			result.add(tmp);
		}
		return result;
	}

	private ArrayList<Interval> mergeTwo(Interval first, Interval second) {

		ArrayList<Interval> result = new ArrayList<Interval>();
		// if (first.start == first.end) {
		// result.add(second);
		// return result;
		// }
		if (first.start > second.end) {
			result.add(second);
			result.add(first);
		} else if (second.start > first.end) {
			result.add(first);
			result.add(second);
		} else {
			Interval tmp = new Interval(Math.min(first.start, second.start),
					Math.max(first.end, second.end));
			result.add(tmp);
		}
		return result;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}