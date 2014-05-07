package com.hisrv.leetcode3;

import com.hisrv.leetcode.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        for (int i = 0; i < n; i ++) {
            if (p != null && p.next != null) {
                p = p.next;
            } else {
                return head.next;
            }
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        if (q.next != null) {
            q.next = q.next.next;
        }
        return head;
    }
}
