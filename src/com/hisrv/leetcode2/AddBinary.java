package com.hisrv.leetcode2;

public class AddBinary {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String ra = rev(a);
        String rb = rev(b);
        String rc = "";
        int addition = 0;
        for (int i = 0; i < Math.max(ra.length(), rb.length()); i ++) {
            int da, db;
            da = 0;
            db = 0;
            if (i < ra.length()) {
                da = ra.charAt(i) - '0';
            }
            if (i < rb.length()) {
                db = rb.charAt(i) - '0';
            }
            int v = da + db + addition;
            if (v > 1) {
                v -= 2;
                addition = 1;
            } else {
                addition = 0;
            }
            rc += String.valueOf(v);
        }
        if (addition > 0) {
            rc += "1";
        }
        return rev(rc);
    }
    
    private String rev(String a) {
        String r = "";
        for (int i = a.length() - 1; i >= 0; i --) {
            r += a.charAt(i);
        }
        return r;
    }
}
