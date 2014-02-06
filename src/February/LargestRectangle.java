package February;

import java.util.Stack;

public class LargestRectangle {

	public static void main(String args[]) {
		LargestRectangle l = new LargestRectangle();
		int[] height = { 2,123,9,1};
		System.out.println(l.largestRectangleArea(height));
	}

	public int largestRectangleArea(int[] height) {
		int maxArea = 0;
		int len = height.length;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (stack.empty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
			} else {
				int tmp = stack.pop();
				int tmparea = 0;
				if (stack.empty()) {
					tmparea = height[i] * (i + 1);
				} else {
					tmparea = height[i] * (i-tmp);
				}
				maxArea = Math.max(maxArea, tmparea);
				i--;
			}

		}
		while(!stack.empty()){
			int tmp=stack.pop();
			int tmparea=height[tmp]*(len-tmp);
			maxArea = Math.max(maxArea, tmparea);
		}
		return maxArea;
	}
}
