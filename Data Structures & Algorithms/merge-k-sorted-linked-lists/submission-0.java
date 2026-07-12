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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node : lists) {
            if(node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(!pq.isEmpty()) {
            ListNode minnode = pq.poll();
            tail.next = minnode;
            tail = tail.next;

            if(minnode.next != null) {
                pq.add(minnode.next);
            }
        }
        return dummy.next;
    }
}
