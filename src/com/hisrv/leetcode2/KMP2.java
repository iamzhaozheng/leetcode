package com.hisrv.leetcode2;

public class KMP2 {
	public int strstr(String str, String pat) {
		char[] s = str.toCharArray();
		char[] p = pat.toCharArray();
		int m = p.length;
		int n = s.length;
		int j = -1;
		int[] pi = getPi(p);
		for (int i = 0; i < n; i ++) {
			while (s[i] != p[j + 1] && j >= 0) {
				j = pi[j];
			}
			if (s[i] == p[j + 1]) {
				j ++;
				if (j == m - 1) {
					return i - j;
				}
			}
		}
		return -1;
	}
	
	private int[] getPi(char[] p) {
		int m = p.length;
		int j = -1;
		int[] pi = new int[m];
		pi[0] = -1;
		for (int i = 1; i < m; i ++) {
			while (p[i] != p[j + 1] && j >= 0) {
				j = pi[j];
			}
			if (p[i] == p[j + 1]) {
				j ++;
			}
			pi[i] = j;
		}
		return pi;
	}
}
