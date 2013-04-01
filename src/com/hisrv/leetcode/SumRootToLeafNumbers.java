package com.hisrv.leetcode;

public class SumRootToLeafNumbers {
    private int ret;
    
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret = 0;
        if (root != null) {
            sum(root, 0);
        }
        return ret;
    }
    
    private void sum(TreeNode node, int value) {
        value = value * 10 + node.val;
        if (node.left == null && node.right == null) {
            ret += value;
            return;
        }
        if (node.left != null) {
            sum(node.left, value);
        }
        if (node.right != null) {
            sum(node.right, value);
        }
    }
}
