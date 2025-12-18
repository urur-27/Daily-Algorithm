package com.example.daily_algorithm.y2025.m12.d18;

public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() -1;

        while(i>=0 && s.charAt(i) == ' '){
            i--;
        }

        while(i>=0 && s.charAt(i) != ' '){
            length++;
            i--;
        }

        return length;
    }
}
