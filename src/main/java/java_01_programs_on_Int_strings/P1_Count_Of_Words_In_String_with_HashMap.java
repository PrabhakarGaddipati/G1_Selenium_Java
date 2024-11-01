package java_01_programs_on_Int_strings;
import java.util.HashMap;

public class P1_Count_Of_Words_In_String_with_HashMap
{
	public static void main(String[] args) 
	{
		String str = "Alice is girl and Bob is boy";

		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		String[] words = str.split(" ");

		for (String word : words)
		{
			Integer integer = hashMap.get(word);

			if (integer == null)
				hashMap.put(word, 1);
			else
				 hashMap.put(word, integer + 1);
		}
		System.out.println(hashMap);
	}
}

// Good Programing Logic - Understand
//====[Output]===========================================


