package selenium_utilities;

import java.util.LinkedHashSet;
import java.util.Set;

public class P1_Remove_Duplicates_with_Set
{
    public static void main(String[] args)
    {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);
    }

    public static String removeDuplicates(String str)
    {
        // Create a LinkedHashSet to store characters in insertion order
        Set<Character> charSet = new LinkedHashSet<>();

        // Iterate through the string and add characters to the set
        for (char c : str.toCharArray())
        {
            charSet.add(c);  // LinkedHashSet will automatically ignore duplicates
        }

        // Use StringBuffer to build the result string without duplicates
        StringBuffer result = new StringBuffer();
        for (char c : charSet)
        {
            result.append(c);  // Append unique characters to result
        }

        return result.toString();
    }
}

//---------------------------------------------------------------------------
//Helped from - Arun Mothuri (QAFox.com)
