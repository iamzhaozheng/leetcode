package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;

import com.hisrv.leetcode.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.offer(root);
        int n = 1;
        boolean leftToRight = true;
        ArrayList<Integer> list = new ArrayList<Integer> ();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (leftToRight) {
                list.add(node.val);
            } else {
                list.add(0, node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            n --;
            if (n == 0) {
                n = queue.size();
                leftToRight = !leftToRight;
                ret.add(list);
                list = new ArrayList<Integer> ();
            }
        }
        return ret;
    }
}
