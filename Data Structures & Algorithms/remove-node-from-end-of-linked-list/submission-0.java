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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int cnt = 0;
        while(temp != null) {
            cnt++;
            temp = temp.next;
        }
        int nthNode = cnt - n + 1;
        if(nthNode == 1) return head.next;
        
        temp = head;
        ListNode prev = null;
        while(nthNode > 1) {
            prev = temp;
            temp = temp.next;
            nthNode--;
        }
        prev.next = temp.next;
        return head;
    }
}
