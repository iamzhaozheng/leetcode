package com.hisrv.leetcode2;

import java.util.Stack;

public class DivideTwoIntegers {
    //test case: 0 0, 0 1, 1 1, 1 0, 1 2, 2 1, MAX_INT 1, 1 MAX_INT, 1 -1, MAX_INT 2, MAX_INT -2, MIN_INT 1
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (divisor == 0) {
            return 0;
        }
        boolean positive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? true : false;
        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);
        Stack<Stair> stack = new Stack<Stair> ();
        long i = divisorL;
        long step = 1;
        while (i <= dividendL) {
            stack.push(new Stair(i, step));
            i += i;
            step += step;
        }
        long ret = 0;
        while (!stack.isEmpty()) {
            Stair stair = stack.pop();
            if (dividendL >= stair.value) {
                dividendL -= stair.value;
                ret += stair.step;
            }
        }
        return positive ? (int)ret : (int)-ret;
    }
    
    private class Stair {
        public long value;
        public long step;
        public Stair(long v, long s) {
            value = v;
            step = s;
        }
    }

}
