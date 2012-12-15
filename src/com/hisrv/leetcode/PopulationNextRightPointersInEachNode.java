package com.hisrv.leetcode;

public class PopulationNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        TreeLinkNode left, top, p;
        root.next = null;
        top = root;
        p = top.left;
        if (p == null) {
            return;
        }
        left = top.left;
        while (left != null) {
            if (top == null) {
                top = left;
                p = left.left;
                left = p;
            } else if (p == top.left) {
                p.next = top.right;
                p = top.right;
            } else if (p == top.right) {
                top = top.next;
                if (top != null) {
                    p.next = top.left;
                    p = top.left;
                }
            }
        }
    }
}
