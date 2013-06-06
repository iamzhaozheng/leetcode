package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        Arrays.sort(num);
        ret.add(getList(num));
        while (nextPermutation(num)) {
            ret.add(getList(num));
        }
        return ret;
    }
    
    private boolean nextPermutation(int[] num) {
        int n = num.length;
        int i = n - 2;
        while (i >= 0 && num[i] >= num[i + 1]) {
            i --;
        }
        if (i < 0) {
            reverse(num, 0, n - 1);
            return false;
        }
        int j = n - 1;
        while (num[j] <= num[i]) {
            j --;
        }
        swap(num, i, j);
        reverse(num, i + 1, n - 1);
        return true;
    }
    
    private void reverse(int[] num, int s, int e) {
        for (int i = s; i < (e + s + 1) / 2; i ++) {
            swap(num, i, e - i + s);
        }
    }
    
    private void swap(int[] num, int a, int b) {
        if (num[a] != num[b]) {
            num[a] ^= num[b];
            num[b] ^= num[a];
            num[a] ^= num[b];
        }
    }
    
    private ArrayList<Integer> getList(int[] num) {
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        for (int i = 0; i < num.length; i ++) {
            ret.add(num[i]);
        }
        return ret;
    }
}
