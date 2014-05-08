package com.hisrv.leetcode3;

import com.hisrv.leetcode.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode st = new ListNode(0);
        st.next = head;
        ListNode p = st, q;
        while (p.next != null && p.next.next != null) {
            q = p.next;
            p.next = q.next;
            q.next = q.next.next;
            p.next.next = q;
            p = p.next.next;
        }
        return st.next;
    }
}
