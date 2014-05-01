package com.hisrv.leetcode3;

import java.util.Arrays;
import java.util.Comparator;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Bunch[] bunches = new Bunch[height.length];
        for (int i = 0; i < bunches.length; i ++) {
            bunches[i] = new Bunch(height[i], i);
        }
        Arrays.sort(bunches, new Comparator<Bunch> () {
            public int compare(Bunch a, Bunch b) {
                return b.h - a.h;
            }
        });
        int area = 0;
        int max = bunches[0].p;
        int min = bunches[0].p;
        for (int i = 1; i < bunches.length; i ++) {
            min = Math.min(min, bunches[i].p);
            max = Math.max(max, bunches[i].p);
            area = Math.max(area, (max - min) * bunches[i].h);
        }
        return area;
    }
    
    private class Bunch {
        public int h;
        public int p;
        public Bunch(int height, int pos) {
            h = height;
            p = pos;
        }
    }
}
