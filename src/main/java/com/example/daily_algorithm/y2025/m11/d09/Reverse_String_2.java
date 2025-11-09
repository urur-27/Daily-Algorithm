package com.example.daily_algorithm.y2025.m11.d09;

public class Reverse_String_2 {
    public String reverseString(String s, int k) {

        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, len -1);

            while (left < right) {
                char tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }

        return new String(arr);
    }
}
