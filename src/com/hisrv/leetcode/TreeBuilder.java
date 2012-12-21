package com.hisrv.leetcode;

import java.util.LinkedList;

public class TreeBuilder {
	public static TreeNode create(String[] l) {
		if (l.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(l[0]));
		TreeNode p = root;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int i = 1;
		boolean left = true;
		while (i < l.length) {
			if (l[i].equals("#")) {
				if (left) {
					p.left = null;
				} else {
					p.right = null;
					p = queue.poll();
				}
			} else {
				if (left) {
					p.left = new TreeNode(Integer.parseInt(l[i]));
					queue.push(p.left);
				} else {
					p.right = new TreeNode(Integer.parseInt(l[i]));
					queue.push(p.right);
					p = queue.poll();
				}
			}
			left = !left;
			i ++;
		}
		return root;
	}
	
	public static void out(TreeNode root) { 
		if (root == null) {
			System.out.println("#");
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.push(root);
		TreeNode p = root;
		System.out.print(p.val);
		while (!queue.isEmpty()) {
			p = queue.poll();
			System.out.print(",");
			if (p.left != null) {
				queue.push(p.left);
				System.out.print(p.left.val);
			} else {
				System.out.print("#");
			}
			System.out.print(",");
			if (p.right != null) {
				queue.push(p.right);
				System.out.print(p.right.val);
			} else {
				System.out.print("#");
			}
		}
		System.out.println();
	}
}
