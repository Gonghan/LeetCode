package Nov;

import java.util.ArrayList;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervalsSolution s= new MergeIntervalsSolution();
		ArrayList<Interval> intervals=new ArrayList<Interval>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(1,4));
		intervals=s.merge(intervals);
		System.out.println(intervals);

	}
}

/*
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 */

// Definition for an interval.
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
}

class MergeIntervalsSolution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result=new ArrayList<Interval>();
        //one by one merge into the result array
        for(Interval interval:intervals){
           result=merge(interval,result);
        }
        return result;
    }
    private ArrayList<Interval> merge(Interval interval,ArrayList<Interval> result){
        ArrayList<Interval> newResult=new ArrayList<Interval>();
        for(Interval oldInterval:result){
            ArrayList<Interval> tmpResult=mergeTwo(interval,oldInterval);
            if(tmpResult.size()==2){
                newResult.add(tmpResult.get(0));
            }
            interval=tmpResult.get(tmpResult.size()-1);
        }
        newResult.add(interval);
        return newResult;
    }
    
    //merge only two intervals and return a list of one or two intervals
    private ArrayList<Interval> mergeTwo(Interval first, Interval second){
        ArrayList<Interval>result=new ArrayList<Interval>();
        if(first.start<=second.end && second.start<=first.end){
            Interval tmp=new Interval(Math.min(first.start,second.start),Math.max(first.end,second.end));
            result.add(tmp);
            return result;
        }
        if(first.start>second.end){
            result.add(second);
            result.add(first);
            return result;
        }
        if(second.start>first.end){
            result.add(first);
            result.add(second);
            return result;
        }
        return result;
    }
}