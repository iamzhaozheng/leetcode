package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {
    private int n, m, t;
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        t = S.length();
        n = L.length;
        if (n == 0) {
            return ret;
        }
        m = L[0].length();
        HashMap<String, Integer> dict = new HashMap<String, Integer> ();
        HashMap<String, Integer> now = new HashMap<String, Integer> ();
        for (int i = 0; i < n; i ++) {
            if (dict.containsKey(L[i])) dict.put(L[i], dict.get(L[i]) + 1);
            else dict.put(L[i], 1);
        }
        
        for (int i = 0; i < m; i ++) {
            now.clear();
            int s = i;
            int e = i;
            while (e + m <= t) {
                String word = S.substring(e, e + m);
                if (dict.containsKey(word)) {
                    if (now.containsKey(word)) {
                        if (now.get(word) < dict.get(word)) {
                            now.put(word, now.get(word) + 1);
                            e += m;
                        } else {
                            String sword = S.substring(s, s + m);
                            now.put(sword, now.get(sword) - 1);
                            s += m;
                        }
                    } else {
                        now.put(word, 1);
                        e += m;
                    }
                    if (s + m * n == e) {
                        ret.add(s);
                        String sword = S.substring(s, s + m);
                        now.put(sword, now.get(sword) - 1);
                        s += m;
                    }
                } else {
                    now.clear();
                    s = e + m;
                    e = s;
                }
            }
        }
        return ret;
    }
}
