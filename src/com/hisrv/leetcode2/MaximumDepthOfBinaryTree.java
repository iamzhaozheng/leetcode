package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
