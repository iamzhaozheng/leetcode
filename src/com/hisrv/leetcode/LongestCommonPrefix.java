package com.hisrv.leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int pos = -2;
		String s = strs[0];
		for (int i = 0; i < s.length(); i++) {
			char base = s.charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i) {
					pos = i;
					break;
				}
				if (strs[j].charAt(i) != base) {
					pos = i;
					break;
				}
			}
			if (pos != -2) {
				break;
			}
		}
		if (pos == -2) {
			return s;
		}
		if (pos >= 0) {
			return s.substring(0, pos);
		} else {
			return "";
		}
	}
}
