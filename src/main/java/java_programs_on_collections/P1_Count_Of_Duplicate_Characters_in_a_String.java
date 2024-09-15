package java_programs_on_collections;

import java.util.HashMap;
import java.util.Map;

public class P1_Count_Of_Duplicate_Characters_in_a_String 
{
	public static void main(String[] args)
	{ 
		// Find the Duplicate Characters in a String and Count its Occurrence
		String str ="Tata";
		
		Map<Character, Integer> dupCharMap = new HashMap<>(); 
		char[] charArr = str.toCharArray();
		
		for (char keys : charArr)
		{
				if(dupCharMap.containsKey(keys))   //"containsKey()"-> is boolean method Returns True (Or) Fale
				{
					dupCharMap.put(keys, dupCharMap.get(keys)+1);
				}
				else
				{
					dupCharMap.put(keys, 1);
				}		
		}
		System.out.println(dupCharMap);
	}
 } 

//====[Output]===========================================
//
