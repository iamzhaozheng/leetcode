package com.hisrv.leetcode;

import java.util.Stack;

public class RecoverBinarySearchTree {
    private TreeNode last = null, t = null, t2 = null;
    private boolean update(TreeNode p) {
        if (last == null) {
            last = p;
        } else {
            if (last.val > p.val) {
                if (t == null) {
                    t = last;
                    t2 = p;
                } else {
                    swap(t, p);
                    return true;
                }
            }
        }
        last = p;
        return false;
    }
    
    private void swap(TreeNode a, TreeNode b) {
        if (a.val != b.val) {
            a.val ^= b.val;
            b.val ^= a.val;
            a.val ^= b.val;
        }
    }
    
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode> ();
        TreeNode p = root;
        while (p != null) {
            if (p.left == null) {
                while (p.right == null) {
                    if (update(p)) {
                        return;
                    }
                    if (s.isEmpty()) {
                        swap(t, t2);
                        return;
                    }
                    p = s.pop();
                }
                p = p.right;
            } else {
                s.push(p);
                p = p.left;
            }
        }
    }
}
