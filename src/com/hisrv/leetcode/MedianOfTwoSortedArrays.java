package com.hisrv.leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
		int la = A.length;
		int lb = B.length;
		int l = la + lb;
		int k = (l + 1) / 2;
		FindKthNum f = new FindKthNum();
		int ret = f.findKthMin(A, B, k);
		if (l % 2 == 0) {
			return (ret + f.findKthMin(A, B, k + 1)) / 2f; 
		} else {
			return ret;
		}
	}
}
