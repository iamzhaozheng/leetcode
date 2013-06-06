package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        return rec(candidates, 0, target);
    }
    
    private ArrayList<ArrayList<Integer>> rec(int[] num, int start, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        int n = num.length;
        if (n == 0) {
            return ret;
        }
        if (start == n - 1) {
            if (target % num[start] == 0) {
                ArrayList<Integer> list = new ArrayList<Integer> ();
                for (int i = 0; i < target / num[start]; i ++) {
                    list.add(num[start]);
                }
                ret.add(list);
            }
            return ret;
        }
        for (int i = 0; target - num[start] * i >= 0; i ++) {
            ArrayList<ArrayList<Integer>> r = rec(num, start + 1, target - num[start] * i);
            for (ArrayList<Integer> l : r) {
                for (int j = 0; j < i; j ++) {
                    l.add(0, num[start]);
                }
            }
            ret.addAll(r);
        }
        return ret;
    }
}
