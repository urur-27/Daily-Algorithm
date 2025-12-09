package com.example.daily_algorithm.y2025.m12.d09;

import java.util.HashSet;
import java.util.Set;

public class Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        // set → 배열 변환
        int[] answer = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            answer[idx++] = num;
        }
        return answer;
    }
}
