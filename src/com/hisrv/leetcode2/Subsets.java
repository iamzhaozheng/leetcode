package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        int n = S.length;
        int m = 1 << n;
        for (int i = 0; i < m; i ++) {
            ret.add(mask(S, i));
        }
        return ret;
    }
    
    private ArrayList<Integer> mask(int[] s, int msk) {
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        int i = 0;
        while (msk != 0) {
            if ((msk & 1) != 0) {
                ret.add(s[i]);
            }
            msk = msk >> 1;
            i ++;
        }
        return ret;
    }
}
