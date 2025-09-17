/*You are given the head of the singly linked list. The list can be represented as : 
 * L0 -> L1 -> ... -> Ln - 1 -> Ln 
 * Reorder the list to be on the following form : 
 * L0 -> Ln -> L1 -> Ln - 1 -> L2 -> Ln - 2 -> ... 
 * You may not modify the values in the list's nodes.Only nodes themselves may be changed.
 */

package linklistProgram;

public class codeSixth {
	
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode second = reverseList(slow.next);
        slow.next = null; // cut first half

        // Step 3: Merge two halves
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Print linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
    	codeSixth solution = new codeSixth();

        // Create example list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        solution.printList(head);

        solution.reorderList(head);

        System.out.println("Reordered list:");
        solution.printList(head);
    }

}
