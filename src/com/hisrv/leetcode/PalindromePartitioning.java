package com.hisrv.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {
	private boolean[][] flags;
	private ArrayList<ArrayList<String>> ret;
	private String base;
	private int n;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	base = s;
    	n = s.length();
    	char[] str = s.toCharArray();
    	flags = new boolean[n][n];
    	for (int i = 0; i < n; i ++) {
    		for (int j = 0; j < n - i; j ++) {
    			flags[j][j + i] = str[j] == str[j + i] && (i <= 1 || flags[j + 1][j + i - 1]) ? true : false; 
    		}
    	}
    	ret = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		make(list, 0);
    	return ret;
    }
    
    private void make(ArrayList<String> list, int start) {
    	if (start >= n) {
    		ret.add(new ArrayList<String> (list));
    		return;
    	}
    	for (int i = start; i < n; i ++) {
    		if (flags[start][i]) {
    			ArrayList<String> l = new ArrayList<String>(list);
    			l.add(base.substring(start, i + 1));
    			make(l, i + 1);
    		}
    	}
    }
}
