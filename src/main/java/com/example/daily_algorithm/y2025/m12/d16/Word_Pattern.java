package com.example.daily_algorithm.y2025.m12.d16;

import java.util.HashMap;
import java.util.Map;

public class Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pToWord = new HashMap<>();
        Map<String, Character> wordToP = new HashMap<>();

        char[] pChar = pattern.toCharArray();
        String rest = s;

        for (int i = 0; i < pChar.length; i++) {
            // 단어 하나 뽑기 (rest에서 앞 단어를 잘라냄)
            int spaceIdx = rest.indexOf(' ');
            String word;
            if (spaceIdx == -1) {
                word = rest;
                rest = ""; // 더 이상 남은 단어 없음
            } else {
                word = rest.substring(0, spaceIdx);
                rest = rest.substring(spaceIdx + 1);
            }

            char p = pChar[i];

            // 1) pattern 문자 -> 단어 일관성 체크
            if (pToWord.containsKey(p)) {
                if (!pToWord.get(p).equals(word)) return false;
            } else {
                pToWord.put(p, word);
            }

            // 2) 단어 -> pattern 문자 유일성 체크 (양방향)
            if (wordToP.containsKey(word)) {
                if (wordToP.get(word) != p) return false;
            } else {
                wordToP.put(word, p);
            }
        }

        return true;
    }
}
