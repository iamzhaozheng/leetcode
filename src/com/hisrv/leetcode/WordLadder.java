package com.hisrv.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = dict.size();
		boolean[][] flags = new boolean[n][n];
		String[] arr = new String[n];
		dict.toArray(arr);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (canTrans(arr[i], arr[j])) {
					flags[i][j] = true;
				} else {
					flags[i][j] = false;
				}
			}
		}
		int s = 0, e = 0;
		for (int i = 0; i < arr.length; i ++) {
			if (arr[i].equals(start)) {
				s = i;
			} else if (arr[i].equals(end)) {
				e = i;
			}
		}
		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		dist[s] = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);
		while (!stack.isEmpty()) {
			int p = stack.pop();
			for (int i = 0; i < n; i++) {
				if (p != i && flags[p][i]) {
					if (dist[i] == -1) {
						stack.push(i);
						dist[i] = dist[p] + 1;
					} else {
						dist[i] = Math.min(dist[i], dist[p] + 1);
					}
				}
			}
		}
		return dist[e] + 1;
	}

	private boolean canTrans(String a, String b) {
		int diffNum = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diffNum++;
			}
		}
		return diffNum <= 1 ? true : false;
	}

}
