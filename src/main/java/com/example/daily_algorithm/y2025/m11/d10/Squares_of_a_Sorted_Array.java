package com.example.daily_algorithm.y2025.m11.d10;

public class Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums){
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;

        while(left < right){
            int left2 = nums[left] * nums[left];
            int right2 = nums[right] * nums[right];
            if(left2 < right2){
                result[left] = left2;
                left++;
            }
            else{
                result[right] = right2;
                right--;
            }
        }
        return result;
    }

}
