/*
 * Given a string s containing just the characters '(',')', '{','}', '[',']' determine the input string 
 * is valid.
 */

package stackQueueProgram;

import java.util.Stack;

public class codeSixth {
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
    	codeSixth vp = new codeSixth();
        System.out.println(vp.isValid("()"));      // true
        System.out.println(vp.isValid("()[]{}"));  // true
        System.out.println(vp.isValid("(]"));      // false
        System.out.println(vp.isValid("([)]"));    // false
        System.out.println(vp.isValid("{[]}"));    // true
    }

}
