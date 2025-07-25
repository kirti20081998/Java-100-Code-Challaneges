/*Given a head of a Linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head*/

package sortingAndRecursionProgram;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

public class codeten {

	public ListNode removeElements(ListNode head, int val) {
		// Create a dummy node before head to simplify edge case removals (e.g., head
		// itself)
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode current = dummy;

		while (current.next != null) {
			if (current.next.val == val) {
				// Skip the node
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		return dummy.next; // Return new head (in case head was removed)
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);

		int valToRemove = 6;

		codeten remover = new codeten();
		ListNode result = remover.removeElements(head, valToRemove);

		// Print result list
		System.out.print("Updated List: ");
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

}
