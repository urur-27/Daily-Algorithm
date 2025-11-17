package com.example.daily_algorithm.y2025.m11.d17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 1. 정렬
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // 같은 값에 대해 중복 계산 방지
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // nums[i]가 이미 0보다 크면, 이후는 모두 양수이므로 더 이상 0을 만들 수 없음
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // left 중복 제거
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // right 중복 제거
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++; // 합이 작으면 더 큰 수를 향해 왼쪽 포인터 이동
                } else {
                    right--; // 합이 크면 더 작은 수를 향해 오른쪽 포인터 이동
                }
            }
        }

        return result;
    }
}
