/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 1. Make a deep copy of the nodes in between of the linkedlist
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // 2. Connect the random pointers of the linkedlist.
        temp = head;
        while(temp != null) {
            Node copynode = temp.next;
            if(temp.random == null) {
                temp.random = null;
            } else {
                copynode.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // 3. Connecting the next Pointers
        temp = head;
        Node dummy = new Node(-1);
        Node dnode = dummy;
        while(temp != null) {
            dnode.next = temp.next;
            temp.next = temp.next.next;
            dnode = dnode.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
