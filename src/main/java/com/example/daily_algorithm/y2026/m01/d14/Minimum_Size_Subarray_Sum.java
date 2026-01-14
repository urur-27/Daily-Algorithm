package com.example.daily_algorithm.y2026.m01.d14;

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        // Math.min으로 비교하기 위해 가장 큰 정수값으로 설정
        int minLen = Integer.MAX_VALUE;

        // 배열을 탐색하면서 조건에 맞는 길이 기록
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        // 유효한 배열이 없으면 0 반환
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
