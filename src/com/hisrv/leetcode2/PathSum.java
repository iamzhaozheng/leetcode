package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        } else if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
