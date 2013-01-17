package com.hisrv.leetcode;

import java.util.ArrayList;

public class UniqueBinarySearchTrees2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return generateTrees(1, n);
    }
	
	private ArrayList<TreeNode> generateTrees(int start, int num) {
		ArrayList<TreeNode> ret = new ArrayList<TreeNode> ();
		if (num == 0) {
            ret.add(null);
			return ret;
		} else if (num == 1) {
			ret.add(new TreeNode(start));
			return ret;
		}
		for (int i = start; i < start + num; i ++) {
			ArrayList<TreeNode> left = generateTrees(start, i - start);
			ArrayList<TreeNode> right = generateTrees(i + 1, num - i + start - 1);
			for (int j = 0; j < Math.max(1, left.size()); j ++) {
				for (int k = 0; k < Math.max(1, right.size()); k ++) {
					TreeNode head = new TreeNode(i);
					head.left = left.size() == 0 ? null : left.get(j);
					head.right = right.size() == 0 ? null : right.get(k);
					ret.add(head);
				}
			}
			
		}
		return ret;
	}
}
