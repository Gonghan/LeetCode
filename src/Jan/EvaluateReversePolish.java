package Jan;

import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolish {
	public static void main(String args[]) {
		EvaluateReversePolish e = new EvaluateReversePolish();
		String[] tokens = { "1", "2", "3", "*", "+" };
		System.out.println(e.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		for (String s : tokens) {
			if (s.equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a + b);
			} else if (s.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if (s.equals("*")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a * b);
			} else if (s.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				int value = Integer.parseInt(s);
				stack.push(value);
			}

		}
		return stack.pop();
	}
}
