package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class ConstractBinaryTreeFromPreorderAndInorderTraversal {
    private int[] mPreorder;
    private int[] mInorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = preorder.length;
        mPreorder = preorder;
        mInorder = inorder;
        return recur(0, n - 1, 0, n - 1);
    }
    
    private TreeNode recur(int ins, int ine, int pres, int pree) {
        if (ine < ins) {
            return null;
        }
        TreeNode node = new TreeNode(mPreorder[pres]);
        int m = 0;
        while (mInorder[ins + m] != mPreorder[pres]) {
            m ++;
        }
        node.left = recur(ins, ins + m - 1, pres + 1, pres + m);
        node.right = recur(ins + m + 1, ine, pres + m + 1, pree);
        return node;
    }
}
