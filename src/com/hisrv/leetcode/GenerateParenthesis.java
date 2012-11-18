package com.hisrv.leetcode;
import java.util.ArrayList;
import java.util.Stack;

public class GenerateParenthesis {
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> list = new ArrayList<String>();
		if (n <= 0) {
			return list;
		}
		Stack<String> s = new Stack<String>();
		s.push("(");
		int nl = 1, nr = 0;
		while (!s.empty()) {
			if (s.size() < 2 * n) {
				if (nl < n) {
					s.push("(");
					nl++;
				} else {
					s.push(")");
					nr++;
				}
			} else {
				list.add(getStackString(s));
				while (!s.empty()) {
					String prs = s.pop();
					if (prs.equals("(")) {
						nl--;
						if (nl > nr) {
							s.push(")");
							nr++;
							break;
						}
					} else {
						nr--;
					}
				}
			}
		}
		return list;
	}

	private String getStackString(Stack<String> s) {
		String r = "";
		for (int i = 0; i < s.size(); i++) {
			r += s.get(i);
		}
		return r;
	}
}
