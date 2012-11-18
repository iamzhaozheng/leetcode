package com.hisrv.leetcode;
public class CountAndSay {
	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String s = "1";
		for (int i = 1; i < n; i++) {
			String r = "";
			int k = 1;
			for (int j = 0; j < s.length() - 1; j++) {
				if (s.charAt(j) == s.charAt(j + 1)) {
					k++;
				} else {
					r += String.valueOf(k) + s.charAt(j);
					k = 1;
				}
			}
			r += String.valueOf(k) + s.charAt(s.length() - 1);
			s = r;
		}
		return s;
	}
}
