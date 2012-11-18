package com.hisrv.leetcode;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode t = root;
		s.push(t);
		TreeNode p = t;
		while (!s.empty()) {
			t = s.pop();
			if (t.right != null) {
				s.push(t.right);
			}
			if (t.left != null) {
				s.push(t.left);
			}
			if (p != t) {
				p.right = t;
				p.left = null;
				p = t;
			}
		}
		p.right = null;
	}
}
