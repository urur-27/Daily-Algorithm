package com.example.daily_algorithm.y2026.m01.d15;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        // 길이가 0일 수 있으니까 0이면 바로 종료
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++) {
            // 동일한 문자가 될 때까지 쪼개가며 비교
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }

        return prefix;
    }
}
