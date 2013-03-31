package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        if (num.length == 0) {
            return ret;
        }
        Arrays.sort(num);
        do {
            ret.add(getList(num));
        } while (nextPermutation(num));
        return ret;
    }
    
    private ArrayList<Integer> getList(int[] num) {
        ArrayList<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < num.length; i ++) {
            list.add(num[i]);
        }
        return list;
    }

    public boolean nextPermutation(int[] num) {
        int n = num.length;
        if (n == 0) {
            return false;
        }
        for (int i = n - 1; i > 0; i --) {
            if (num[i - 1] < num[i]) {
                for (int j = n - 1; j >= i; j --) {
                    if (num[i - 1] < num[j]) {
                        swap(num, i - 1, j);
                        rev(num, i, n - 1);
                        return true;
                    }
                }
            }
        }
        rev(num, 0, n - 1);
        return false;
    }
    
    private void swap(int[] num, int i, int j) {
        if (num[i] != num[j]) {
            num[i] ^= num[j];
            num[j] ^= num[i];
            num[i] ^= num[j];
        }
    }
    
    private void rev(int[] num, int i, int j) {
        int n = (j - i + 1) / 2;
        for (int k = 0; k < n; k ++) {
            swap(num, i + k, j - k);
        }
    }

}
