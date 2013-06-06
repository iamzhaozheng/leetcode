package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams {
    private class Index implements Comparable<Index> {
        public int id;
        public String s;
        
        public Index(int id, String s) {
            this.id = id;
            this.s = s;
        }
        
        public int compareTo(Index idx) {
            return this.s.compareTo(idx.s);
        }
    }

    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String> ();
        int n = strs.length;
        Index[] indices = new Index[n];
        for (int i = 0; i < n; i ++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            indices[i] = new Index(i, new String(chs));
        }
        Arrays.sort(indices);
        boolean ana = false;
        for (int i = 0; i < n - 1; i ++) {
            if (indices[i].s.equals(indices[i + 1].s)) {
                if (!ana) {
                    ret.add(strs[indices[i].id]);
                    ana = true;
                }
                ret.add(strs[indices[i + 1].id]);
            } else {
                ana = false;
            }
        }
        return ret;
    }
}
