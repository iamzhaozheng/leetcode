package com.hisrv.leetcode;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += numTrees(i) * numTrees(n - i - 1);
        }
        return sum;
    }
}
