package com.hisrv.leetcode;


public class Main {
	public static void main(String[] args) {
		MaximalRectangle m = new MaximalRectangle();
		String[] ss = new String[] {"0110111111111111110","1011111111111111111","1101111111110111111","1111111111111011111","1111111111111101111","1110111011111111101","1011111111111101111","1111111111111110110","0011111111111110111","1101111111011111111","1111111110111111111","0110111011111111111","1111011111111101111","1111111111111111111","1111111111111111111","1111111111111111101","1111111101101101111","1111110111111110111"};
		char[][] cs = new char[ss.length][];
		for (int i = 0; i < ss.length; i ++) {
			cs[i] = ss[i].toCharArray();
		}
		System.out.println(m.maximalRectangle(cs));
		
		double k1 = 0.037037;
		double b1 = 194.111111;
		double ax = 131;
		System.out.println((int)(k1 * ax + b1));
	}
	
}
