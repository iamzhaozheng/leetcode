package com.hisrv.leetcode;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head.next, r = null;
        head = null;
        boolean single = true;
        while (q != null) {
            if (p.val == q.val) {
                single = false;
            } else {
                if (single) {
                    if (r == null) {
                        r = p;
                        head = r;
                    } else {
                        r.next = p;
                        r = r.next;
                    }
                }
                single = true;
                p = q;
            }
            q = q.next;
        }
        if (single) {
            if (r == null) {
                r = p;
                head = r;
            } else {
                r.next = p;
                r = r.next;
            }
        }
        if (r == null) {
            return r;
        }
        r.next = null;
        return head;
    }
}
