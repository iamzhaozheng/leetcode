package com.hisrv.leetcode3;

import java.util.ArrayList;

public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String> ();
        if (n <= 0) {
            return ret;
        }
        char[] arr = new char[2 * n];
        solve(ret, arr, 0, n, n);
        return ret;
    }
    
    private void solve(ArrayList<String> ret, char[] arr, int i, int l, int r) {
        if (l == 0 && r == 0) {
            ret.add(new String(arr));
            return;
        }
        if (l > 0) {
            arr[i] = '(';
            solve(ret, arr, i + 1, l - 1, r);
        }
        if (r > l) {
            arr[i] = ')';
            solve(ret, arr, i + 1, l, r - 1);
        }
    }
}
