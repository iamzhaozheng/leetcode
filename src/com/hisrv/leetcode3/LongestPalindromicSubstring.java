package com.hisrv.leetcode3;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] strs = s.toCharArray();
        String maxPalindrome = "";
        for (int i = 0; i < strs.length; i ++) {
            String sz = findLongestOddPalindrome(strs, i);
            if (sz.length() > maxPalindrome.length()) {
                maxPalindrome = sz;
            }
            sz = findLongestEvenPalindrome(strs, i) ;
            if (sz.length() > maxPalindrome.length()) {
                maxPalindrome = sz;
            }
        }
        return maxPalindrome;
    }
    
    private String findLongestOddPalindrome(char[] strs, int center) {
        int offsite = 1;
        while (center - offsite >= 0 && center + offsite < strs.length) {
            if (strs[center - offsite] != strs[center + offsite]) {
                break;
            }
            offsite ++;
        }
        offsite --;
        return new String(strs, center - offsite, offsite * 2 + 1);
    }
    
    private String findLongestEvenPalindrome(char[] strs, int center) {
        int offsite = 1;
        while (center - offsite + 1 >= 0 && center + offsite < strs.length) {
            if (strs[center - offsite + 1] != strs[center + offsite]) {
                break;
            }
            offsite ++;
        }
        offsite --;
        return new String(strs, center - offsite + 1, offsite * 2);
    }
    
    public static void main(String[] args) {
    	LongestPalindromicSubstring f = new LongestPalindromicSubstring();
    	System.out.print(f.longestPalindrome("bb"));
    }
}
