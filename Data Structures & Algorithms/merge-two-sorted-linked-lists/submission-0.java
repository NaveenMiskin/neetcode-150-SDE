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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode dNode = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                dNode.next = l1;
                dNode = l1;
                l1 = l1.next;
            } else {
                dNode.next = l2;
                dNode = l2;
                l2 = l2.next;
            }
        }
        while(l1 != null) {
            dNode.next = l1;
            dNode = l1;
            l1 = l1.next;
        }
        while(l2 != null) {
            dNode.next = l2;
            dNode = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}