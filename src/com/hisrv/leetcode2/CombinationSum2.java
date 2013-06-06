package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret = new ArrayList<ArrayList<Integer>> ();
        if (num.length != 0) {
            Arrays.sort(num);
            rec(num, 0, target, new ArrayList<Integer> ());
        }
        return ret;
    }
    
    private void rec(int[] num, int start, int target, ArrayList<Integer> buf) {
        if (target == 0) {
            add(buf);
            return;
        }
        if (start >= num.length) {
            return;
        }
        if (num[start] <= target) {
            buf.add(num[start]);
            rec(num, start + 1, target - num[start], buf);
            buf.remove(buf.size() - 1);
        }
        rec(num, start + 1, target, buf);
    }
    
    private void add(ArrayList<Integer> list) {
        if (!ret.contains(list)) {
            ArrayList<Integer> copy = new ArrayList<Integer> (list);
            ret.add(copy);
        }
    }
}
