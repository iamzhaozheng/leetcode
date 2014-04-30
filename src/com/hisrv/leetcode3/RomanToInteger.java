package com.hisrv.leetcode3;

public class RomanToInteger {
    private String s;
    public int romanToInt(String s) {
        this.s = s;
        String[] first = new String[] {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] second = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] third = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] fourth = new String[] {"", "M", "MM", "MMM"};
        int ret = 0;
        ret += findPos(fourth) * 1000;
        ret += findPos(third) * 100;
        ret += findPos(second) * 10;
        ret += findPos(first) * 1;
        return ret;
    }
    
    private int findPos(String[] arr) {
        for (int i = arr.length - 1; i > 0; i --) {
            if (s.startsWith(arr[i])) {
                s = s.substring(arr[i].length());
                return i;
            }
        }
        return 0;
    }
}
