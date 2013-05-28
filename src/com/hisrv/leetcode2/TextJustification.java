package com.hisrv.leetcode2;

import java.util.ArrayList;

public class TextJustification {
    private String[] mWords;
    private int mN, mL;
    
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String> ();
        mWords = words;
        mL = L;
        int start = 0;
        mN = words.length;
        while (start < mN) {
            int m = getLineNum(start);
            ret.add(justify(start, m));
            start += m;
        }
        return ret;
    }
    
    private String justify(int start, int m) {
        String s = "";
        if (start + m >= mN || m == 1) {
            for (int i = start; i < start + m; i ++) {
                s += mWords[i];
                if (i < start + m - 1) {
                    s += " ";
                } else {
                    s += generateSpace(mL - s.length());
                }
            }
        } else {
            int lenWithoutSpace = 0;
            for (int i = start; i < start + m; i ++) {
                lenWithoutSpace += mWords[i].length();
            }
            int space = mL - lenWithoutSpace;
            for (int i = start; i < start + m; i ++) {
                s += mWords[i];
                if (i < start + m - 1) {
                    int slot = space / (m - 1);
                    if (i - start < space % (m - 1)) {
                        slot ++;
                    }
                    s += generateSpace(slot);
                }
            }
        }
        return s;
    }
    
    private String generateSpace(int k) {
        String s = "";
        for (int i = 0; i < k; i ++) {
            s += " ";
        }
        return s;
    }
    
    private int getLineNum(int start) {
        int m = 0;
        int len = 0;
        while (start + m < mN) {
            if (m > 0) {
                len += 1;
            }
            len += mWords[start + m].length();
            if (len > mL) {
                break;
            }
            m ++;
        }
        return m;
    }
}
