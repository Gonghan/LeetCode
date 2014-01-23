package Jan;

import java.util.HashMap;

public class MaxPointsOnALine {

	public static void main(String args[]) {
		MaxPointsOnALine m = new MaxPointsOnALine();
		Point[] points = { new Point(84, 250), new Point(0, 0),
				new Point(1, 0), new Point(0, -70), new Point(0, -70),
				new Point(1, -1), new Point(21, 10), new Point(42, 90),
				new Point(-42, -230) };
		int result = m.maxPoints(points);
		System.out.println(result);
	}

	public int maxPoints(Point[] points) {
		int result = 0;
		for (Point p : points) {
			result = Math.max(result, maxPointFromStart(p, points));
		}

		return result;
	}

	private int maxPointFromStart(Point start, Point[] points) {
		int result = 0;
		int samePoint = 0;
		HashMap<Float, Integer> cache = new HashMap<Float, Integer>();
		for (Point tmp : points) {

			if (tmp == start) {
				continue;
			}
			if (tmp.x == start.x && tmp.y == start.y) {
				samePoint++;
				continue;
			}
			float k = 0.0f;
			// xie lv
			if (start.x == tmp.x) {
				k = Integer.MAX_VALUE;
			} else {
				k =1.0f* (start.y - tmp.y) / (start.x - tmp.x);
			}
			if (cache.containsKey(k)) {
				cache.put(k, cache.get(k) + 1);
			} else {
				cache.put(k, 1);
			}
		}
		for (float f : cache.keySet()) {
			int times = cache.get(f);
			result = Math.max(result, times);
		}
		return result + samePoint + 1;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}