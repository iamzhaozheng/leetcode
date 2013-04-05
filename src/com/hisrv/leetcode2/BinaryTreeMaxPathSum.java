package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class BinaryTreeMaxPathSum {
    int ret;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret = Integer.MIN_VALUE;
        recur(root);
        return ret;
    }
    
    private MaxPath recur(TreeNode node) {
        MaxPath path = new MaxPath();
        if (node.left == null) {
            path.l = 0;
        } else {
            MaxPath lmp = recur(node.left);
            path.l = Math.max(Math.max(lmp.l, lmp.r), 0) + node.left.val;
        }
        if (node.right == null) {
            path.r = 0;
        } else {
            MaxPath rmp = recur(node.right);
            path.r = Math.max(Math.max(rmp.l, rmp.r), 0) + node.right.val;
        }
        ret =  Math.max(Math.max(0, path.l) + Math.max(0, path.r) + node.val, ret);
        return path;
    }
    
    private class MaxPath {
        public int l;
        public int r;
    }
}
