package com.example.daily_algorithm.y2025.m12.d22;

public class Plus_One {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length -1; i >= 0; i --){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}
