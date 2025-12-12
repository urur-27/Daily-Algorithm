package com.example.daily_algorithm.y2025.m12.d13;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setN = new HashSet<>();
        for(int num : nums) {
            setN.add(num);
        }

        int output = 0;

        for (int num : setN){
            if(!setN.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (setN.contains(current + 1)){
                    current++;
                    length++;
                }

                output = Math.max(output, length);
            }
        }
        return output;
    }
}
