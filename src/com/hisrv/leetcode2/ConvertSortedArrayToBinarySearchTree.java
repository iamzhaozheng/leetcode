package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recur(num, 0, num.length - 1);
    }
    
    private TreeNode recur(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = recur(num, start, mid - 1);
        node.right = recur(num, mid + 1, end);
        return node;
    }
}
