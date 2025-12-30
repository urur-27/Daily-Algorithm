package com.example.daily_algorithm.y2025.m12.d30;

public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
