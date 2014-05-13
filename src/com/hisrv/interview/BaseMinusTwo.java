package com.hisrv.interview;

import java.util.ArrayList;

public class BaseMinusTwo {
	public int[] solve(int[] a, int[] b) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i ++) {
			ret.add(a[i]);
		}
		for (int i = 0; i < b.length; i ++) {
			if (b[i] == 1) {
				plusOne(ret, i);
			}
		}
		int[] arr = new int[ret.size()];
		for (int i = 0; i < arr.length; i ++) {
			arr[i] = ret.get(i);
		}
		return arr;
	}
	
	private void plusOne(ArrayList<Integer> a, int idx) {
		if (idx >= a.size()) {
			a.add(1);
		} else if (a.get(idx) == 0) {
			a.set(idx, 1);
		} else if (idx + 1 < a.size()){
			a.set(idx, 0);
			if (a.get(idx + 1) == 0) {
				a.set(idx + 1, 1);
				plusOne(a, idx + 2);
			} else {
				a.set(idx + 1, 0);
			}
		} else {
			a.set(idx, 0);
			a.add(1);
			plusOne(a, idx + 2);
		}
	}
	
	public static void main(String[] args) {
		BaseMinusTwo f = new BaseMinusTwo();
		int[] ret = f.solve(new int[] {1}, new int[] {1, 1});
		for (int i = 0; i < ret.length; i ++) {
			System.out.print(ret[i]);
			System.out.print(" ");
		}
 	}
}
