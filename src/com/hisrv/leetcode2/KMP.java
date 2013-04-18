package com.hisrv.leetcode2;

public class KMP {
	public int strstr(String s, String p) {
		char[] str = s.toCharArray();
		char[] pat = p.toCharArray();
		int[] pi = computePi(pat);
		int n = str.length;
		int m = pat.length;
		int j = -1;
		for (int i = 0; i < n; i ++) {
			while (str[i] != pat[j + 1] && j >= 0) {
				j = pi[j];
			}
			if (str[i] == pat[j + 1]) {
				j ++;
				if (j == m - 1) {
					return i - j;
				}
			}
		}
		return -1;
	}
	
	private int[] computePi(char[] pat) {
		int m = pat.length;
		int[] pi = new int[m];
		pi[0] = -1;
		int j = -1;
		for (int i = 1; i < pat.length; i ++) {
			while (pat[i] != pat[j + 1] && j >= 0) {
				j = pi[j];
			}
			if (pat[i] == pat[j + 1]) {
				j ++;
			}
			pi[i] = j;
		}
		return pi;
	}
}
