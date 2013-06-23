package com.hisrv.leetcode2;

public class IntegerToRoman {
    private static final int[] ROMAN_INT = new int[] 
            {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] ROMAN_STRING = new String[]
            {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = ROMAN_INT.length - 1;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num - ROMAN_INT[i] >= 0) {
                num -= ROMAN_INT[i];
                sb.append(ROMAN_STRING[i]);
            } else {
                i --;
            }
        }
        return sb.toString();
    }
    
}
