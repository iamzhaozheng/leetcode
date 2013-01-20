package com.hisrv.leetcode;

public class BinaryTreeMaximumPathSum {
	
    private int mMax;
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return 0;
        }
        mMax = Integer.MIN_VALUE;
        travPost(root);
        return mMax;
    }
    
    private Path travPost(TreeNode node) {
        Path p = new Path();
        if (node.left == null) {
            p.left = 0;
        } else {
            Path pl = travPost(node.left);
            p.left = Math.max(Math.max(pl.left, pl.right) + node.left.val, 0);
        }
        if (node.right == null) {
            p.right = 0;
        } else {
            Path pr = travPost(node.right);
            p.right = Math.max(Math.max(pr.left, pr.right) + node.right.val, 0);
        }
        mMax = Math.max(Math.max(p.left, 0) + node.val + Math.max(p.right, 0), mMax);
        return p;
    }
    
    private class Path {
        public int left;
        public int right;
    }
}
