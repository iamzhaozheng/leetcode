package com.hisrv.leetcode2;

import java.util.ArrayList;

public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = numRows;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        if (n == 0) {
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<Integer> ();
        list.add(1);
        ret.add(list);
        for (int i = 1; i < n; i ++) {
            ArrayList<Integer> old = ret.get(ret.size() - 1);
            list = new ArrayList<Integer> ();
            for (int j = 0; j <= i; j ++) {
                int a = j == 0 ? 0 : old.get(j - 1);
                int b = j == i ? 0 : old.get(j);
                list.add(a + b);
            }
            ret.add(list);
        }
        return ret;
    }
}
