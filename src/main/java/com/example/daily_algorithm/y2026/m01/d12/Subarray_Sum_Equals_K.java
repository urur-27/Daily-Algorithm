package com.example.daily_algorithm.y2026.m01.d12;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;
            count += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}
