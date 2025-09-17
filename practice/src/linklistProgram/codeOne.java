/*Given a head of a singly linked list, reverse the list, and return the revered list.*/

package linklistProgram;

public class codeOne {
	
	// Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to reverse the linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Store next node
            current.next = prev;              // Reverse current node's pointer
            prev = current;                   // Move prev one step forward
            current = nextNode;               // Move current one step forward
        }

        return prev; // New head of the reversed list
    }

    // Utility method to print the list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the reverseList method
    public static void main(String[] args) {
    	codeOne listHandler = new codeOne();

        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original List: ");
        listHandler.printList(head);

        // Reversing the list
        ListNode reversedHead = listHandler.reverseList(head);

        System.out.print("Reversed List: ");
        listHandler.printList(reversedHead);
    }

}
