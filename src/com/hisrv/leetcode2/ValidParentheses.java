package com.hisrv.leetcode2;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] str = s.toCharArray();
        int n = str.length;
        Stack<Character> stack = new Stack<Character> ();
        for (int i = 0; i < n; i ++) {
            if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
                stack.push(str[i]);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char c = stack.pop();
                if (str[i] == ')' && c != '(' || str[i] == ']' && c != '[' 
                        || str[i] == '}' && c != '{') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
