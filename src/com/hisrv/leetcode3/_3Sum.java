package com.hisrv.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;

public class _3Sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        Arrays.sort(num);
        int j, k, sum;
        for (int i = 0; i < num.length - 2; i ++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            j = i + 1;
            k = num.length - 1;
            while (j < k) {
                sum = num[i] + num[j] + num[k];
                if (sum > 0) {
                    k --;
                } else if (sum < 0) {
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
