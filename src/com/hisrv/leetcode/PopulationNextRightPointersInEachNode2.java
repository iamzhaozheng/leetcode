package com.hisrv.leetcode;

public class PopulationNextRightPointersInEachNode2 {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        TreeLinkNode left, top, p, q;
        root.next = null;
        top = root;
        if (top.left == null && top.right == null) {
            return;
        }
        if (top.left == null) {
            left = top.right;
        } else {
            left = top.left;
        }
        p = left;
        while (true) {
            q = findNext(top, p);
            if (q == null) {
                top = left;
                left = findNext(top, null);
                if (left == null) {
                    return;
                }
                p = left;
            } else {
                p.next = q;
                p = q;
            }
        }
    }
    
    private TreeLinkNode findNext(TreeLinkNode top, TreeLinkNode now) {
        if (now == null) {
            if (top.left != null) {
                return top.left;
            } else if (top.right != null) {
                return top.right;
            }
        } else if (now == top.left && top.right != null) {
            return top.right;
        }
        top = top.next;
        if (top == null) {
            return null;
        }
        while (top.left == null && top.right == null) {
            top = top.next;
            if (top == null) {
                return null;
            }
        }
        return top.left != null ? top.left : top.right;
    }
}
