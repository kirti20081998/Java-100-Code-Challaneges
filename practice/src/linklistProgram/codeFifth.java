//Given the head of the linklist, remove the nth node from the end of the list and return its head.

package linklistProgram;

public class codeFifth {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer ahead by n+1 steps
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node
        second.next = second.next.next;
        
        return dummy.next;
    }

    // Helper method to print the list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
    	codeFifth solution = new codeFifth();

        // Create sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        solution.printList(head);

        // Remove 2nd node from end
        head = solution.removeNthFromEnd(head, 2);

        System.out.println("After removing 2nd node from end:");
        solution.printList(head);
    }

}
