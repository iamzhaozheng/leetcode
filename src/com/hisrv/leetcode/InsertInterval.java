package com.hisrv.leetcode;
import java.util.ArrayList;


public class InsertInterval {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Interval> list = new ArrayList<Interval> ();
	        Interval merged = new Interval(newInterval.start, newInterval.end);
	        if (intervals == null || intervals.size() == 0) {
	            list.add(merged);
	            return list;
	        }
	        if (merged.end < intervals.get(0).start) {
	            list.add(merged);
	            list.addAll(intervals);
	            return list;
	        }
	        boolean added = false;
	        for (int i = 0; i < intervals.size(); i ++) {
	            Interval interval = intervals.get(i);
	            if (overlap(merged, interval)) {
	                merged.start = Math.min(merged.start, interval.start);
	                merged.end = Math.max(merged.end, interval.end);
	            } else {
	                list.add(interval);
	            }
	            if (!added && (i + 1 < intervals.size() && merged.end < intervals.get(i + 1).start || 
	                    i + 1 == intervals.size())) {
	                list.add(merged);
	                added = true;
	            }
	        }
	        return list;
	    }
	    
	    private boolean overlap(Interval a, Interval b) {
	        if (a.end < b.start || b.end < a.start) {
	            return false;
	        }
	        return true;
	    }
}
