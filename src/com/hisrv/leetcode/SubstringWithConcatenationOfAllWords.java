package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        int n = L.length;
        if (n == 0) {
            return ret;
        }
        int m = L[0].length();
        int t = S.length();
        Map<String, Integer> count = new HashMap<String, Integer> ();
        Map<String, Integer> found = new HashMap<String, Integer> ();
        for (int i = 0; i < n; i ++) {
            if (count.get(L[i]) == null) count.put(L[i], 1);
            else count.put(L[i], count.get(L[i]) + 1);
        }
        loop: for (int i = 0; i <= t - m * n; i ++) {
            found.clear();
            for (int j = 0; j < n; j ++) {
                int start = i + j * m;
                String pattern = S.substring(start, start + m);
                if (count.get(pattern) == null) continue loop;
                else if (found.get(pattern) == null) found.put(pattern, 1);
                else if (found.get(pattern) == count.get(pattern)) continue loop;
                else found.put(pattern, found.get(pattern) + 1);
            }
            ret.add(i);
        }
        return ret;
    }
}
