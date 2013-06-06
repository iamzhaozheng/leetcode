package com.hisrv.leetcode2;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] N1 = num1.toCharArray();
        char[] N2 = num2.toCharArray();
        reverse(N1);
        reverse(N2);
        char[] s = new char[1];
        s[0] = '0';
        for (int i = 0; i < N2.length; i ++) {
            s = plus(moveLeft(multiply(N1, N2[i] - '0'), i), s);
        }
        s = norm(s);
        return new String(s);
    }
    
    private char[] norm(char[] num) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = num.length - 1; i >= 0; i --) {
            if (num[i] != '0') {
                flag = true;
            }
            if (flag) {
                sb.append(num[i]);
            }
        }
        if (!flag) {
            sb.append(0);
        }
        return sb.toString().toCharArray();
    }
    
    private char[] moveLeft(char[] num, int n) {
        char[] ret = new char[num.length + n];
        for (int i = ret.length - 1; i >= 0; i --) {
            if (i - n >= 0) {
                ret[i] = num[i - n];
            } else {
                ret[i] = '0';
            }
        }
        return ret;
    }
    
    private char[] plus(char[] num1, char[] num2) {
        StringBuilder sb = new StringBuilder();
        int addition = 0;
        for (int i = 0; i < Math.max(num1.length, num2.length); i ++) {
            int n1 = i < num1.length ? num1[i] - '0' : 0;
            int n2 = i < num2.length ? num2[i] - '0' : 0;
            int t = n1 + n2 + addition;
            sb.append(t % 10);
            addition = t / 10;
        }
        if (addition > 0) {
            sb.append(addition);
        }
        return sb.toString().toCharArray();
    }
    
    private char[] multiply(char[] num, int a) {
        int addition = 0;
        int n = num.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            int t = (num[i] - '0') * a + addition;
            sb.append(t % 10);
            addition = t / 10;
        }
        if (addition != 0) {
            sb.append(addition);
        }
        return sb.toString().toCharArray();
    }
    
    private void reverse(char[] num) {
        for (int i = 0; i < num.length / 2; i ++) {
            swap(num, i, num.length - i - 1);
        }
    }
    
    private void swap(char[] num, int a, int b) {
        if (num[a] != num[b]) {
            num[a] ^= num[b];
            num[b] ^= num[a];
            num[a] ^= num[b];
        }
    }
}
