package com.example.daily_algorithm.y2025.m12.d2;

public class Longest_SubString_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] visited = new boolean[128]; // ASCII 문자 범위
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            while (visited[c]) {
                visited[s.charAt(start)] = false;
                start++;
            }

            visited[c] = true;
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }}
