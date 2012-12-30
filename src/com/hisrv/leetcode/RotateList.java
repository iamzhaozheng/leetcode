package com.hisrv.leetcode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || n == 0) {
            return head;
        }
        ListNode p, q;
        p = head;
        for (int i = 0; i < n; i ++) {
            if (p.next != null) {
                p = p.next;
            } else {
                p = head;
            }
        }
        q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }
}
