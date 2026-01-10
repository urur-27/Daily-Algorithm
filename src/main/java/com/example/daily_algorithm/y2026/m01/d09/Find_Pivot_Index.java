package com.example.daily_algorithm.y2026.m01.d09;

public class Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == total) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1; // 피벗 인덱스가 없는 경우
    }
}
