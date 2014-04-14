package Jan;

import java.util.HashMap;

public class ValidateBinarySearchTree {
	
	public static void main(String args[]){
		TreeNode A=new TreeNode(10);
		TreeNode B=new TreeNode(5);
		TreeNode C=new TreeNode(15);
		TreeNode D=new TreeNode(6);
		TreeNode E=new TreeNode(20);
//		TreeNode F=new TreeNode(6);
		A.left=B;
		A.right=C;
		C.left=D;
		C.right=E;
		boolean result=new ValidateBinarySearchTree().isValidBST(A);
		System.out.println(result);
	}

	HashMap<TreeNode,Integer>minMap;
	HashMap<TreeNode,Integer>maxMap;
	public boolean isValidBST(TreeNode node){
		minMap=new HashMap<TreeNode,Integer>();
		maxMap=new HashMap<TreeNode,Integer>();
		getMax(node);
		getMin(node);
		return checkBST(node);
	}
	
	private boolean checkBST(TreeNode node) {
		if(node==null){
			return true;
		}
		boolean result=true;
		if(node.left!=null){
			result=result && (node.val>maxMap.get(node.left));
		}
		if(node.right!=null){
			result=result && (node.val<minMap.get(node.right));
		}
		return result && checkBST(node.left) && checkBST(node.right);
	}

	//get the max value of the tree with a given root node
	private int getMax(TreeNode node){
		if(node==null){
			return Integer.MIN_VALUE;
		}
		if(maxMap.containsKey(node)){
			return maxMap.get(node);
		}
		int max=Math.max(getMax(node.left), getMax(node.right));
		max=Math.max(max, node.val);
		maxMap.put(node, max);
		return max;
	}
	
	private int getMin(TreeNode node){
		if(node==null){
			return Integer.MAX_VALUE;
		}
		if(minMap.containsKey(node)){
			return minMap.get(node);
		}
		int min=Math.min(getMin(node.left), getMin(node.right));
		min=Math.min(min,node.val);
		minMap.put(node, min);
		return min;
	}
}
