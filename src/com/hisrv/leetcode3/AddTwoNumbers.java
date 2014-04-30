package com.hisrv.leetcode3;

import com.hisrv.leetcode.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v = (l1.val + l2.val) % 10;
        int a = (l1.val + l2.val) / 10;
        ListNode ret = new ListNode(v);
        ListNode p = ret, q;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                v = (l2.val + a) % 10;
                a = (l2.val + a) / 10;
                l2 = l2.next;
            } else if (l2 == null) {
                v = (l1.val + a) % 10;
                a = (l1.val + a) / 10;
                l1 = l1.next;
            } else {
                v = (l1.val + l2.val + a) % 10;
                a = (l1.val + l2.val + a) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            q = new ListNode(v);
            p.next = q;
            p = q;
        }
        if (a > 0) {
            q = new ListNode(a);
            p.next = q;
        }
        return ret;
    }
}
