package com.hisrv.leetcode2;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret = 0;
        char[] str = s.toCharArray();
        int n = str.length;
        int start = -1;
        Stack<Integer> stack = new Stack<Integer> ();
        for (int i = 0; i < n; i ++) {
            if (str[i] == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    int peek = start;
                    if (!stack.isEmpty()) {
                        peek = stack.peek();
                    }
                    ret = Math.max(ret, i - peek);
                }
            }
        }
        return ret;
    }
}
