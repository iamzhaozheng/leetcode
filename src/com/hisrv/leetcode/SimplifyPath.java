package com.hisrv.leetcode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] names = path.split("/");
        int n = names.length;
        Stack<String> stack = new Stack<String> ();
        for (int i = 0; i < n; i ++) {
            if (names[i].equals(".") || names[i].equals("")) {
                //do nothing
            } else if (names[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(names[i]);
            }
        }
        String ret = "";
        for (int i = 0; i < stack.size(); i ++) {
            ret += "/" + stack.get(i);
        }
        if (ret.length() == 0) {
            ret = "/";
        }
        return ret;
    }
}
