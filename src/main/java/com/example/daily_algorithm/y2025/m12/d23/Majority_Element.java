package com.example.daily_algorithm.y2025.m12.d23;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int answer = nums[0];

        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);

            if (cnt > maxCount) {
                maxCount = cnt;
                answer = num;
            }
        }

        return answer;
    }
}
