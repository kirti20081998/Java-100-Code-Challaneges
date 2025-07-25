/* Given a Roman numeral, convert it to an integer */

package stringProgram;

import java.util.HashMap;
import java.util.Map;

public class codesixth {
	public int romanToInt(String s) {
		
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		int total = 0;
		
		for(int i=0; i < s.length(); i++) {
			int currVal = romanMap.get(s.charAt(i));
			int nextVal = (i + 1 < s.length()) ? romanMap.get(s.charAt(i + 1)) : 0;
			
			if(currVal < nextVal) {
				total -= currVal;
			} else {
				total += currVal;
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		codesixth converter = new codesixth();
		
		String roman = "MCMXCIV";
		int result = converter.romanToInt(roman);
		System.out.println("Roman " + roman + " => Integer:" + result);
		
	}
}
