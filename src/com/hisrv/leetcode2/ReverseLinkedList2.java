package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == n) {
            return head;
        }
        ListNode p = head;
        ListNode q = p;
        for (int i = 1; i < m - 1; i ++) {
            p = p.next;
        }
        if (m > 1) {
            q = p.next;
        }
        ListNode r = q.next;
        ListNode s = r.next;
        for (int i = m; i < n; i ++) {
            r.next = q;
            q = r;
            r = s;
            if (s != null) {
                s = s.next;
            }
        }
        if (m == 1) {
            p.next = r;
            head = q;
        } else {
            p.next.next = r;
            p.next = q;
        }
        return head;
    }
}
