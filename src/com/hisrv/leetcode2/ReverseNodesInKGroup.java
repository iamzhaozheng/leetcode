package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (k <= 1) {
            return head;
        }
        ListNode p = head;
        ListNode r = head;
        ListNode prevEnd = null, nextStart = null;
        while (p != null) {
            for (int i = 0; i < k - 1 && p != null; i ++) {
                p = p.next;
            }
            if (p == null) {
                break;
            }
            nextStart = p.next;
            p.next = null;
            TwoNodes t = reverse(r);
            if (prevEnd == null) {
                head = t.start;
            } else {
                prevEnd.next = t.start;
            }
            t.end.next = nextStart;
            r = p = nextStart;
            prevEnd = t.end;
        }
        return head;
    }
    
    private TwoNodes reverse(ListNode node) {
        TwoNodes t = new TwoNodes();
        ListNode p = node, q, r;
        t.start = t.end = p;
        if (p.next == null) {
            return t;
        } 
        q = p.next;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        node.next = null;
        t.end = node;
        t.start = p;
        return t;
    }
    
    private class TwoNodes {
        public ListNode start;
        public ListNode end;
    }
}
