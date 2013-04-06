package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeConstantSpace {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        TreeLinkNode parent = root;
        TreeLinkNode start = null;
        TreeLinkNode last = null;
        while (parent != null) {
            if (parent.left != null) {
                if (last == null) {
                    last = parent.left;
                    start = last;
                } else {
                    last.next = parent.left;
                    last = last.next;
                }
            }
            if (parent.right != null) {
                if (last == null) {
                    last = parent.right;
                    start = last;
                } else {
                    last.next = parent.right;
                    last = last.next;
                }
            }
            if (parent.next != null) {
                parent = parent.next;
            } else {
                last = null;
                parent = start;
                start = null;
            }
        }
    }
}
