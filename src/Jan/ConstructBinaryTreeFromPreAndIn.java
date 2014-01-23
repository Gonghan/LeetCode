package Jan;

import java.util.Arrays;

/*Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreAndIn {

	public static void main(String args[]) {
		ConstructBinaryTreeFromPreAndIn c = new ConstructBinaryTreeFromPreAndIn();
		int pre[] = { 1, 2, 4, 3, 5, 6 };
		int in[] = { 2, 4, 1, 5, 3, 6 };
		TreeNode root = c.buildTree(pre, in);
		System.out.println(root.val);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0
				|| preorder.length != inorder.length)
			return null;

		int rootVal = preorder[0];
		TreeNode node = new TreeNode(rootVal);
		int numLeftCh = findIndex(inorder, rootVal);
		int numRightCh = inorder.length - numLeftCh - 1;

		if (numLeftCh > 0) {
			node.left = buildTree(
					Arrays.copyOfRange(preorder, 1, numLeftCh + 1),
					Arrays.copyOfRange(inorder, 0, numLeftCh));
		}
		if (numRightCh > 0) {
			node.right = buildTree(Arrays.copyOfRange(preorder, numLeftCh + 1,
					preorder.length), Arrays.copyOfRange(inorder,
					numLeftCh + 1, inorder.length));
		}
		return node;

	}

	public int findIndex(int[] arr, int val) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val)
				return i;
		}
		return -1;
	}
}
