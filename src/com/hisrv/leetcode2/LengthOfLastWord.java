package com.hisrv.leetcode2;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] str = s.toCharArray();
        int e = lastValid(str);
        if (e < 0) {
            return 0;
        }
        int i = e - 1;
        while (i >= 0 && str[i] != ' ') {
            i --;
        }
        return e - i;
    }
    
    private int lastValid(char[] s) {
        int i = s.length - 1;
        while (i >= 0 && s[i] == ' ') {
            i --;
        }
        return i;
    }
}
