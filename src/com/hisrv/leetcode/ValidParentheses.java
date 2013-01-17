package com.hisrv.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = s.toCharArray();
        int n = cs.length;
        Stack<Character> stack = new Stack<Character> ();
        for (int i = 0; i < n; i ++) {
            switch (cs[i]) {
            case '(':
            case '[':
            case '{':
                stack.push(cs[i]);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char c = stack.pop();
            if (c == '(' && cs[i] != ')') {
                return false;
            }
            if (c == '[' && cs[i] != ']') {
                return false;
            }
            if (c == '{' && cs[i] != '}') {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
