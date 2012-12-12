package com.hisrv.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        for (int i = 0; i < numRows; i ++) {
            ArrayList<Integer> list = new ArrayList<Integer> ();
            for (int j = 0; j <= i; j ++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    ArrayList<Integer> l = ret.get(i - 1);
                    list.add(l.get(j - 1) + l.get(j));
                }
            }
            ret.add(list);
        }
        return ret;
    }
}
