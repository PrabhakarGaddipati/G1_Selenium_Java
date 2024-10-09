package java_05_programs_on_formula_based;

//public class P2_Missing_Numbers_in_the_Array
//{
//	public static void main(String[] args)
//	{
//		int[] a = {1,2,3,4,6};
//		//sum without any missing number (Ex: Perform addition from 1 to 6 Digits)
//		int sumWithoutMiss = 0;
//
//		for (int i=1; i<=6; i++)
//		{
//			sumWithoutMiss = sumWithoutMiss + i; // 21
//		}
//
//		//sum with missing number (Ex: Perform addition from 1 to 6 Digits with Out missing number)
//		int sumWithMiss = 0;
//		for (int e : a)
//		{
//			sumWithMiss =  sumWithMiss + e;  // 16
//		}
//		System.out.println("The missing element in the array is: "+ (sumWithoutMiss-sumWithMiss));
//	}
//}
////====[Output]===========================================
////The missing element in the array is: 5
//
////Video Link: https://www.youtube.com/watch?v=g1xVzvI51ig&ab_channel=QAFox

public class P2_Missing_Numbers_in_the_Array
{
	public static void main(String[] args)
	{
		int[] nums = {1, 2, 4, 5, 6}; // 3 is missing
		System.out.println("The missing number is: " + MissingNum(nums));
	}

	public static int MissingNum(int nums[])
	{
		int sum = 0;

		// Step 1: Calculate the sum of all elements in the given array
		for(int i = 0; i < nums.length; i++)
		{
			sum = sum + nums[i];
		}

		// Step 2: Calculate the actual sum of numbers from 1 to (nums.length + 1)
		int actualSum = (nums.length + 1) * (nums.length + 2) / 2;

		// Step 3: The missing number is the difference between actualSum and the sum of array elements
		int missingnum = actualSum - sum;   //Most important Line in the Program.....
		return missingnum;
	}
}

