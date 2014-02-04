package February;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePost {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return result;
		}
		stack.push(root);
		while (true) {
			if (stack.empty()) {
				break;
			}
			TreeNode tmp = stack.pop();
			result.add(tmp.val);
			if (tmp.left != null) {
				stack.push(tmp.left);
			}
			if (tmp.right != null) {
				stack.push(tmp.right);
			}

		}
		ArrayList<Integer> newResult = new ArrayList<Integer>();
		for (int i = 0; i < result.size(); i++) {
			newResult.add(result.get(result.size() - 1 - i));
		}
		return newResult;
	}
}
