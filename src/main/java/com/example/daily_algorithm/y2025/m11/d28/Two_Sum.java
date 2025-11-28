package com.example.daily_algorithm.y2025.m11.d28;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[]{}; // 조건상 여기 도달하지는 않음
    }
}
