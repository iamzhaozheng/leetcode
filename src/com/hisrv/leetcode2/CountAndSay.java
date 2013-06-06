package com.hisrv.leetcode2;

public class CountAndSay {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String s = "1";
        for (int i = 1; i < n; i ++) {
            s = read(s);
        }
        return s;
    }
    
    private String read(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        int n = chs.length;
        char rem = chs[0];
        int sum = 1;
        for (int i = 1; i < n; i ++) {
            if (chs[i] == rem) {
                sum ++;
            } else {
                sb.append(sum);
                sb.append(rem);
                rem = chs[i];
                sum = 1;
            }
        }
        sb.append(sum);
        sb.append(rem);
        return sb.toString();
    }
}
