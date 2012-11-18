package com.hisrv.leetcode;
public class FindMissingPositive {
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0) {
			return 1;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0) {
				A[i] = A.length + 1;
			}
		}
		for (int i = 0; i < A.length; i++) {
			int idx = Math.abs(A[i]);
			if (idx != 0 && idx <= A.length) {
				if (A[idx - 1] > 0) {
					A[idx - 1] = -A[idx - 1];
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				return i + 1;
			}
		}
		return A.length + 1;
	}
}
