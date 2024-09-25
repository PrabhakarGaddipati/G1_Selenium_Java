package java_02_programs_on_arrays;

import java.util.ArrayList;

public class P2_Find_Duplicate_Elements_in_Array
{
	public static void main(String[] args) 
	{
		int[] array = new int[]{2, 4, 7, 2, 11, 17, 2, 19, 7, 22, 7, 49};
		ArrayList<Integer> duplicates = new ArrayList<>();

		for (int i = 0; i < array.length; i++)
		{
			for (int j = i + 1; j < array.length; j++) 
			{
				if (i != j && array[i] == array[j] && !duplicates.contains(array[i])) 
				{
					duplicates.add(array[i]);
				}
			}
		}
	}
}