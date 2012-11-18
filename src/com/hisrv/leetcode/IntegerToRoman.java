package com.hisrv.leetcode;
public class IntegerToRoman {

	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String[] thousands = { "M", "MM", "MMM" };
		String[] hundreds = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC",
				"CM" };
		String[] tens = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX",
				"XC" };
		String[] ones = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
				"IX" };
		String rst = "";
		int r = num / 1000;
		int t = num % 1000;
		if (r > 0) {
			rst += thousands[r - 1];
		}
		r = t / 100;
		t = t % 100;
		if (r > 0) {
			rst += hundreds[r - 1];
		}
		r = t / 10;
		t = t % 10;
		if (r > 0) {
			rst += tens[r - 1];
		}
		if (t > 0) {
			rst += ones[t - 1];
		}
		return rst;
	}
}
