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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = l1;
        ListNode r = l2;

        ListNode dummy = new ListNode(-1);
        ListNode dnode = dummy;

        int carry = 0;
        while(l != null || r != null) {
            int sum = carry;

            if(l != null) sum += l.val;
            if(r != null) sum += r.val;

            dnode.next = new ListNode(sum % 10);
            dnode = dnode.next;
            carry = sum / 10;

            if(l != null) l = l.next;
            if(r != null) r = r.next;
        }
        if(carry != 0) dnode.next = new ListNode(carry);
        return dummy.next;
    }
}
