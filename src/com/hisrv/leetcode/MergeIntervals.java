package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> ret = new ArrayList<Interval>();
		int n = intervals.size();
		if (n == 0) {
			return ret;
		}
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
		ret.add(intervals.get(0));
		for (int i = 1; i < n; i ++) {
			Interval ri = ret.get(ret.size() - 1);
			Interval si = intervals.get(i);
			if (si.start <= ri.end) {
				ri.end = Math.max(si.end, ri.end);
			} else {
				ret.add(si);
			}
		}
		return ret;
	}
}
