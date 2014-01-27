package Jan;

import java.util.ArrayList;
import java.util.Collections;

public class RecoverBinaryTree {

	public void recoverTree(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		ArrayList<Integer> vList = new ArrayList<Integer>();
		inorder(root, list,vList);
		ArrayList<TreeNode> wrongList = new ArrayList<TreeNode>();
		Collections.sort(vList);
		for (int i = 0; i < vList.size(); i++) {
			if (vList.get(i) != list.get(i).val) {
				wrongList.add(list.get(i));
			}
		}
		TreeNode first = wrongList.get(0);
		TreeNode second = wrongList.get(1);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	private void inorder(TreeNode node, ArrayList<TreeNode> list,
			ArrayList<Integer> vList) {
		if (node == null) {
			return;
		}
		inorder(node.left, list,vList);
		list.add(node);
		vList.add(node.val);
		inorder(node.right, list,vList);
	}
}
