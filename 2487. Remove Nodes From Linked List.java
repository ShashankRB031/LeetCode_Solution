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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head); // Step 1: Reverse the list
        ListNode dummy = new ListNode(0);
        ListNode curr = head, tail = dummy;
        int max = Integer.MIN_VALUE;

        // Step 2: Keep nodes that are >= max seen so far
        while (curr != null) {
            if (curr.val >= max) {
                max = curr.val;
                tail.next = curr;
                tail = tail.next;
            }
            curr = curr.next;
        }

        tail.next = null; // Important to terminate list

        // Step 3: Reverse again to restore original order
        return reverse(dummy.next);
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
