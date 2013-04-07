package com.hisrv.leetcode2;

import com.hisrv.leetcode.ListNode;
import com.hisrv.leetcode.TreeNode;

public class ConvertSortedListToBinaryTree {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n ++;
        }
        return recur(head, n);
    }
    
    private TreeNode recur(ListNode head, int n) {
        if (n == 0) {
            return null;
        }
        ListNode p = head;
        for (int i = 0; i < n / 2; i ++) {
            p = p.next;
        }
        TreeNode node = new TreeNode(p.val);
        node.left = recur(head, n / 2);
        node.right = recur(p.next, n - n / 2 - 1);
        return node;
    }
}
