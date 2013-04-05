package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder2 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		int n = dict.size();
		String[] arr = new String[n];
		dict.toArray(arr);
		HashMap<String, Integer> dist = new HashMap<String, Integer> ();
		LinkedList<String> queue = new LinkedList<String> ();
		HashMap<Integer, String> path = new HashMap<Integer, String>();
		dist.put(start, 0);
		queue.offer(start);
		dict.remove(start);
		int deep = -1;
		while (!queue.isEmpty()) {
			String curSz = queue.poll();
			if (deep != -1 && dist.get(curSz) > deep) {
				return ret;
			}
			path.put(dist.get(curSz), curSz);
			for (int i = 0; i < curSz.length(); i ++) {
				char[] cur = curSz.toCharArray();
				for (char c = 'a'; c <= 'z'; c ++) {
					if (c == cur[i]) {
						continue;
					}
					cur[i] = c;
					String s = new String(cur);
					if (dict.contains(s) && !dist.containsKey(s)) {
						if (s.equals(end)) {
							ret.add(makeArrayList(path, end));
							if (deep == -1) {
								deep = dist.get(curSz);
							}
						} else {
							queue.offer(s);
							dist.put(s, dist.get(curSz) + 1);
						}
					}
				}
			}
		}
		return ret;
	}

    private ArrayList<String> makeArrayList(HashMap<Integer, String> path, String end) {
    	ArrayList<String> ret = new ArrayList<String>();
    	for (int i = 0; i < path.size(); i ++) {
    		ret.add(new String(path.get(i)));
    	}
    	ret.add(end);
    	return ret;
    }
}
