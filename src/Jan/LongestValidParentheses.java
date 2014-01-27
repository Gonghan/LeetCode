package Jan;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		Stack<Pair> stack = new Stack<Pair>();
		char chs[] = s.toCharArray();
		int tmpArray[] = new int[chs.length];
		for (int i = 0; i < chs.length; i++) {
			char value = chs[i];
			Pair p = new Pair(i, value);
			if (value == '(') {
				stack.push(p);
			} else {
				if (stack.empty()) {
					continue;
				} else {
					Pair tmp = stack.pop();
					tmpArray[tmp.pos] = 1;
					tmpArray[i] = 1;
				}
			}
		}
		int maxLen = 0;
		int tmpV = 0;
		for (int i : tmpArray) {
			tmpV = (tmpV + i) * i;
			maxLen = Math.max(maxLen, tmpV);
		}
		return maxLen;
	}
}

class Pair {
	int pos;
	char val;

	public Pair(int p, char c) {
		this.pos = p;
		this.val = c;
	}
}