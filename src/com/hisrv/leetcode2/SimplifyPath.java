package com.hisrv.leetcode2;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] sp = path.split("/");
        Stack<String> stack = new Stack<String> ();
        int n = sp.length;
        for (int i = 0; i < n; i ++) {
            if (sp[i].equals(".") || sp[i].length() == 0) {
                //ignore this 
            } else if (sp[i].equals("..")) {
                if (stack.isEmpty()) {
                    //ignore this
                } else {
                    stack.pop();
                }
            } else {
                stack.push(sp[i]);
            }
        }
        String ret = "";
        for (int i = 0; i < stack.size(); i ++) {
            ret += "/";
            ret += stack.get(i);
        }
        return ret.length() == 0 ? "/" : ret;
    }
}
