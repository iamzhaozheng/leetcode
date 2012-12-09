package com.hisrv.leetcode;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.<br>
 * public class ListNode {<br>
 *     int val;<br>
 *     ListNode next;<br>
 *     ListNode(int x) {<br>
 *         val = x;<br>
 *         next = null;<br>
 *     }<br>
 * }<br>
 */
public class MergeKSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode ret = null;
		int n = lists.size();
		if (n == 0) {
			return ret;
		}
		ListNode[] heap = new ListNode[n];
		int hl = 0;
		for (int i = 0; i < n; i++) {
			ListNode node = lists.get(i);
			heap[hl] = node;
			int j = hl;
			while ((j - 1) / 2 >= 0 && heap[j].val < heap[(j - 1) / 2].val) {
				swap(heap, j, (j - 1) / 2);
				j = (j - 1) / 2;
			}
			hl++;
		}
		ListNode p = ret;
		while (hl > 0) {
			if (ret == null) {
				ret = heap[0];
				p = ret;
			} else {
				p.next = heap[0];
				p = p.next;
			}
		}
		return ret;
	}

	private void swap(ListNode[] heap, int i, int j) {
		ListNode t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

}
