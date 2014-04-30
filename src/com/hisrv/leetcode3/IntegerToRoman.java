package com.hisrv.leetcode3;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] first = new String[] {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] second = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] third = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] fourth = new String[] {"", "M", "MM", "MMM"};
        String ret = "";
        ret += fourth[num / 1000];
        ret += third[(num % 1000) / 100];
        ret += second[(num % 100) / 10];
        ret += first[num % 10];
        return ret;
    }
}
