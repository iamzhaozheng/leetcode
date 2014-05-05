package com.hisrv.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LetterCombinationsOfAPhoneNumber {
    private static final String[] KEY = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<Integer> strs = clean(digits);
        ArrayList<String> ret = new ArrayList<String> ();
        HashSet<String> hs = new HashSet<String> ();
        int n = strs.size();
        if (n <= 0) {
            ret.add("");
            return ret;
        }
        int[] mask = new int[n];
        Arrays.fill(mask, 0);
        do {
            String s = make(mask, strs);
            if (!hs.contains(s)) {
                hs.add(s);
                ret.add(s);
            }
        } while (plusOne(mask, strs));
        return ret;
    }
    
    private ArrayList<Integer> clean(String s) {
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c >= '2' && c <= '9') {
                ret.add(c - '2');
            }
        }
        return ret;
    }
    
    private boolean plusOne(int[] mask, ArrayList<Integer> strs) {
        int i = mask.length - 1;
        while (i >= 0) {
            if (mask[i] + 1 >= KEY[strs.get(i)].length()) {
                mask[i] = 0;
                i --;
            } else {
                mask[i] ++;
                return true;
            }
        }
        return false;
    }
    
    private String make(int[] mask, ArrayList<Integer> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mask.length; i ++) {
            sb.append(KEY[strs.get(i)].charAt(mask[i]));
        }
        return sb.toString();
    }
}
