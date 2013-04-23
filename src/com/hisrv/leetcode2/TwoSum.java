package com.hisrv.leetcode2;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = numbers.length;
        int[] ret = new int[2];
        if (n < 2) {
            return null;
        }
        Num[] num = new Num[n];
        for (int k = 0; k < n; k ++) {
            num[k] = new Num(numbers[k], k + 1);
        }
        Arrays.sort(num, new Comparator<Num> () {
            public int compare(Num a, Num b) {
                return b.v - a.v;
            }
        });
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = num[i].v + num[j].v;
            if (sum < target) {
                j --;
            } else if (sum > target) {
                i ++;
            } else {
                ret[0] = num[i].idx;
                ret[1] = num[j].idx;
                break;
            }
        }
        Arrays.sort(ret);
        return ret;
    }
    
    private class Num {
        int v;
        int idx;
        
        public Num(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
}
