package Jan;

import java.util.ArrayList;

public class BinaryTreeInorder {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		inorder(root, result);
		return result;
	}

	private void inorder(TreeNode node, ArrayList<Integer> result) {
		if (node != null) {
			inorder(node.left, result);
			result.add(node.val);
			inorder(node.right, result);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}