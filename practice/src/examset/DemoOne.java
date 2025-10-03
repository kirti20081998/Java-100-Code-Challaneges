package examset;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class DemoOne {
	
	public static void main(String[] args) {
		String sentence = "Java is fun and Java is powerful and popular";
		sentence = sentence.toLowerCase();
		String[] words = sentence.split("\\s+");
		Set<String> uniqueWords = new TreeSet<>(Arrays.asList(words));
		for(String word : uniqueWords) {
			System.out.println(word);
		}
	}

}
