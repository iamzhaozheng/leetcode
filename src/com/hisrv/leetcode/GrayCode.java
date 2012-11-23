package com.hisrv.leetcode;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		int base = 1;
		for (int i = 0; i < n; i++) {
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add(base + list.get(j));
			}
			base *= 2;
		}
		return list;
	}
}
