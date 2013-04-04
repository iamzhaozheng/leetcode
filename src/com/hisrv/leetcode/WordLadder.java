package com.hisrv.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		int n = dict.size();
		String[] arr = new String[n];
		dict.toArray(arr);
		HashMap<String, Integer> dist = new HashMap<String, Integer> ();
		LinkedList<String> queue = new LinkedList<String> ();
		dist.put(start, 0);
		queue.offer(start);
		dict.remove(start);
		while (!queue.isEmpty()) {
			String curSz = queue.poll();
			for (int i = 0; i < curSz.length(); i ++) {
				char[] cur = curSz.toCharArray();
				for (char c = 'a'; c <= 'z'; c ++) {
					if (c == cur[i]) {
						continue;
					}
					cur[i] = c;
					String s = new String(cur);
					if (dict.contains(s) && !dist.containsKey(s)) {
						queue.offer(s);
						dist.put(s, dist.get(curSz) + 1);
						if (s.equals(end)) {
							return dist.get(s) + 1;
						}
					}
				}
			}
		}
		return 0;
	}

}
