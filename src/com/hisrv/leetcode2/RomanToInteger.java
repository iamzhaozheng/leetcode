package com.hisrv.leetcode2;

import java.util.HashMap;

public class RomanToInteger {
    private static final HashMap<String, Integer> mBasicRoman = new HashMap<String, Integer> () { {
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};
    
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = 0;
        while (s.length() > 0) {
            if (s.length() >= 2 && mBasicRoman.containsKey(s.substring(0, 2))) {
                sum += mBasicRoman.get(s.substring(0, 2));
                s = s.substring(2);
            } else {
                sum += mBasicRoman.get(s.substring(0, 1));
                s = s.substring(1);
            }
        }
        return sum;
    }
}
