package com.hisrv.leetcode3;

import java.util.ArrayList;

import com.hisrv.leetcode.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode ret;
        int n = lists.size();
        if (n == 0) {
            return null;
        }
        ret = lists.get(0);
        for (int i = 1; i < n; i ++) {
            ret = mergeTwoList(ret, lists.get(i));
        }
        return ret;
    }
    
    private ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        ListNode ret, p;
        ret = p = new ListNode(0);
        while (a != null || b != null) {
            if (a != null && (b == null || a.val < b.val)) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        return ret.next;
    }
}
