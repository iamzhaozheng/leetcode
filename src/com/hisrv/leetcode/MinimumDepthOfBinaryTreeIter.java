package com.hisrv.leetcode;

import java.util.LinkedList;

public class MinimumDepthOfBinaryTreeIter {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (root == null) {
    		return 0;
    	}
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode> ();
    	root.val = 1;
    	queue.add(root);
    	TreeNode p = null;
    	while (true) {
    		p = queue.remove();
    		if (p.left == null && p.right == null) {
    			return p.val;
    		} 
    		if (p.right != null) {
    			p.right.val = p.val + 1;
    			queue.add(p.right);
    		}
    		if (p.left != null) {
    			p.left.val = p.val + 1;
    			queue.add(p.left);
    		}
    	}
    }
}
