package com.hisrv.leetcode;

public class SymmeticTree {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        return mirrorSame(root.left, root.right);
    }
    
    private boolean mirrorSame(TreeNode tl, TreeNode tr) {
        if (tl == null) {
            if (tr == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (tr == null) {
                return false;
            } else if (tl.val != tr.val) {
                return false;
            } else {
                return mirrorSame(tl.left, tr.right) && mirrorSame(tl.right, tr.left);
            }
        }
    }
}
