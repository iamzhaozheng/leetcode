package com.hisrv.leetcode;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p, q, r, s;
        int k = n - m;
        if (m == 1) {
            q = head;
            s = q.next;
            for (int i = 0; i < k; i ++) {
                r = s.next;
                s.next = q;
                q = s;
                s = r;
            }
            head.next = s;
            head = q;
            return head;
        }
        p = head;
        for (int i = 2; i < m; i ++) {
            p = p.next;
        }
        q = p;
        s = q.next;
        r = s.next;
        for (int i = 0; i < k; i ++) {
            q = s;
            s = r;
            r = r.next;
            s.next = q;
        }
        p.next.next = r;
        p.next = s;
        return head;
    }
}
