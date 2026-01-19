package com.example.daily_algorithm.y2026.m01.d19;

public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int numsIdx = m+n-1;
        int nums1Idx = m-1;
        int nums2Idx = n-1;

        while (nums1Idx >= 0 && nums2Idx >= 0) {
            if (nums1[nums1Idx] > nums2[nums2Idx]) {
                nums1[numsIdx] = nums1[nums1Idx];
                nums1Idx--;
            } else {
                nums1[numsIdx] = nums2[nums2Idx];
                nums2Idx--;
            }
            numsIdx--;
        }

        while (nums2Idx >= 0) {
            nums1[numsIdx] = nums2[nums2Idx];
            nums2Idx--;
            numsIdx--;
        }
    }
}
