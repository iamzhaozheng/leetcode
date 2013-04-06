package com.hisrv.leetcode2;

import java.util.ArrayList;

import com.hisrv.leetcode.TreeNode;

public class PathSum2 {
    private ArrayList<ArrayList<Integer>> ret;
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret = new ArrayList<ArrayList<Integer>> ();
        if (root == null) {
            return ret;
        }
        ArrayList<Integer> path = new ArrayList<Integer> ();
        trav(root, path, sum);
        return ret;
    }
    
    private void trav(TreeNode node, ArrayList<Integer> path, int sum) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                ret.add(new ArrayList<Integer> (path));
            }
        } else {
            if (node.left != null) {
                trav(node.left, path, sum - node.val);
            }
            if (node.right != null) {
                trav(node.right, path, sum - node.val);
            }
        }
        path.remove(path.size() - 1);
    }
}
