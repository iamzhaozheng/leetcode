package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null) {
            return l2;            
        } else if (l2 == null) {
            return l1;
        }
        ListNode ret = null, p = null;
        int addition = 0;
        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                sum = l2.val + addition;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + addition;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + addition;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (p == null) {
                p = new ListNode(sum % 10);
                ret = p;
            } else {
                p.next = new ListNode(sum % 10);
                p = p.next;
            }
            addition = sum / 10;
        }
        if (addition > 0) {
            p.next = new ListNode(addition);
            addition = 0;
        }
        if (ret == null) {
            ret = new ListNode(0);
        }
        return ret;
    }
}
