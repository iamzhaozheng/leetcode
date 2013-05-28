package com.hisrv.leetcode2;

import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0 || k <= 0 || k > n) {
            return null;
        }
        return combine(1, n, k);
    }
    
    private ArrayList<ArrayList<Integer>> combine(int start, int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        if (start > n) {
            return ret;
        }
        for (int i = start; i <= n; i ++) {
            if (k > 1) {
                ArrayList<ArrayList<Integer>> com = combine(i + 1, n, k - 1);
                for (ArrayList<Integer> list : com) {
                    list.add(0, i);
                }
                ret.addAll(com);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer> ();
                list.add(i);
                ret.add(list);
            }
        }
        return ret;
    }
}
