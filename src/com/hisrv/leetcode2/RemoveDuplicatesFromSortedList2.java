package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p;
        ListNode r = head;
        while (q.next != null && p.next != null) {
            if (p.val == p.next.val) {
                q = p.next;
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                if (p == head) {
                    head = q.next;
                    r = q.next;
                } else {
                    r.next = q.next;
                }
                p = q.next;
            } else {
                if (r != p) {
                    r = r.next;
                }
                p = p.next;
            }
        }
        return head;
    }
}
