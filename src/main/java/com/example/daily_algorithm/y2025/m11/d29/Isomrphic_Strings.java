package com.example.daily_algorithm.y2025.m11.d29;

import java.util.HashMap;
import java.util.Map;

public class Isomrphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        int idS = 0;
        int idT = 0;

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (!mapS.containsKey(c1)) {
                mapS.put(c1, idS++);
            }
            if (!mapT.containsKey(c2)) {
                mapT.put(c2, idT++);
            }

            if (!mapS.get(c1).equals(mapT.get(c2))) {
                return false;
            }
        }

        return true;
    }
}

