package Jan;

import java.util.Arrays;

public class ConvertSortedArrayToBST {
	public static void main(String argsp[]){
		int[]num={2,3,4,5};
		TreeNode root=new ConvertSortedArrayToBST().sortedArrayToBST(num);
		System.out.println(root.val);
	}

	public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0){
            return null;
        }
        
        if(num.length==1){
            return new TreeNode(num[0]);
        }
        int mid=num.length/2;
        TreeNode tmp=new TreeNode(num[mid]);
        int left[]=Arrays.copyOfRange(num,0,mid);
        int right[]=Arrays.copyOfRange(num,mid+1,num.length);
        tmp.left=sortedArrayToBST(left);
        tmp.right=sortedArrayToBST(right);
        return tmp;
        
    }
}
