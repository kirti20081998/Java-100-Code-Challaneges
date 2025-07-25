/* Write a function that reverses a string. The input string is given as an array of character s.You must do this by modifying the input array in-place with O(1) extra memory.*/
package stringProgram;

public class codeone {
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;

		// Swap characters from both ends toward the center
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;

			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		codeone rs = new codeone();
		char[] s = { 'H', 'e', 'l', 'l', 'o' };
		rs.reverseString(s);

		System.out.println("Reversed String: " + new String(s));
	}
}
