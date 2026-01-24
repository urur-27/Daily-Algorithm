package com.example.daily_algorithm.y2026.m01.d24;

import java.util.ArrayDeque;
import java.util.Deque;

public class Online_Stock_Span {
    private Deque<int[]> stack;

    public Online_Stock_Span() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }
}
