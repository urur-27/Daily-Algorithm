package com.example.daily_algorithm.y2025.m11.d26;

public class Reverse_Linked_List {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // 다음 노드를 미리 저장
            ListNode next = curr.next;

            // 포인터 방향 뒤집기
            curr.next = prev;

            // prev, curr 한 칸씩 이동
            prev = curr;
            curr = next;
        }

        // prev가 새로운 head
        return prev;
    }

}
