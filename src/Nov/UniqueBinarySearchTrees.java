package Nov;

import java.util.ArrayList;
// http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */


public class UniqueBinarySearchTrees {
	
	public static void main(String args[]){
		
	}
	
	class Solution {

		public ArrayList<TreeNode> generateTrees(int n) {
			return generateTrees(1, n);
		}

		public ArrayList<TreeNode> generateTrees(int a, int b) {
			ArrayList<TreeNode> result = new ArrayList<TreeNode>();
			if (a > b) {
				result.add(null);
			} else {
				if (a == b) {
					result.add(new TreeNode(a));
				} else {
					for (int i = a; i <= b; i++) {
						ArrayList<TreeNode> left = generateTrees(a, i - 1);
						ArrayList<TreeNode> right = generateTrees(i + 1, b);
						for (TreeNode n : left) {
							for (TreeNode m : right) {
								TreeNode temp = new TreeNode(i);
								temp.left = n;
								temp.right = m;
								result.add(temp);
							}
						}
					}
				}
			}
			return result;
		}

	}

}

