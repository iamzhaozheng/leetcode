package com.hisrv.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = numbers.length;
        Comb[] combs = new Comb[n];
        for (int i = 0; i < n; i ++) {
        	combs[i] = new Comb();
            combs[i].val = numbers[i];
            combs[i].idx = i + 1;
        }
        Arrays.sort(combs, new Comparator<Comb> () {
            public int compare(Comb c1, Comb c2) {
                return c1.val - c2.val;
            }
        });
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (combs[i].val + combs[j].val < target) {
                i ++;
            } else if (combs[i].val + combs[j].val > target) {
                j --;
            } else {
                int[] ret = new int[] {combs[i].idx, combs[j].idx};
                Arrays.sort(ret);
                return ret;
            }
        }
        return new int[] {};
    }
    
    private class Comb {
        public int val;
        public int idx;
    }
}
