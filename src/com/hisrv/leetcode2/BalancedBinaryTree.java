package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return !(getBalancedHeight(root) == -1);      
    }
    
    private int getBalancedHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int rh = getBalancedHeight(node.right);
        int lh = getBalancedHeight(node.left);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        } else {
            return Math.max(rh, lh) + 1;
        }
    }
}
