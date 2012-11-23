package com.hisrv.leetcode;

import java.util.Arrays;

public class ContainerWithMostWater {
	private class Line implements Comparable<Line> {
		public int h;
		public int p;

		@Override
		public int compareTo(Line l) {
			return l.h - h;
		}
	}

	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height == null || height.length == 0) {
			return 0;
		}
		Line[] lines = new Line[height.length];
		for (int i = 0; i < height.length; i++) {
			Line line = new Line();
			line.h = height[i];
			line.p = i;
			lines[i] = line;
		}
		Arrays.sort(lines);
		int area;
		int min = lines[0].p;
		int max = lines[0].p;
		area = 0;
		for (int i = 1; i < lines.length; i++) {
			if (lines[i].p < min) {
				min = lines[i].p;
			} else if (lines[i].p > max) {
				max = lines[i].p;
			}
			int a = (max - min) * lines[i].h;
			if (a > area) {
				area = a;
			}
		}
		return area;
	}
}
