package com.hisrv.leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> hs = new HashSet<Integer> ();
        for (int i = 0; i < num.length; i ++) {
            hs.add(num[i]);
        }
        int len = 0;
        for (int i = 0; i < num.length; i ++) {
            int base = num[i];
            int pl = base;
            while (hs.contains(pl)) {
                hs.remove(pl);
                pl ++;
            }
            int ps = base - 1;
            while (hs.contains(ps)) {
                hs.remove(ps);
                ps --;
            }
            len = Math.max(len, pl - ps - 1);
        }
        return len;
    }
}
