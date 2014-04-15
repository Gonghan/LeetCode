package April;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import February.TreeNode;

public class generateTree {

	public TreeNode generate(int[] inorder, int[] levelorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		Set<Integer> set = new HashSet<>();
		for (int i : inorder) {
			set.add(i);
		}
		int curr = -1;
		for (int i=0;i< levelorder.length;i++) {
			if (set.contains(levelorder[i])) {
				curr=levelorder[i];
				break;
			}
		}
		TreeNode root = new TreeNode(curr);
		int pos = pos(inorder, curr);
		int[] left = Arrays.copyOfRange(inorder, 0, pos);
		int[] right = Arrays.copyOfRange(inorder, pos + 1, inorder.length);
		root.left = generate(left, levelorder);
		root.right = generate(right, levelorder);
		return root;
	}

	private int pos(int[] A, int target) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] inorder={2,3,1,5,7,6,4};
		int[] levelorder={1,2,4,3,5,6,7};
		TreeNode root=new generateTree().generate(inorder, levelorder);
		root.printTree();
	}
}
