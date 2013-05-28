package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode rear = head;
        while (rear.next != null) {
            rear = rear.next;
            len ++;
        }
        n = n % len;
        if (n == 0) {
            return head;
        }
        ListNode p = head;
        for (int i = 0; i < len - n - 1; i ++) {
            p = p.next;
        }
        rear.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}
