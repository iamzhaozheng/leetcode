package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = head;
        if (p == null || p.next == null) {
            return head;
        }
        ListNode q = p, r = q.next, s = r.next;
        while (r != null) {
            r.next = q;
            p.next = r;
            q.next = s;
            if (head == p) {
                head = r;
            }
            p = q;
            q = p.next;
            if (q == null || q.next == null) {
                break;
            } 
            r = q.next;
            s = r.next;
        }
        return head;
    }
}
