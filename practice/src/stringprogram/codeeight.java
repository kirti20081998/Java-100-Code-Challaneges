/*Given a string s of '(',')' and lowercase English characters.Your task is to remove the minimum number of parentheses('(' or ')', in any positions) so that the resulting 
  parentheses string is valid and return any valid string.*/

package stringprogram;

import java.util.Stack;

public class codeeight {
	public static String minRemoveToMakeVAlid(String s){
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '('){
				stack.push(sb.length());
				sb.append(c);
			}
			else if(c == ')'){
				if(!stack.isEmpty()){
					stack.pop();
					sb.append(c);
				}
			}else{
				sb.append(c);
			}
		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			sb.deleteCharAt(index);
			
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "a)b(c)d)";
		String result = minRemoveToMakeVAlid(s);
		System.out.println("Valid string: " + result);
	}

}
