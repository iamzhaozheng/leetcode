package com.hisrv.leetcode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (k <= 1) {
            return head;
        }
        ListNode p, q, r, s, e;
        s = e = head;
        for (int i = 0; i < k; i ++) {
            if (e != null) {
                e = e.next;
            } else {
                return head;
            }
        }
        boolean end = false;
        while (!end) {
            if (s == head) {
                p = s;
            } else {
                p = s.next;
            }
            q = p.next;
            r = q;
            for (int i = 1; i < k; i ++) {
                r = r.next;
                q.next = p;
                p = q;
                q = r;
                if (e != null) {
                    e = e.next;
                } else {
                    end = true;
                }
            }
            if (s == head) {
                head = p;
                s.next = q;
            } else {
                s.next.next = q;
                r = s.next;
                s.next = p;
                s = r;
            }
            if (e != null) {
                e = e.next;
            } else {
                end = true;
            }
        }
        return head;
    }
}
