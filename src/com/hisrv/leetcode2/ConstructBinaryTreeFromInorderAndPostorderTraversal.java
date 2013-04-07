package com.hisrv.leetcode2;

import com.hisrv.leetcode.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int[] mInorder;
    private int[] mPostorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        mInorder = inorder;
        mPostorder = postorder;
        return recur(0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode recur(int ins, int ine, int posts, int poste) {
        if (ine < ins) {
            return null;
        }
        TreeNode node = new TreeNode(mPostorder[poste]);
        int p = ins;
        while (mInorder[p] != mPostorder[poste]) {
            p ++;
        }
        node.left = recur(ins, p - 1, posts, posts + p - ins - 1);
        node.right = recur(p + 1, ine, posts + p - ins, poste - 1);
        return node;
    }
}
