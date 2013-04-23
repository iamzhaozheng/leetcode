package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class _3Sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        int n = num.length;
        if (n < 3) {
            return ret;
        }
        Arrays.sort(num);
        for (int i = 0; i < n - 2; i ++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = num[i] + num[j] + num[k];
                if (s > 0) {
                    k --;
                } else if (s < 0) {
                    j ++;
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer> ();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    ret.add(list);
                    j ++;
                    while (j < k && num[j] == num[j - 1]) {
                        j ++;
                    }
                }
            }
        }
        return ret;
    }
}