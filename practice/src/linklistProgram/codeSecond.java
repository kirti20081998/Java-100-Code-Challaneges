/* Given the head of a linked list, rotate the list to the right by k places. */

package linklistProgram;

public class codeSecond {

	// Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Method to rotate the list to the right by k places
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Compute the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Make it a circular list
        current.next = head;

        // Step 3: Find new tail: (length - k % length - 1)th node
        // and new head: (length - k % length)th node
        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = current;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Utility method to print the list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
    	codeSecond listHandler = new codeSecond();

        // Creating list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        listHandler.printList(head);

        int k = 2;
        ListNode rotated = listHandler.rotateRight(head, k);

        System.out.print("Rotated List by " + k + ": ");
        listHandler.printList(rotated);
    }
}
