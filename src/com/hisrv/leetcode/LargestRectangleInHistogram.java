package com.hisrv.leetcode;

public class LargestRectangleInHistogram {
    private int[] getL(int[] height) {
        final int n = height.length;
        int[] l = new int[n];
        l[0] = 0;
        for (int i = 1; i < n; i ++) {
            int pos = i - 1;
            while (height[i] < height[pos] && pos > 0) {
                pos = l[pos] - 1;
                if (pos < 0) {
                    pos = 0;
                }
            }
            if (height[i] == height[pos]) {
                l[i] = l[pos];
            } else if (height[i] > height[pos]) {
                l[i] = pos + 1;
            } else {
                l[i] = pos;
            }
        }
        return l;
    }
    
    private int[] getR(int[] height) {
        final int n = height.length;
        int[] r = new int[n];
        r[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i --) {
            int pos = i + 1;
            while (height[i] < height[pos] && pos < n - 1) {
                pos = r[pos] + 1;
                if (pos > n - 1) {
                    pos = n - 1;
                }
            }
            if (height[i] == height[pos]) {
                r[i] = r[pos];
            } else if (height[i] > height[pos]) {
                r[i] = pos - 1;
            } else {
                r[i] = pos;
            }
        }
        return r;
    }
    
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        final int n = height.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return height[0];
        }
        int[] l = getL(height);
        int[] r = getR(height);
        int max = 0;
        for (int i = 0; i < n; i ++) {
            int m = height[i] * (r[i] - l[i] + 1);
            if (max < m) {
                max = m;
            }
        }
        return max;
    }
}
