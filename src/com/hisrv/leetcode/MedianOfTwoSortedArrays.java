package com.hisrv.leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || B == null) {
            return 0;
        }
        int la = A.length;
        int lb = B.length;
        if (la == 0 && lb == 0) {
            return 0;
        } else if (la == 0) {
            return lb % 2 != 0 ? B[lb / 2] : (B[lb / 2] + B[lb / 2 - 1]) / 2f;
        } else if (lb == 0) {
            return la % 2 != 0 ? A[la / 2] : (A[la / 2] + A[la / 2 - 1]) / 2f;
        }
        int sa = 0;
        int sb = 0;
        int ea = la - 1;
        int eb = lb - 1;
        int pa = 0, pb = 0;
        int m = (la + lb + 1) / 2;
        if (la > m) {
            sa = la - m;
            ea = m - 1;
        }
        if (lb > m) {
            sb = lb - m;
            eb = m - 1;
        }
        while (sa < ea || sb < eb) {
            pa = (sa + ea) / 2;
            pb = (sb + eb) / 2;
            if (A[pa] == B[pb]) {
                break;
            } else if (A[pa] > B[pb]) {
                ea = pa - 1;
                sb = pb + 1;
            } else {
                sa = pa + 1;
                eb = pb - 1;
            }
        }
        if ((la + lb) % 2 == 0) {
            if (A[pa] > B[pb]) {
                
            } else {
                
            }
        } else {
            return 0;
        }
        return 0;
    }
}
