package com.hisrv.leetcode2;

import java.util.ArrayList;

import com.hisrv.leetcode.ListNode;

public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = lists.size();
        ListNode[] heap = new ListNode[n];
        ListNode head = null;
        int m = 0;
        for (int i = 0; i < n; i ++) {
            ListNode node = lists.get(i);
            if (node != null) {
                heap[m ++] = node;
                int t = m - 1;
                while (t > 0 && heap[t].val < heap[(t - 1) / 2].val) {
                    swap(heap, t, (t - 1) / 2);
                    t = (t - 1) / 2;
                }
            }
        }
        ListNode p = head;
        while (m > 0) {
            if (head == null) {
                head = heap[0];
                p = heap[0];
            } else {
                p.next = heap[0];
                p = p.next;
            }
            if (heap[0].next == null) {
                if (m > 1) {
                    heap[0] = heap[m - 1];
                }
                m --;
            } else {
                heap[0] = heap[0].next;
            }
            adjustHeap(heap, m);
        }
        return head;
    }
    
    private void adjustHeap(ListNode[] heap, int m) {
        int n = 0;
        while (n * 2 + 1 < m && heap[n].val > heap[n * 2 + 1].val 
                || n * 2 + 2 < m && heap[n].val > heap[n * 2 + 2].val) {
            if (n * 2 + 2 >= m || heap[n * 2 + 1].val < heap[n * 2 + 2].val) {
                swap(heap, n, n * 2 + 1);
                n = n * 2 + 1;
            } else {
                swap(heap, n, n * 2 + 2);
                n = n * 2 + 2;
            }
        }
    }
    
    private void swap(ListNode[] heap, int a, int b) {
        ListNode p = heap[a];
        heap[a] = heap[b];
        heap[b] = p;
    }
}
