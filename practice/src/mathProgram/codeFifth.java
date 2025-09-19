package mathProgram;

public class codeFifth {
	
	public char findTheDifference(String s, String t) {
        char result = 0;

        // XOR all characters of s and t
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result; // leftover char is the answer
    }

    // Example usage
    public static void main(String[] args) {
    	codeFifth solution = new codeFifth();

        String s = "abcd";
        String t = "abcde";
        System.out.println("Added character: " + solution.findTheDifference(s, t)); // e

        s = "";
        t = "y";
        System.out.println("Added character: " + solution.findTheDifference(s, t)); // y

        s = "a";
        t = "aa";
        System.out.println("Added character: " + solution.findTheDifference(s, t)); // a
    }

}
