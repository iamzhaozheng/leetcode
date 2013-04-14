package com.hisrv.leetcode2;

import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        ret.add(0);
        for (int i = 0; i < n; i ++) {
            for (int j = ret.size() - 1; j >= 0; j --) {
                ret.add(ret.get(j) + (1 << i));
            }
        }
        return ret;
    }
}
