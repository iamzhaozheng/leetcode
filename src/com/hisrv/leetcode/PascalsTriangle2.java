package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class PascalsTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        final int k = rowIndex;
        Integer[] ret = new Integer[k + 1];
        for (int i = 0; i <= k; i ++) {
            for (int j = k - i; j <= k; j ++) {
                if (j == k - i || j == k) {
                    ret[j] = 1;
                } else {
                    ret[j] = ret[j] + ret[j + 1];
                }
            }
        }
        ArrayList<Integer> r = new ArrayList<Integer> ();
        Collections.addAll(r, ret);
        return r;
    }
}
