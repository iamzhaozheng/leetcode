package com.hisrv.leetcode;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	char[] cs1 = num1.toCharArray();
    	char[] cs2 = num2.toCharArray();
    	int n1 = cs1.length;
    	int n2 = cs2.length;
    	if (n1 == 0 || n2 == 0) {
            return "";
    	}
    	if (n2 > n1) {
    		char[] t = cs1;
    		cs1 = cs2;
    		cs2 = t;
    	}
    	n1 = cs1.length;
    	n2 = cs2.length;
    	rev(cs1);
    	rev(cs2);
    	char[][] store = new char[10][];
    	char[] ret = null;
    	for (int i = 0; i < n2; i ++) {
    		int idx = cs2[i] - '0';
    		if (store[idx] == null) {
    			store[idx] = multiply(cs1, idx);
    		}
    		if (ret == null) {
    			ret = Arrays.copyOf(store[idx], store[idx].length);
    		} else {
    			ret = add(ret, store[idx], i);
    		}
    	}
    	rev(ret);
    	int i = 0;
    	for (i = 0; i < ret.length - 1; i ++) {
    		if (ret[i] != '0') {
    			break;
    		}
    	}
    	return new String(ret, i, ret.length - i);
    }
    
    private void rev(char[] a) {
    	for (int i = 0; i < a.length / 2; i ++) {
    		if (a[i] != a[a.length - i - 1]) {
    			a[i] ^= a[a.length - i - 1];
    			a[a.length - i - 1] ^= a[i];
    			a[i] ^= a[a.length - i - 1];
    		}
    	}
    }
    
    private char[] add(char[] a, char[] b, int move) {
    	String c = "";
    	int carry = 0;
    	for (int i = 0; i < Math.max(a.length, b.length + move); i ++) {
    		char s;
    		if (i < move) {
    			if (i < a.length) {
    				s = a[i];
    			} else {
    				s = '0';
    			}
    		} else {
    			if (i < a.length && i - move < b.length) {
    				s = (char)(a[i] + b[i - move] - '0' + carry);
    			} else if (i < a.length) {
    				s = (char)(a[i] + carry);
    			} else {
    				s = (char)(b[i - move] + carry);
    			}
    		}
    		if (s > '9') {
    			carry = 1;
    			c += (char)(s - 10);
    		} else {
    			carry = 0;
    			c += (char)s;
    		}
    	}
    	if (carry == 1) {
    		c += "1";
    	}
    	return c.toCharArray();
    }
    
    private char[] multiply(char[] a, int b) {
    	int carry = 0;
    	String c = "";
    	for (int i = 0; i < a.length; i ++) {
    		int s = (a[i] - '0') * b + carry;
    		c += (char)(s % 10 + '0');
    		carry = s / 10;
    	}
    	if (carry != 0) {
    		c += (char)(carry + '0');
    	}
    	return c.toCharArray();
    }
}
