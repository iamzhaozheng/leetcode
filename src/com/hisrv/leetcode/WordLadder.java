package com.hisrv.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = dict.size();
		String[] arr = new String[n];
		dict.toArray(arr);
		ListNode[] graph = new ListNode[n];
		int s = 0, e = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].equals(start)) {
				s = i;
			} else if (arr[i].equals(end)) {
				e = i;
			}
			for (int j = i + 1; j < n; j++) {
				if (canTrans(arr[i], arr[j])) {
					ListNode node = new ListNode(j);
					node.next = graph[i];
					graph[i] = node;
					node = new ListNode(i);
					node.next = graph[j];
					graph[j] = node;
				}
			}
		}
		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		dist[s] = 0;
		LinkedList<Integer> queue = new LinkedList<Integer> ();
		queue.push(s);
		while (!queue.isEmpty()) {
			int i = queue.poll();
			ListNode q = graph[i];
			while (q != null) {
				if (dist[q.val] == -1) {
					dist[q.val] = dist[i] + 1;
					if (q.val == e) {
						return dist[e] + 1;
					}
					queue.push(q.val);
				}
				q = q.next;
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
		return diffNum == 1 ? true : false;
	}

}
