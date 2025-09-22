/*
 Implement a fifo queue using two stacks.
 The implemented queue should support all the functions of a normal queue.(push, peek, pop ad empty)
 */

package stackQueueProgram;

import java.util.Stack;

public class codeFirst {
	
	private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public codeFirst() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        stackIn.push(x);
    }

    // Removes the element from in front of queue and returns that element.
    public int pop() {
        shiftStacks();
        return stackOut.pop();
    }

    // Get the front element.
    public int peek() {
        shiftStacks();
        return stackOut.peek();
    }

    // Returns whether the queue is empty.
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // Helper: transfer elements only if stackOut is empty
    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
    	codeFirst q = new codeFirst();

        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.peek()); // 1
        System.out.println(q.pop());  // 1
        System.out.println(q.pop());  // 2
        System.out.println(q.empty()); // false
        System.out.println(q.pop());  // 3
        System.out.println(q.empty()); // true
    }

}
