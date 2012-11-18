package com.hisrv.leetcode;
public class BalanceBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class Solution {

		private int getHeight(TreeNode t) {
			if (t == null) {
				return 0;
			}
			return Math.max(getHeight(t.left), getHeight(t.right)) + 1;
		}

		public boolean isBalanced(TreeNode root) {
			// Start typing your Java solution below
			// DO NOT write main() function
			if (root == null) {
				return true;
			}
			if (isBalanced(root.left)
					&& isBalanced(root.right)
					&& Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
				return true;
			} else {
				return false;
			}
		}
	}
}
