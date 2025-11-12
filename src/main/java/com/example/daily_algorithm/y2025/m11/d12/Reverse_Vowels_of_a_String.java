package com.example.daily_algorithm.y2025.m11.d12;

public class Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int left = 0, right = a.length - 1;

        while (left < right) {
            while (left < right && !isVowel(a[left])) left++;
            while (left < right && !isVowel(a[right])) right--;

            if (left < right) {
                char tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(a);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

}
