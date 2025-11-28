package com.example.daily_algorithm.y2025.m11.d28;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
