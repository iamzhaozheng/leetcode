package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = head;
        ListNode q = head;
        if (p == null) {
            return null;
        }
        int i = 0;
        while (p != null) {
            p = p.next;
            if (i > n) {
                q = q.next;
            }
            i ++;
        }
        if (i == n) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
        return head;
    }
}
