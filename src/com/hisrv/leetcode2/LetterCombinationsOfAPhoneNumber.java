package com.hisrv.leetcode2;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
    private static final String[] KEYS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String> ();
        int n = digits.length();
        if (n == 0) {
            ret.add("");
            return ret;
        } 
        ArrayList<String> list = letterCombinations(digits.substring(0, n - 1));
        int m = digits.charAt(n - 1) - '0';
        if (m < 2 || m > 9) {
            return list;
        }
        for (int i = 0; i < list.size(); i ++) {
            for (int j = 0; j < KEYS[m - 2].length(); j ++) {
                ret.add(list.get(i) + KEYS[m - 2].substring(j, j + 1));
            }
        }
        return ret;
    }
}
