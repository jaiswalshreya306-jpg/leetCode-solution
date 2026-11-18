
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        int length = 1;

        // Find the length of the list
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Make k smaller than length
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Connect last node to head
        temp.next = head;

        // Find the new tail
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Set new head
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}
