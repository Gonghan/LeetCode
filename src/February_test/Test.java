package February_test;

import static org.junit.Assert.*;

import java.util.Arrays;

import February.*;

public class Test {

	@org.junit.Test
	public void WillCardMatchingtest() {
		WillcardMatching w = new WillcardMatching();
		assertEquals(true, w.isMatch("aa", "?a"));
		assertEquals(true, w.isMatch("aa", "aa"));
		assertEquals(false, w.isMatch("aaa", "aa"));
		assertEquals(true, w.isMatch("aa", "*"));
		assertEquals(true, w.isMatch("aa", "?*"));
		assertEquals(true, w.isMatch("aab", "?ab"));
		assertEquals(false, w.isMatch("aab", "a*b*c"));
		assertEquals(false, w.isMatch(
				"bbbababbbbabbbbababbaaabbaababbbaabbbaaaabbbaaaabb",
				"*b********bb*b*bbbbb*ba"));
	}

	@org.junit.Test
	public void EditDistance() {
		EditDistance e = new EditDistance();
		assertEquals(0, e.minDistance("", ""));
		assertEquals(0, e.minDistance("abc", "abc"));
		assertEquals(1, e.minDistance("ABC", "BC"));
		assertEquals(2, e.minDistance("ACB", "ABC"));
	}

	@org.junit.Test
	public void mergeTest() {
		MergeSort m = new MergeSort();
		int[] A = { 1, 3, 5, 56, 1, 3, 5, 8, 3 };
		int[] B = { 1, 1, 3, 3, 3, 5, 5, 8, 56 };
		m.mergeSort(A);
		assertEquals(3, A[2]);
		assertEquals(true, Arrays.equals(A, B));
	}

	@org.junit.Test
	public void LRUTest() {
		LRUCache l = new LRUCache(2);
		assertEquals(-1, l.get(3));
		l.set(2, 1);
		l.set(1, 1);
		assertEquals(1, l.get(2));
		l.set(4, 1);
		assertEquals(-1, l.get(1));
		assertEquals(1, l.get(2));
		l.set(6, 16);
		assertEquals(-1, l.get(4));
	}
	
	@org.junit.Test
	public void BTPost(){
		BinaryTreePost b=new BinaryTreePost();
		TreeNode A=new TreeNode(1);
		TreeNode B=new TreeNode(2);
		TreeNode C=new TreeNode(3);
		TreeNode D=new TreeNode(4);
		TreeNode E=new TreeNode(5);
		A.left=B;
		A.right=C;
		B.right=D;
		D.left=E;
		System.out.println(b.postorderTraversal(A));
		
	}
}
