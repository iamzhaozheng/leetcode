package com.hisrv.leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i --;
        }
        if (i < 0) {
            return 0;
        }
        int num = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i --;
            num ++;
        }
        return num;
    }
}
