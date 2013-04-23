package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class _4Sum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        int n = num.length;
        if (n < 4) {
            return ret;
        }
        Arrays.sort(num);
        for (int i = 0; i < n - 3; i ++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j ++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (sum > target) {
                        l --;
                        while (k < l && num[l] == num[l + 1]) {
                            l --;
                        }
                    } else if (sum < target) {
                        k ++;
                        while (k < l && num[k] == num[k - 1]) {
                            k ++;
                        }
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer> ();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[l]);
                        ret.add(list);
                        k ++;
                        while (k < l && num[k] == num[k - 1]) {
                            k ++;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
