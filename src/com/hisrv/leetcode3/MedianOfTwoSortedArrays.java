package com.hisrv.leetcode3;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int na = A.length;
		int nb = B.length;
		if ((na + nb) % 2 == 1) {
			return findKthMin(A, 0, na, B, 0, nb, (na + nb) / 2);
		} else {
			return (findKthMin(A, 0, na, B, 0, nb, (na + nb) / 2) + findKthMin(
					A, 0, na, B, 0, nb, (na + nb) / 2 - 1)) / 2.0;
		}
	}

	public int findKthMin(int[] a, int sa, int na, int[] b, int sb, int nb,
			int k) {
		if (na < nb) { // make sure a is the longer array.
			return findKthMin(b, sb, nb, a, sa, na, k);
		}
		if (nb == 0) {
			return a[k];
		}
		if (k == 0) {
			return Math.min(a[sa], b[sb]);
		}
		int n = k / 2;
		int pb = Math.min(k - n - 1, nb - 1);
		int pa = k - pb - 1;
		if (a[sa + pa] == b[sb + pb]) {
			return a[sa + pa];
		} else if (a[sa + pa] < b[sb + pb]) {
			return findKthMin(a, sa + pa + 1, na - pa - 1, b, sb, pb + 1, k
					- pa - 1);
		} else {
			return findKthMin(a, sa, pa + 1, b, sb + pb + 1, nb - pb - 1, k
					- pb - 1);
		}
	}
}
