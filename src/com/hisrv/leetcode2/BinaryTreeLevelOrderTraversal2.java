package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;

import com.hisrv.leetcode.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.offer(root);
        int n = 1;
        ArrayList<Integer> list = new ArrayList<Integer> ();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.val);
            n --;
            if (n == 0) {
                ret.add(0, list);
                n = queue.size();
                list = new ArrayList<Integer> ();
            }
        }
        return ret;
    }
}
