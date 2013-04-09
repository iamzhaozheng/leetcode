package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }
    
    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (!recur(left.left, right.right)) {
            return false;
        }
        if (!recur(left.right, right.left)) {
            return false;
        }
        return true;
    }
}
