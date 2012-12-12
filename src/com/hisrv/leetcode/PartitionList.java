package com.hisrv.leetcode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p, q, r, s, ret;
        q = r = s = ret = null;
        p = head;
        while (p != null) {
            if (p.val < x) {
                if (ret == null) {
                    ret = p;
                    p = p.next;
                    q = ret;
                } else {
                    q.next = p;
                    p = p.next;
                    q = q.next;
                }
                q.next = null;
            } else {
                if (r == null) {
                    r = p;
                    p = p.next;
                    s = r;
                } else {
                    s.next = p;
                    p = p.next;
                    s = s.next;
                }
                s.next = null;
            }
        }
        if (ret == null) {
            return r;
        } else {
            q.next = r;
            return ret;
        }
    }
}
