/* Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the
next pointer.Internally, pos is used to denote the index of the node that tail's next pointer is connected to.Note that pos is
not passed as a parameter.
Return true if there is a cycle in the linked list.Otherwise, return false.*/

package linklistProgram;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


public class codeThird {
	
	// Method to detect cycle in the linked list
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1
            fast = fast.next.next;      // move fast by 2

            if (slow == fast) {
                return true;            // cycle detected
            }
        }

        return false; // no cycle
    }

    // Main method to test
    public static void main(String[] args) {
        // Create nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2 ...
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle

        // Check for cycle
        codeThird solution = new codeThird();
        boolean hasCycle = solution.hasCycle(node1);

        // Output result
        if (hasCycle) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }

}
