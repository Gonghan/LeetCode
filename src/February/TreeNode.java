package February;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public void printTree(){
		printTree(this);
	}
	
	private void printTree(TreeNode root){
		if(root==null){
			return;
		}
		System.out.println(root.val);
		printTree(root.left);
		printTree(root.right);
	}
}