package March;

import February.TreeNode;

public class SortedArrayToBST {

	public static void main(String args[]) {
		SortedArrayToBST s=new SortedArrayToBST();
		int array[]={1,2,2,4,5,5};
		TreeNode head=s.convert(array);
		System.out.println(head.val);
	}

	public TreeNode convert(int[] array) {
		return convert(array, 0, array.length);
	}

	private TreeNode convert(int[] array, int start, int length) {
		if (length <= 0) {
			return null;
		}
		TreeNode head = new TreeNode(array[start + length / 2]);
		head.left = convert(array, start, length / 2);
		head.right = convert(array, start + length / 2 + 1, length - length / 2
				- 1);
		return head;
	}

}
