package Nov;

/*
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

public class SameTree {

	public static void main(String[] args) {

	}

}

class SameTreeSolution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// in-order check all nodes
		if (p == null || q == null) {
			if (p == null && q == null) {
				return true;
			} else {
				return false;
			}

		}
		if (isSameTree(p.left, q.left) && p.val == q.val
				&& isSameTree(p.right, q.right)) {
			return true;
		}
		return false;
	}

	// test1 p={},q={}
	// test2 p={a}, q={a{b,c}}
	// test3 p={a{b,c}}, q={a{b,c}}
	//
	//
}