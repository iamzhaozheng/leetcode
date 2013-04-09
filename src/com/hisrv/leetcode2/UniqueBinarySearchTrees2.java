package com.hisrv.leetcode2;

import java.util.ArrayList;

import com.hisrv.leetcode.TreeNode;

public class UniqueBinarySearchTrees2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> list = new ArrayList<TreeNode> ();
        return recur(1, n);
    }
    
    private ArrayList<TreeNode> recur(int s, int m) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode> ();
        if (m == 1) {
            TreeNode node = new TreeNode(s);
            list.add(node);
            return list;
        } else if (m == 0) {
            list.add(null);
            return list;
        } else {
            for (int i = s; i < s + m; i ++) {
                ArrayList<TreeNode> left = recur(s, i - s);
                ArrayList<TreeNode> right = recur(i + 1, m - i + s - 1);
                for (int j = 0; j < left.size(); j ++) {
                    for (int k = 0; k < right.size(); k ++) {
                        TreeNode node = new TreeNode(i);
                        node.left = left.get(j);
                        node.right = right.get(k);
                        list.add(node);
                    }
                }                
            }
            return list;
        }
        
    }
}
