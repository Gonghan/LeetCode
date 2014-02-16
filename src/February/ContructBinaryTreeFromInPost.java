package February;

import java.util.Arrays;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class ContructBinaryTreeFromInPost {

	public static void main(String args[]) {
		ContructBinaryTreeFromInPost c = new ContructBinaryTreeFromInPost();
		int inorder[] = { 4, 2, 5, 1, 6, 3 };
		int postorder[] = { 4, 5, 2, 6, 3, 1 };
		TreeNode head = c.buildTree(inorder, postorder);
		System.out.println(head.val);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0) {
			return null;
		}
		int len = inorder.length;
		// last node of postorder
		int postlast = postorder[len - 1];
		TreeNode tmp = new TreeNode(postlast);
		int pos = getPos(inorder, postlast);
		int leftin[] = Arrays.copyOfRange(inorder, 0, pos);
		int rightin[] = Arrays.copyOfRange(inorder, pos + 1, len);

		int leftpost[] = Arrays.copyOfRange(postorder, 0, pos);
		int rightpost[] = Arrays.copyOfRange(postorder, pos, len - 1);

		tmp.left = buildTree(leftin, leftpost);
		tmp.right = buildTree(rightin, rightpost);
		return tmp;
	}

	private int getPos(int[] A, int t) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == t) {
				return i;
			}
		}
		return -1;
	}
}
