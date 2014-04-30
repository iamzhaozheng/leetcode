package com.hisrv.leetcode3;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> words = new HashSet<Character> ();
        char[] chs = s.toCharArray();
        int j = 0;
        int max = 0;
        for (int i = 0; i < chs.length; i ++) {
            if (words.contains(chs[i])) {
                max = Math.max(max, i - j);
                while (chs[j] != chs[i]) {
                    words.remove(chs[j]);                    
                    j ++;
                }
                j ++;
            } else {
                words.add(chs[i]);
            }
        }
        max = Math.max(max, chs.length - j);
        return max;
    }
}
