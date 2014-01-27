package Jan;

import java.util.ArrayList;

public class SumRootToLeafNum {

	public int sumNumbers(TreeNode root) {
        //preorder traverse
        ArrayList<String>result=new ArrayList<String>();
        if(root==null){
            return 0;
        }
        traverse(result,"",root);
        int sum=0;
        for(String s:result){
            if(s.equals("")){
                sum+=0;
                continue;
            }
            sum+=Integer.parseInt(s);
        }
        return sum;
    }
    
    private void traverse(ArrayList<String> result,String route,TreeNode node){
        if(node==null){
            result.add(route);
            return;
        }
        int val=node.val;
        String newRoute=route+val;
        //if leave node, add into result
        if(node.left==null && node.right==null){
            result.add(newRoute);
            return;
        }
        if(node.left!=null)
            traverse(result,newRoute,node.left);
        if(node.right!=null)
            traverse(result,newRoute,node.right);
        
    }
}
