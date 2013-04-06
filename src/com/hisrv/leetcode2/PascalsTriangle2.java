package com.hisrv.leetcode2;

import java.util.ArrayList;

public class PascalsTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = rowIndex + 1;
        ArrayList<Integer> list = new ArrayList<Integer> ();
        list.add(1);
        for (int i = 1; i < n; i ++) {
            ArrayList<Integer> old = list;
            list = new ArrayList<Integer> ();
            for (int j = 0; j <= i; j ++) {
                int a = j == 0 ? 0 : old.get(j - 1);
                int b = j == i ? 0 : old.get(j);
                list.add(a + b);
            }
        }
        return list;
    }
}
