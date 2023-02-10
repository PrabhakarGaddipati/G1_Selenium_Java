package Test.Programs;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class NumberOf_OccuranceOf_Words_In_String_with_HashMap 
{
	public static void main(String[] args) 
	{
		// Declaring the String
		String str = "Alice is girl and Bob is boy";

		// Declaring a HashMap of <String, Integer>
		//Map<String, Integer> hashMap = new HashMap<>();
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();


		// Splitting the words of string
		// and storing them in the array.
		String[] words = str.split(" ");

		for (String word : words)
		{
			// Asking whether the HashMap contains the
			// key or not. Will return null if not.
			Integer integer = hashMap.get(word);

			if (integer == null)
				// Storing the word as key and its
				// occurrence as value in the HashMap.
				hashMap.put(word, 1);

			else {
				 // Incrementing the value if the word
				 // is already present in the HashMap.
				 hashMap.put(word, integer + 1);
			     }
		}
		System.out.println(hashMap);
	}
}

