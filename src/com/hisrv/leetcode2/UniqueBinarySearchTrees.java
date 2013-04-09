package com.hisrv.leetcode2;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 1) {
            return 1;
        }
        int s = 0;
        for (int i = 0; i < n; i ++) {
            s += numTrees(i) * numTrees(n - i - 1);
        }
        return s;
    }
}
