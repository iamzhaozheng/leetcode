package com.hisrv.leetcode2;

import java.util.LinkedList;

import com.hisrv.leetcode.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode2 {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        LinkedList<LevelNode> queue = new LinkedList<LevelNode> ();
        queue.offer(new LevelNode(root, 0));
        while (!queue.isEmpty()) {
            LevelNode ln = queue.poll();
            if (ln.node.left != null) {
                queue.offer(new LevelNode(ln.node.left, ln.level + 1));
            }
            if (ln.node.right != null) {
                queue.offer(new LevelNode(ln.node.right, ln.level + 1));
            }
            if (queue.peek() != null && queue.peek().level == ln.level) {
                ln.node.next = queue.peek().node;
            }
        }
    }
    
    private class LevelNode {
        public TreeLinkNode node;
        public int level;
        public LevelNode(TreeLinkNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
