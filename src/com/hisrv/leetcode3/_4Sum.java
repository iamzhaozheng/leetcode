package com.hisrv.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;

public class _4Sum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i ++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j ++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = num.length - 1;
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (sum > target) {
                        l --;
                    } else if (sum < target) {
                        k ++;
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
    
    public static void main(String[] args) {
    	_4Sum f = new _4Sum();
    	f.fourSum(new int[] {1,0,-1,0,-2,2}, 0);
    }
}
