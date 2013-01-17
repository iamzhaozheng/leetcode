package com.hisrv.leetcode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        return valid(root).bst;
    }
    
    private Comb valid(TreeNode node) {
        Comb comb = new Comb();
        if (node.left == null && node.right == null) {
            comb.bst = true;
            comb.max = node.val;
            comb.min = node.val;
        } else if (node.left == null) {
            comb.min = node.val;
            Comb r = valid(node.right);
            comb.max = r.max;
            comb.bst = r.bst && node.val < r.min;
        } else if (node.right == null) {
            comb.max = node.val;
            Comb l = valid(node.left);
            comb.min = l.min;
            comb.bst = l.bst && node.val > l.max;
        } else {
            Comb l = valid(node.left);
            Comb r = valid(node.right);
            comb.min = l.min;
            comb.max = r.max;
            comb.bst = l.bst && r.bst && l.max < node.val && r.min > node.val;
        }
        return comb;
    }
    
    private class Comb {
        public int max, min;
        public boolean bst;
    }
}
