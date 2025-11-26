package com.example.daily_algorithm.y2025.m11.d23;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Remove_Linked_List_Elements {

     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(head != null){
            if(head.val != val){
                tail.next = head;     
                tail = tail.next;           
            } 
            head = head.next;            
        }

        tail.next = null;
        return dummy.next;
    }    
}