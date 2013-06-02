package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.hisrv.leetcode.Interval;

public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Collections.sort(intervals, new Comparator<Interval> () {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        ArrayList<Interval> ret = new ArrayList<Interval> ();
        if (intervals.size() == 0) {
            return ret;
        }
        Interval temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i ++) {
            if (overlap(temp, intervals.get(i))) {
                temp = merge(temp, intervals.get(i));
            } else {
                ret.add(temp);
                temp = intervals.get(i);
            }
        }
        ret.add(temp);
        return ret;
    }
    
    private boolean overlap(Interval a, Interval b) {
        return !(a.end < b.start || a.start > b.end);
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
