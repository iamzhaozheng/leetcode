package com.hisrv.leetcode;

import java.util.ArrayList;

public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String> ();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int j = getLine(words, i, L);
            String s = "";
            if(j == -1) {
                for (int k = i; k < n; k ++) {
                    s += words[k];
                    if (k != n - 1) {
                        s += " ";
                    }
                }
                for (int kk = s.length(); kk < L; kk ++) {
                    s += " ";
                }
                ret.add(s);
                break;
            } else {
                for (int k = i; k < j; k ++) {
                    s += words[k];
                    int m = getSpace(words, i, j, L);
                    int sn = Math.max(j - i - 1, 1);
                    int space = m / sn;
                    if ((k - i) < m % sn) {
                        space ++;
                    }
                    if (k != j - 1 || k == i) {
                        for (int kk = 0; kk < space; kk ++) {
                            s += " ";
                        }
                    }
                }
            }
            ret.add(s);
            i = j;
        }
        return ret;
    }
    
    private int getSpace(String[] words, int i, int j, int L) {
        int sum = 0;
        for (int k = i; k < j; k ++) {
            sum += words[k].length();
        }
        return L - sum;
    }
    
    private int getLine(String[] words, int start, int L) {
        int sum = 0;
        int i = start;
        while (sum < L && i < words.length) {
            if (i != start) {
                sum ++;   
            }
            sum += words[i ++].length();
        }
        if (sum > L) {
            i --;
        }
        if (i < words.length && i > start) {
            return i;
        } else {
            return -1;
        }
    }
}
