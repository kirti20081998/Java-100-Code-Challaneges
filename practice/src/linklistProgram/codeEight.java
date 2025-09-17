package linklistProgram;

import linklistProgram.codeSecond.ListNode;

public class codeEight {
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Step 1: Check if there are at least k nodes ahead
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }

        if (count < k) {
            return head; // Not enough nodes, return as-is
        }

        // Step 2: Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: head now points to the (k+1)th node after reversal
        // Recursively call for the rest of the list
        head.next = reverseKGroup(curr, k);

        // Return new head (prev is new head after reversal)
        return prev;
    }

    // Helper to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
    	codeEight solution = new codeEight();

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        solution.printList(head);

        int k = 2;
        head = solution.reverseKGroup(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        solution.printList(head);
    }

}
