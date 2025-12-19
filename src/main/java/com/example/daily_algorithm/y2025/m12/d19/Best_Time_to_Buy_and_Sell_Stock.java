package com.example.daily_algorithm.y2025.m12.d19;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int minP = Integer.MAX_VALUE;
        int maxPro = 0;

        for(int price : prices){
            if(price < minP){
                minP = price;
            } else {
                maxPro = Math.max(maxPro, price - minP);
            }
        }

        return maxPro;
    }
}
