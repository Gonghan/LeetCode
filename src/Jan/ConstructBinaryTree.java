package Jan;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstructBinaryTree {

	
	
	
	public static void main(String args[]){
		int[]inorder={1,5,2,7,3,6,4};
		int[]postorder={1,2,5,3,4,6,7};
		TreeNode root=new ConstructBinaryTree().buildTree(inorder,postorder);
		System.out.println(root);
	}
	
	
	ArrayList<Integer>visited;
	HashMap<Integer,Integer>map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length=inorder.length;
        visited=new ArrayList<Integer>();
        map=new HashMap<Integer,Integer>();
        for(int i=0;i<postorder.length;i++){
        	map.put(postorder[i], i);
        }
        if(length==0){
            return null;
        }
        int value=postorder[length-1];
        TreeNode root=new TreeNode(value);
        visited.add(root.val);
        buildTree(root,inorder,postorder);
        return root;
    }
    
    private void buildTree(TreeNode current,int[]inorder,int[] postorder){
        if(current==null){
            return;
        }
        int length=inorder.length;
        int value=current.val;
        int index=getIndex(inorder,value);
        //create left
        //ahead of current in inorder
        //last in postorder
        //not visited
        for(int i=index-1;i>=0;i--){
            int tmp=inorder[i];
            if(visited.contains(tmp)){
                break;
            }
            if(current.left==null){
                current.left=new TreeNode(tmp);
            }else{
                int oldValue=current.left.val;
                if(getIndex(postorder,oldValue)<getIndex(postorder,tmp)){
                    current.left=new TreeNode(tmp);
                }
            }
        }
        if(current.left!=null){
            visited.add(current.left.val);
        }
        buildTree(current.left,inorder,postorder);
        //create right
        for(int i=index+1;i<length;i++){
            int tmp=inorder[i];
            if(visited.contains(tmp)){
                break;
            }
            if(current.right==null){
                current.right=new TreeNode(tmp);
            }else{
                int oldValue=current.right.val;
                if(getIndex(postorder,oldValue)<getIndex(postorder,tmp)){
                    current.right=new TreeNode(tmp);
                }
            }
        }
        if(current.right!=null){
            visited.add(current.right.val);
        }
        buildTree(current.right,inorder,postorder);
    }
    
    private int getIndex(int[]xorder,int value){
        return map.get(value);
    }
}
