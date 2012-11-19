package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {
	private class Sorted implements Comparable<Sorted> {
		public String s;
		public int idx;

		public Sorted(String s, int idx) {
			this.s = s;
			this.idx = idx;
		}

		public int compareTo(Sorted sorted) {
			return s.compareTo(sorted.s);
		}
	}

	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> list = new ArrayList<String>();
		Sorted[] sorteds = new Sorted[strs.length];
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			char[] cs = s.toCharArray();
			Arrays.sort(cs);
			sorteds[i] = new Sorted(new String(cs), i);
		}
		Arrays.sort(sorteds);
		boolean first = false;
		for (int i = 0; i < sorteds.length - 1; i++) {
			if (sorteds[i].s.equals(sorteds[i + 1].s)) {
				if (!first) {
					list.add(strs[sorteds[i].idx]);
					first = true;
				}
				list.add(strs[sorteds[i + 1].idx]);
			} else {
				first = false;
			}
		}
		return list;
	}
}
