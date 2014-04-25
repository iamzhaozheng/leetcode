package com.hisrv.leetcode2;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Bunch[] bunches = new Bunch[numbers.length];
        for (int i = 0; i < numbers.length; i ++) {
            bunches[i] = new Bunch(numbers[i], i + 1);
        }
        Arrays.sort(bunches, new Comparator<Bunch> () {
                public int compare(Bunch a, Bunch b) {
                    return a.num - b.num;
                }
            });
        int i = 0;
        int j = numbers.length - 1;
        
        while (i < j) {
            int sum = bunches[i].num + bunches[j].num;
            if (sum > target) {
                j --;
            } else if (sum < target) {
                i ++;
            } else {
                int[] ret = new int[] {bunches[i].idx, bunches[j].idx};
                Arrays.sort(ret);
                return ret;
            }
        }
        return new int[] {0, 0};
    }
    
    private class Bunch {
        public int num;
        public int idx;
        public Bunch(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
