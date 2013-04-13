package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Stack;

import com.hisrv.leetcode.TreeNode;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null) {
                node = stack.pop();
                ret.add(node.val);
                while (node.right == null && !stack.isEmpty()) {
                    node = stack.pop();
                    ret.add(node.val);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            } else {
                stack.push(node.left);
            }
        }
        return ret;
    }
}
