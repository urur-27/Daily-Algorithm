package com.example.daily_algorithm.y2025.m12.d4;

import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(sChar[i], mapS.getOrDefault(sChar[i], 0) + 1);
            mapT.put(tChar[i], mapT.getOrDefault(tChar[i], 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = sChar[i];

            Integer countS = mapS.get(c);
            Integer countT = mapT.get(c);

            if (countT == null || !countS.equals(countT)) {
                return false;
            }
        }

        return true;
    }
}
