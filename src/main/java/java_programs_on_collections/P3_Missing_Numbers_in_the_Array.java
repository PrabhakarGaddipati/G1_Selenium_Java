package java_programs_on_collections;

public class P3_Missing_Numbers_in_the_Array 
{
	public static void main(String[] args) 
	{
		int[] a = {1,2,3,4,6};
		//sum without any missing number (Ex: Perform addition from 1 to 6 Digits)
		int sumWithoutMiss = 0;

		for (int i=1; i<=6; i++) 
		{
			sumWithoutMiss = sumWithoutMiss + i; // 21
		}

		//sum with missing number (Ex: Perform addition from 1 to 6 Digits with Out missing number)
		int sumWithMiss = 0;
		for (int e : a)
		{
			sumWithMiss =  sumWithMiss + e;  // 16
		}
		System.out.println("The missing element in the array is: "+ (sumWithoutMiss-sumWithMiss));
	}
}
//====[Output]===========================================
//The missing element in the array is: 5

//Video Link: https://www.youtube.com/watch?v=g1xVzvI51ig&ab_channel=QAFox


