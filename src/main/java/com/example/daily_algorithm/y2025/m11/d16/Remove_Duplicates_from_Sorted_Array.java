package com.example.daily_algorithm.y2025.m11.d16;

public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int k = 1;

        for(int i = 1; i< len; i++){
            if(nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
