package Jan;

import java.util.ArrayList;

/*
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serial
 */
public class BinaryTreeZigzag {

	public static void main(String args[]) {
		BinaryTreeZigzag b = new BinaryTreeZigzag();
		TreeNode A = new TreeNode(1);
		TreeNode B = new TreeNode(2);
		TreeNode C = new TreeNode(3);
		TreeNode D = new TreeNode(4);
		TreeNode E = new TreeNode(5);
		A.left = B;
		A.right = C;
		B.left = D;
		D.right = E;
		System.out.println(b.zigzagLevelOrder(A));
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
		if (root == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		while (true) {
			ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
			if (result.size() == 0) {
				tmp.add(root);
				result.add(tmp);
				continue;
			}
			ArrayList<TreeNode> preLevel = result.get(result.size() - 1);
			for (TreeNode node : preLevel) {
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
			}
			if (tmp.size() != 0) {
				result.add(tmp);
			} else {
				break;
			}
		}
		int level=0;
		// convert result into integer result
		ArrayList<ArrayList<Integer>> intResult = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<TreeNode> tmp : result) {
			ArrayList<Integer> subTmp = new ArrayList<Integer>();
			for (int i=0;i<tmp.size();i++) {
				if(level%2==1){
					subTmp.add(tmp.get(tmp.size()-i-1).val);
				}else{
					subTmp.add(tmp.get(i).val);
				}
			}
			intResult.add(subTmp);
			level++;
		}
		return intResult;
	}
}
