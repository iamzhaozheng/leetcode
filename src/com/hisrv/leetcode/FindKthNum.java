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
		k--;
		int sa = 0;
		int sb = 0;
		int ea = Math.min(k, la);
		int eb = Math.min(k, lb);
		int pa, pb;
		if (ea >= eb) {
			pb = eb / 2;
			pa = k - pb;
			while (pb != eb && pa != ea && A[pa] != B[pb] && sb < eb) {
				if (A[pa] > B[pb]) {
					int mv = (eb - pb + 1) / 2;
					sb = pb;
					pb = pb + mv;
					ea = pa;
					pa = pa - mv;
				} else {
					int mv = (pb - sb + 1) / 2;
					eb = pb;
					pb = pb - mv;
					sa = pa;
					pa = pa + mv;
				}
			}
		} else {
			pa = ea / 2;
			pb = k - pa;
			while (pa != ea && pb != eb && A[pa] != B[pb] && sa < ea) {
				if (A[pa] > B[pb]) {
					int mv = (ea - pa + 1) / 2;
					sa = pa;
					pa = pa + mv;
					eb = pb;
					pb = pb - mv;
				} else {
					int mv = (pa - sa + 1) / 2;
					ea = pa;
					pa = pa - mv;
					sb = pb;
					pb = pb + mv;
				}
			}
		}
		if (pa == la && pb == lb) {
			return Math.max(B[pb - 1], A[pa - 1]);
		} else if (pa == la) {
			return Math.max(B[pb], A[pa - 1]);
		} else if (pb == lb) {
			return Math.max(A[pa], B[pb - 1]);
		} else {
			return Math.min(A[pa], B[pb]);
		}
	}
}
