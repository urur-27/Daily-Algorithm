package com.example.daily_algorithm.y2025.m12.d11;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1){
            if(seen.contains(n)){
                return false; // 사이클 발생
            }

            seen.add(n);
            n = getNext(n);
        }

        return true;
    }

    // 각 자릿수 제곱의 합 구하기
    private int getNext(int n){
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
