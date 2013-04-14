package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = head;
        if (p == null) {
            return null;
        }
        while (p.next != null && p.next.val < x && p.val < x) {
            p = p.next;
        }
        ListNode q;
        if (p == head) {
            q = p;
        } else {
            q = p.next;
        }
        if (q == null) {
            return head;
        }
        while (q.next != null) {
            if (q.next.val < x) {
                ListNode r = q.next;
                q.next = r.next;
                if (p.val >= x) {
                    r.next = p;
                    head = r;
                } else {
                    r.next = p.next;
                    p.next = r;
                }
                p = r;
            } else {
                q = q.next;
            }
        }
        return head;
    }
}
