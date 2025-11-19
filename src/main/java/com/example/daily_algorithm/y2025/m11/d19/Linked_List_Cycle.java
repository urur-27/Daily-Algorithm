package com.example.daily_algorithm.y2025.m11.d19;

import com.example.daily_algorithm.y2025.m11.d18.Middle_of_the_Linked_List.ListNode;

public class Linked_List_Cycle {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;

    }

}
