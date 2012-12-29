package com.hisrv.leetcode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return null;
        }
        ListNode p, q;
        q = head;
        p = head;
        for (int i = 0; i < n; i ++) {
            q = q.next;
        }
        if (q == null) {
            head = p.next;
            return head;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}
