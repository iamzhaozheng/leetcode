package com.hisrv.leetcode;

public class FindKthNum {
	public int findKthMin(int[] A, int[] B, int k) {
		if (k <= 0) {
			return -1;
		}
		int la = A.length;
		int lb = B.length;
		if (k > la + lb) {
			return -1;
		}
		if (la == 0) {
			return B[k - 1];
		} else if (lb == 0) {
			return A[k - 1];
		}
		int sa = 0;
		int sb = 0;
		while (true) {
			int pa = la * (k - 1) / (la + lb);
			int pb = k - 1 - pa;
			
			int a0 = pa == 0 ? Integer.MIN_VALUE : A[sa + pa - 1];
			int a1 = pa == la ? Integer.MAX_VALUE : A[sa + pa];
			int b0 = pb == 0 ? Integer.MIN_VALUE : B[sb + pb - 1];
			int b1 = pb == lb ? Integer.MAX_VALUE : B[sb + pb];
			
			if (a1 >= b0 && a1 <= b1) {
				return a1;
			}
			if (b1 >= a0 && b1 <= a1) {
				return b1;
			}
			if (a1 > b1) {
				sb += pb + 1; 
				lb -= pb + 1;
				la = pa;
				k -= pb + 1;
			} else {
				sa += pa + 1;
				la -= pa + 1;
				lb = pb;
				k -= pa + 1;
			}
		}
	}
}
