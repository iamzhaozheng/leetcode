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
        int d = (la + lb) / 2;
        int pa = d / 2;
        int pb = d / 2;
        while (pa >= la || pb >= la || A[pa] != B[pb]) {
        	if (pa <= sa || pb <= sb) {
        		break;
        	}
        	d = (pa - sa + pb - sb) / 2;
        	if (pa >= la) {
        		pa -= d;
        		sb = pb;
        		pb += d;
        	} else if (pb >= la) {
        		sa = pa;
        		pa += d;
        		pb -= d;
        	} else if (A[pa] > B[pb]) {
        		pa -= d;
        		sb = pb;
        		pb += d;
        	} else {
        		sa = pa;
        		pa += d;
        		pb -= d;
        	}
        }
        
        
        return 0;
    }
}
