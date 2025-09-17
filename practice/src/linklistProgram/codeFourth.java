/*You are given the heads of two sorted linked lists list1 and list2.Merge the two lists in a one 
sorted list.The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list*/ 

package linklistProgram;




public class codeFourth {
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node to simplify pointer logic
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;    // attach smaller node
                list1 = list1.next;      // move ahead in list1
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;      // move current forward
        }

        // Attach remaining part (only one list may have elements left)
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next; // head of merged list
    }

    // Helper method to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Test it in main
    public static void main(String[] args) {
        // Create list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create list2: 1 -> 3 -> 5
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);

        codeFourth merger = new codeFourth();
        ListNode merged = merger.mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        merger.printList(merged);
    }

}
