package com.hisrv.leetcode;


/**
 * @author zhengzhaomail
 * 
 */
public class Main {
	public static void main(String[] args) {
		testReverseNodesInKGroup();
	}
	
	public static void testReverseNodesInKGroup() {
		ReverseNodesInKGroup f = new ReverseNodesInKGroup();
		ListNodeBuilder.out(f.reverseKGroup(ListNodeBuilder.create(new int[] {1, 2, 3, 4, 5, 6}), 2));
	}

	public static void testRegularExpMatching() {
		RegularExpressionMatching f = new RegularExpressionMatching();
		System.out.println(f.isMatch("a", "ab*a"));
	}
	
	public static void testRecoverBST() {
		RecoverBinarySearchTree f = new RecoverBinarySearchTree();
		TreeNode root = TreeBuilder.create(new String[] {"2", "#", "1"});
		f.recoverTree(root);
		TreeBuilder.out(root);
	}
	
	public static void testPow() {
		Pow f = new Pow();
		System.out.println(f.pow(1, 2));
	}
	
	public static void testPopulating() {
	    PopulationNextRightPointersInEachNode2 f = new PopulationNextRightPointersInEachNode2();
	    TreeLinkNode root = new TreeLinkNode(1);
	    TreeLinkNode l = new TreeLinkNode(2);
	    root.left = l;
	    l = new TreeLinkNode(3);
	    root.right = l;
	    l = new TreeLinkNode(4);
	    root.left.left = l;
        l = new TreeLinkNode(5);
        root.right.right = l;
	    f.connect(root);
	}
	
	public static void testNQueens() {
		NQueens f = new NQueens();
		f.solveNQueens(4);
	}
	
	public static void testMultiplyStrings() {
		MultiplyStrings f = new MultiplyStrings();
		System.out.println(f.multiply("9", "99"));
	}

	public static void testFindKth() {
		FindKthNum f = new FindKthNum();
		System.out.println(f.findKthMin(new int[] { 1, 3 }, new int[] { 2, 4 },
				2));
	}

	public static void testMedianOfTwoSortedArrays() {
		MedianOfTwoSortedArrays f = new MedianOfTwoSortedArrays();
		System.out.println(f.findMedianSortedArrays(new int[] { 1, 3 },
				new int[] { 2, 4 }));
	}

}
