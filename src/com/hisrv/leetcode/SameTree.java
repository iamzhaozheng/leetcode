package com.hisrv.leetcode;

import java.util.Stack;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> ps, qs;
        TreeNode pp, qp;
        pp = p;
        qp = q;
        ps = new Stack<TreeNode> ();
        qs = new Stack<TreeNode> ();
        while (pp != null) {
            if (qp == null) {
                return false;
            }
            if (pp.val != qp.val) {
                return false;
            }
            ps.push(pp);
            qs.push(qp);
            pp = pp.left;
            qp = qp.left;
            while (pp == null) {
                if (qp != null) {
                    return false;
                }
                if (ps.isEmpty()) {
                    if (qs.isEmpty()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (qs.isEmpty()) {
                        return false;
                    } else {
                        pp = ps.pop().right;
                        qp = qs.pop().right;
                    }
                }
            }
        }
        if (qp != null) {
            return false;
        }
        return true;
    }
}
