package com.hisrv.leetcode;

/**
 * @author zhengzhaomail
 * 
 */
public class Main {
	public static void main(String[] args) {
		testMultiplyStrings();
	}

	public static void testMultiplyStrings() {
		MultiplyStrings f = new MultiplyStrings();
		System.out.println(f.multiply("9", "99"));
	}

	public static void testFindKth() {
		FindKthNum f = new FindKthNum();
		System.out.println(f.findKthMin(new int[] { 1, 3 }, new int[] { 2, 4 },
				2));
	}

	public static void testMedianOfTwoSortedArrays() {
		MedianOfTwoSortedArrays f = new MedianOfTwoSortedArrays();
		System.out.println(f.findMedianSortedArrays(new int[] { 1, 3 },
				new int[] { 2, 4 }));
	}

}
