package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelTraversal {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return list;
		}
		int countNext = 1;
		q.add(root);
		while (q.size() > 0) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			int count = countNext;
			countNext = 0;
			while (count > 0) {
				TreeNode t = q.poll();
				count--;
				l.add(t.val);
				if (t.left != null) {
					q.add(t.left);
					countNext++;
				}
				if (t.right != null) {
					q.add(t.right);
					countNext++;
				}
			}
			list.add(l);
		}
		return list;
	}
}
