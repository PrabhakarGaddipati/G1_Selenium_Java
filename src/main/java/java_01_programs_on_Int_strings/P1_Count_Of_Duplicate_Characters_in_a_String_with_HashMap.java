package java_01_programs_on_Int_strings;

import java.util.HashMap;
import java.util.Map;

public class P1_Count_Of_Duplicate_Characters_in_a_String_with_HashMap
{
    public static void main(String[] args)
    {
        String str = "Tata";

        Map<Character, Integer> dupCharMap = new HashMap<>();
        char[] charArr = str.toCharArray();

        for (char keys : charArr)
        {
            if (dupCharMap.containsKey(keys))   //"containsKey()"-> is boolean method Returns True (Or) Fale
            {
                dupCharMap.put(keys, dupCharMap.get(keys) + 1);
                System.out.println("Output: " +dupCharMap.put(keys, dupCharMap.get(keys) + 1));
            }
            else
            {
                dupCharMap.put(keys, 1);
            }
        }
        System.out.println(dupCharMap);
    }
}

// Good Programing Logic - Understand
//====[Output]===========================================
//
