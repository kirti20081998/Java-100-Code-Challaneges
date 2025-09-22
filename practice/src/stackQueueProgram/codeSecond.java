/*Implement a LIFO stacks using two queue.
 *The implemented stack should support all the functions of a normal stack.(push, top, pop and empty)*/

package stackQueueProgram;

import java.util.LinkedList;
import java.util.Queue;

public class codeSecond {
	
	private Queue<Integer> q1;
    private Queue<Integer> q2;

    public codeSecond() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q2.add(x);  // Step 1: add new element to q2

        // Step 2: move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Step 3: swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack and returns it
    public int pop() {
        return q1.poll();
    }

    // Get the top element
    public int top() {
        return q1.peek();
    }

    // Returns whether the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
    	codeSecond stack = new codeSecond();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top()); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.top()); // 2
        System.out.println(stack.empty()); // false
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.empty()); // true
    }

}
