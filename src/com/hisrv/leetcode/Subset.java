package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        int n = S.length;
        int size = 1 << n;
        for (int i = 0; i < size; i ++) {
            ArrayList<Integer> r = new ArrayList<Integer> ();
            int k = i;
            int j = 0;
            while (k != 0) {
                if ((k & 1) == 1) {
                    r.add(S[j]);
                }
                j ++;
                k = k >> 1;
            }
            ret.add(r);
        }
        return ret;
    }
}
