/*
 You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. Merge all 
 the linked-lists into one sorted linked-list and return it.
 */
package heapProgram;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codeOne {
	
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap based on node values
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        // Add first node of each list to heap
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            tail.next = min;
            tail = min;

            if (min.next != null) pq.offer(min.next);
        }

        return dummy.next;
    }

    // Example usage
    public static void main(String[] args) {
    	codeOne solver = new codeOne();

        // Build lists: [1->4->5], [1->3->4], [2->6]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode merged = solver.mergeKLists(lists);

        // Print merged list
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        // Output: 1 1 2 3 4 4 5 6
    }

}
