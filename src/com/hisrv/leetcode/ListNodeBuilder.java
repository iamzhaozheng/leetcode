package com.hisrv.leetcode;

public class ListNodeBuilder {
	
	public static ListNode create(int[] s) {
		ListNode head = new ListNode(s[0]);
		ListNode q = head;
		for (int i = 1; i < s.length; i ++) {
			ListNode p = new ListNode(s[i]);
			q.next = p;
			q = q.next;
		}
		q.next = null;
		return head;
	}
	
	public static void out(ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val);
			System.out.print(" ");
			p = p.next;
		}
	}
}
