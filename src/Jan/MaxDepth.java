package Jan;

public class MaxDepth {

	public int maxDepth(TreeNode root) {
        return depth(root);
    }
    
    private int depth(TreeNode node){
        if(node!=null){
            return Math.max(depth(node.right),depth(node.left))+1;
        }else{
            return 0;
        }
    }
}
