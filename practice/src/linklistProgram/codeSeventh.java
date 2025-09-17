/*Given the heads of the two singly linked-lists headA and headB, return the node at which the two lists 
 * intersect. If the two linked lists have o intersection at all, return null.
 */

package linklistProgram;

import linklistProgram.codeSecond.ListNode;

public class codeSeventh {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse both lists
        while (pA != pB) {
            // If one pointer reaches end, redirect to other list's head
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        // Either the intersection node or null
        return pA;
    }

    // Helper to print linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
    	codeSeventh solution = new codeSeventh();

        // Create two linked lists that intersect:
        // A: 1 -> 9 \
        //             -> 3 -> 4 -> 5
        // B:     2  /
        ListNode intersect = new ListNode(3);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = intersect;

        ListNode headB = new ListNode(2);
        headB.next = intersect;

        ListNode result = solution.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection Node: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }

}
