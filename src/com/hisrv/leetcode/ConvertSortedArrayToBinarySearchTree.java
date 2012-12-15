package com.hisrv.leetcode;

public class ConvertSortedArrayToBinarySearchTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	private TreeNode bst(int[] num, int s, int e) {
		int m = (s + e) / 2;
		TreeNode root = new TreeNode(num[m]);
		if (s < m) {
			root.left = bst(num, s, m - 1);
		} else {
			root.left = null;
		}
		if (e > m) {
			root.right = bst(num, m + 1, e);
		} else {
			root.right = null;
		}
		return root;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length == 0) {
			return null;
		}
		return bst(num, 0, num.length - 1);
	}
}
