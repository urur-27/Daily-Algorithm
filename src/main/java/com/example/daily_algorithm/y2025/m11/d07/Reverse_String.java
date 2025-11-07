package com.example.daily_algorithm.y2025.m11.d07;

public class Reverse_String {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char extra;

        while (left < right){
            extra = s[right];
            s[right] = s[left];
            s[left] = extra;
            left++;
            right--;
        }
    }

    // 테스트용 main
    public static void main(String[] args) {
        Reverse_String rs = new Reverse_String();
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        rs.reverseString(input);
        System.out.println(input); // 결과 출력: "olleh"
    }
}
