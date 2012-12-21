package com.hisrv.leetcode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head.next;
        while (q != null) {
            if (p.val != q.val) {
                p.next = q;
                p = q;
            }
            q = q.next;
        }
        p.next = null;
        return head;
    }
}
