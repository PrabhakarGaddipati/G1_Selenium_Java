package selenium_utilities;

import java.util.HashMap;
import java.util.Map;

public class Strings_Count_Of_Duplicate_Characters_in_a_String_P1
{
    public static void main(String[] args)
    {
        // Find the Duplicate Characters in a String and Count its Occurrence
        String str = "Tata";

        Map<Character, Integer> dupCharMap = new HashMap<>();
        char[] charArr = str.toCharArray();

        for (char keys : charArr)
            if (dupCharMap.containsKey(keys))
            {
                dupCharMap.put(keys, dupCharMap.get(keys) + 1);  //"containsKey()"-> is boolean method Returns True (Or) Fale
            } else
            {
                dupCharMap.put(keys, 1);
            }
        System.out.println(dupCharMap);
    }
}




//====[Output]===========================================
//{a=2, T=1, t=1}
