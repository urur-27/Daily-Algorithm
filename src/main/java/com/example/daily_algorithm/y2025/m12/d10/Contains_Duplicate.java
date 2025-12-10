package com.example.daily_algorithm.y2025.m12.d10;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // 중복 발견
            }
            seen.add(num);
        }

        return false; // 중복 없음
    }
}
