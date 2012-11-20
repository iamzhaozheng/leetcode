package com.hisrv.leetcode;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> list = new LetterCombinationOfAPhoneNumber().letterCombinations("2");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
