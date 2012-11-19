package com.hisrv.leetcode;

import java.util.ArrayList;

public class LetterCombinationOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list = new ArrayList<String> ();
        if (digits == null || digits.length() == 0) {
            list.add("");
            return list;
        }
        ArrayList<String> map = getMap();
        return null;
    }
    
    private ArrayList<String> getMap() {
        ArrayList<String> keys = new ArrayList<String> ();
        keys.add("");
        keys.add("");
        keys.add("abc");
        keys.add("def");
        keys.add("ghi");
        keys.add("jkl");
        keys.add("mno");
        keys.add("pqrs");
        keys.add("tuv");
        keys.add("wxyz");
        return keys;
    }
}
