// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DeleteNodeinaLinkedList {
    // Function to delete a node (Leetcode 237)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Create the linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Suppose we want to delete the node with value 5
        ListNode nodeToDelete = head.next;

        // Create object to call deleteNode
        DeleteNodeinaLinkedList solution = new DeleteNodeinaLinkedList();
        solution.deleteNode(nodeToDelete); // Deletes node 5

        // Print the updated list: expected output is 4 -> 1 -> 9
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
