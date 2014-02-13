package February;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String args[]) {
		SimplifyPath s = new SimplifyPath();
		System.out
				.println(s
						.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}

	public String simplifyPath(String path) {
		String result = "";
		Stack<String> stack = new Stack<String>();
		Stack<String> extraStack = new Stack<String>();
		String[] strs = path.split("/");
		for (String s : strs) {
			if (s.equals(".") || s.isEmpty()) {
				continue;
			}
			if (s.equals("..")) {
				if (stack.empty()) {
					// return "/";
					extraStack.push(s);
				} else {
					stack.pop();
				}
			} else {
				if(extraStack.empty()){
					stack.push(s);
				}else{
					extraStack.pop();
					stack.push(s);
				}
			}
		}
		while (!stack.empty()) {
			result = "/" + stack.pop() + result;
		}
		if (result.isEmpty()) {
			return "/";
		}
		return result;
	}
}
