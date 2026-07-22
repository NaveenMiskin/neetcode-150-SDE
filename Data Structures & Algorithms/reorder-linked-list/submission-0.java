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

class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = findMiddle(head);

        ListNode second = reverse(mid.next);

        mid.next = null;

        ListNode first = head;
        while(second != null) {
            ListNode fnext = first.next;
            ListNode snext = second.next;

            first.next = second;
            second.next = fnext;

            first = fnext;
            second = snext;
        }
    }
}
