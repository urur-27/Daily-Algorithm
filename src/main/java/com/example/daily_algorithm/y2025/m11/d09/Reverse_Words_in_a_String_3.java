package com.example.daily_algorithm.y2025.m11.d09;

public class Reverse_Words_in_a_String_3 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left = 0;

        for(int i = 0; i < s.length() - 1; i++){
            if(arr[i] == ' '){
                reverse(arr, left, i - 1);
                left = i + 1;
            }
        }

        reverse(arr, left, arr.length - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
