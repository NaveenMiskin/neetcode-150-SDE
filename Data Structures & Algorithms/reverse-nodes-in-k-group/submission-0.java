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
    public ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newNode = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newNode;
    }
    public ListNode findKthNode(ListNode head, int k) {
        k -= 1;
        while(head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode previousNode = null;
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            if(kthNode == null) {
                if(previousNode != null) previousNode.next = temp;
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverseLL(temp);

            if(temp == head) {
                head = kthNode;
            } else {
                previousNode.next = kthNode;
            }
            previousNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
