package com.hisrv.leetcode2;

import java.util.ArrayList;

import com.hisrv.leetcode.Interval;

public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> ret = new ArrayList<Interval> ();
        int p = intervals.size();
        for (int i = 1; i < intervals.size(); i ++) {
            if (newInterval.start >= intervals.get(i - 1).start && 
                    newInterval.start < intervals.get(i).start) {
                p = i;
            }
        }
        if (p > 0 && newInterval.start < intervals.get(0).start) {
            p = 0;
        }
        intervals.add(p, newInterval);
        Interval temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i ++) {
            if (cross(temp, intervals.get(i)) == 0) {
                temp = merge(temp, intervals.get(i));
            } else {
                ret.add(temp);
                temp = intervals.get(i);
            }
        }
        ret.add(temp);
        return ret;
    }
    
    private int cross(Interval a, Interval b) {
        if (a.end < b.start) {
            return -1;
        } else if (a.start > b.end) {
            return 1;
        } else {
            return 0;
        }
    }
    
    private Interval merge(Interval a, Interval b) {
        int s, e;
        if (a.start < b.start) {
            s = a.start;
        } else {
            s = b.start;
        }
        if (a.end > b.end) {
            e = a.end;
        } else {
            e = b.end;
        }
        return new Interval(s, e);
    }
}
