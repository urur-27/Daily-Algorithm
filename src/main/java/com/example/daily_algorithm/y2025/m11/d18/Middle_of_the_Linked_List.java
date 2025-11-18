package com.example.daily_algorithm.y2025.m11.d18;

public class Middle_of_the_Linked_List {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        // 길이 세기
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // 중간 위치 계산
        int steps = len / 2;

        // 다시 head에서 시작해 steps만큼 이동
        cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }

        return cur;
    }
}
