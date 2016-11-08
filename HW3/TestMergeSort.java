/**************************************************************
For Assignment 3, implement the merge sort algorithm.You may 
hard code the initial set of unsorted integers.Run the program 
twice.  Once with even numbers (i.e. enter 16 numbers)
and once with odd numbers (i.e. enter 17 numbers)
**************************************************************/

package Homework3;

import java.util.Arrays;

public class TestMergeSort {
	
	public static void main(String[] args) {
		MergeSort ms= new MergeSort();
		
		int[] evenNumber = {40,2,14,8,33,17,22,5,31,19,28,11,7,38,27,13};

		System.out.println("The unsorted 16 integers are : " + Arrays.toString(evenNumber));
		System.out.println("Case 1(even number) : After sorting, the result will be ");
		
		ms.sort(evenNumber);
		System.out.println(Arrays.toString(evenNumber));
		
		int[] oddNumber = {40,2,14,8,33,17,22,5,31,19,28,11,7,38,27,13,1};
		
		System.out.println("\nThe unsorted 17 integers are : " + Arrays.toString(oddNumber));
		System.out.println("Case 2(odd number) : After sorting, the result will be ");
		
		ms.sort(oddNumber);
		System.out.println(Arrays.toString(oddNumber));
	}
}
