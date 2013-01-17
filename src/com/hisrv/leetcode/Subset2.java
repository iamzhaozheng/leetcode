package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
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
            boolean flag = true;
            while (k != 0) {
                if ((k & 1) == 1) {
                    if (j + 1 < n && S[j] == S[j + 1] && (k & 2) == 0) {
                        flag = false;
                        break;
                    }
                    r.add(S[j]);
                }
                j ++;
                k = k >> 1;
            }
            if (flag) {
                ret.add(r);
            }
        }
        return ret;
    }

}
