package com.hisrv.leetcode;

import java.util.ArrayList;

public class PathSum2 {
    private ArrayList<ArrayList<Integer>> mRet;
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mRet = new ArrayList<ArrayList<Integer>> ();
        if (root != null) {
            ArrayList<Integer> list = new ArrayList<Integer> ();
            doit(root, sum, list);
        }
        return mRet;
    }
    
    private void doit(TreeNode t, int s, ArrayList<Integer> list) {
        list.add(t.val);
        if (t.left == null && t.right == null) {
            if (t.val == s) {
                mRet.add(new ArrayList<Integer>(list));
            }
        } else {
            if (t.left != null) {
                doit(t.left, s - t.val, new ArrayList<Integer>(list));
            }
            if (t.right != null) {
                doit(t.right, s - t.val, list);      
            }
        } 
    }
}
