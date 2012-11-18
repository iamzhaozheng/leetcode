package com.hisrv.leetcode;


public class ConstructInorderPostorder {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder,
			int ps, int pe) {
		if (is > ie) {
			return null;
		}
		int v = postorder[pe];
		TreeNode root = new TreeNode(v);
		int n = is;
		while (inorder[n] != v) {
			n++;
		}
		if (n == is) {
			root.left = null;
		} else {
			root.left = buildTree(inorder, is, n - 1, postorder, ps, ps + n
					- is - 1);
		}
		if (n == ie) {
			root.right = null;
		} else {
			root.right = buildTree(inorder, n + 1, ie, postorder, ps + n - is,
					pe - 1);
		}
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}
}
