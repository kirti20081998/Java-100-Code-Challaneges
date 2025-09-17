package linklistProgram;

import linklistProgram.codeOne.ListNode;

public class codeNine {
	
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare both halves
        ListNode firstHalf = head;
        ListNode copySecond = secondHalf; // keep copy to restore later if needed
        boolean result = true;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // (Optional) Step 4: Restore the list
        reverseList(copySecond);

        return result;
    }

    // Helper to reverse a linked list
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
    	codeNine solution = new codeNine();

        // Example 1: Palindrome list
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome? " + solution.isPalindrome(head1)); // true

        // Example 2: Not a palindrome
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("Is Palindrome? " + solution.isPalindrome(head2)); // false
    }

}
