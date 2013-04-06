package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l != null) {
            flatten(l);
        }
        if (r != null) {
            flatten(r);
        }
        root.left = null;
        if (l == null) {
            root.right = r;
        } else {
            root.right = l;
            while (l.right != null) {
                l = l.right;
            }
            l.right = r;
        }
    }
}
