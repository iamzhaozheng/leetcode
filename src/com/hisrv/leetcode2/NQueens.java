package com.hisrv.leetcode2;

import java.util.ArrayList;

public class NQueens {
    private int mN;
    private ArrayList<String[]> ret;
    private int mMask;
    
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ret = new ArrayList<String[]> ();
        mN = n;
        mMask = (1 << n) - 1;
        ArrayList<Integer> buf = new ArrayList<Integer> ();
        rec(0, 0, 0, 0, buf);
        return ret;
    }
    
    private void rec(int level, int left, int down ,int right, ArrayList<Integer> buf) {
        if (level == mN) {
            out(buf);
            return;
        }
        int bitmap = ~(left | down | right) & mMask;
        while (bitmap != 0) {
            int now = -bitmap & bitmap;
            buf.add(now);
            rec(level + 1, (left | now) << 1, down | now, (right | now) >> 1, buf);
            buf.remove(buf.size() - 1);
            bitmap ^= now;
        }
    }
    
    private void out(ArrayList<Integer> buf) {
        String[] ss = new String[mN];
        for (int i = 0; i < buf.size(); i ++) {
            int now = buf.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < mN; j ++) {
                sb.append((now & 1) == 0 ? "." : "Q");
                now = now >> 1;
            }
            ss[i] = sb.toString();
        }
        ret.add(ss);
    }
}
