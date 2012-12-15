package com.hisrv.leetcode;

public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode ret = null;
		ListNode p = null;
		while (l1 != null && l2 != null) {
			ListNode q = null;
			if (l1.val > l2.val) {
				q = l2;
				l2 = l2.next;
			} else {
				q = l1;
				l1 = l1.next;
			}
			if (ret == null) {
				ret = q;
				p = q;
			} else {
				p.next = q;
				p = p.next;
			}
		}
		p.next = l1 == null ? l2 : l1;
		return ret;
	}
}
