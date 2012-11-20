package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class LetterCombinationOfAPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> list = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			list.add("");
			return list;
		}
		ArrayList<String> map = getMap();
		int[] idx = new int[digits.length()];
		for (int i = 0; i < digits.length(); i++) {
			idx[i] = digits.charAt(i) - '0';
		}
		Stack<Integer> stack = new Stack<Integer>();
		boolean finish = false;
		int i = 0;
		while (!finish) {
			if (stack.size() < idx.length) {
				stack.push(i);
				i = 0;
			} else {
				String r = "";
				for (int j = 0; j < stack.size(); j++) {
					int p = stack.get(j);
					r += map.get(idx[j]).substring(p, p + 1);
				}
				list.add(r);
				i = stack.pop() + 1;
				while (!stack.isEmpty()
						&& i >= map.get(idx[stack.size()]).length()) {
					i = stack.pop() + 1;
				}
				if (i >= map.get(idx[stack.size()]).length()) {
					finish = true;
				}
			}
		}
		return list;
	}

	private ArrayList<String> getMap() {
		ArrayList<String> keys = new ArrayList<String>();
		keys.add("");
		keys.add("");
		keys.add("abc");
		keys.add("def");
		keys.add("ghi");
		keys.add("jkl");
		keys.add("mno");
		keys.add("pqrs");
		keys.add("tuv");
		keys.add("wxyz");
		return keys;
	}
}
