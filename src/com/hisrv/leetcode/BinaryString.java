package com.hisrv.leetcode;

public class BinaryString {
	public static String add(String a, String b) {
		String c = "";
		int carry = 0;
		if (a == null || b == null) {
			return null;
		}
		char ca, cb;
		for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
			if (a.length() - 1 - i >= 0) {
				ca = a.charAt(a.length() - 1 - i);
			} else {
				ca = '0';
			}
			if (b.length() - 1 - i >= 0) {
				cb = b.charAt(b.length() - 1 - i);
			} else {
				cb = '0';
			}
			if (ca != '0' && ca != '1' || cb != '0' && cb != '1') {
				return null;
			}
			int sum = ca - '0' + cb - '0' + carry;
			if (sum >= 2) {
				sum -= 2;
				carry = 1;
			} else {
				carry = 0;
			}
			c += (char)(sum + '0');
		}
		if (carry != 0) {
			c += (char)(carry + '0');
		}
		return rev(c);
	}

	private static String rev(String s) {
		String rst = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			rst += s.charAt(i);
		}
		return rst;
	}
}
