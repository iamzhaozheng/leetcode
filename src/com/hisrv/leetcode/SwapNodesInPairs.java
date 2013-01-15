package com.hisrv.leetcode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return null;
        }
        ListNode p, q;
        p = head;
        if (p.next != null) {
            head = p.next;
            q = head.next;
            head.next = p;
            p.next = q;
        } else {
            return head;
        }
        while (p.next != null && p.next.next != null) {
            q = p.next;
            p.next = p.next.next;
            q.next = p.next.next;
            p.next.next = q;
            p = p.next.next;
        }
        return head;
    }
}
