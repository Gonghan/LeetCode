package February;

import java.util.ArrayList;

public class FlattenBinaryTreeToLinkedList {

	ArrayList<TreeNode> list;

	public void flatten(TreeNode root) {
		list = new ArrayList<TreeNode>();
		appendToList(root);
		TreeNode tmp = root;
		for (int i = 1; i < list.size(); i++) {
			tmp.right = list.get(i);
			tmp.left = null;
			tmp = tmp.right;
		}
		// return root;
	}

	private void appendToList(TreeNode node) {
		if (node == null) {
			return;
		}
		list.add(node);
		appendToList(node.left);
		appendToList(node.right);
	}
}
