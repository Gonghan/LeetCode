package Jan;

public class SymmetricTree {

	boolean isSym;
    public boolean isSymmetric(TreeNode root) {
        isSym=true;
        traverse(root,root);
        return isSym;
    }
    
    private void traverse(TreeNode node,TreeNode node2){
        if(node==null && node2!=null){
            isSym=false;
            return;
        }
        if(node2==null && node!=null){
            isSym=false;
            return;
        }
        if(node==null && node2==null){
            return;
        }
        if(node.val!=node2.val){
            isSym=false;
            return;
        }
        traverse(node.left,node2.right);
        traverse(node.right,node2.left);
    }
    
}
