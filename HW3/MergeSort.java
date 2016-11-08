package Homework3;

public class MergeSort {

	public void sort(int[] array) {
		
		mergeSort(array, 0, array.length-1);
	}	
	
	public void mergeSort(int[] array, int start, int end) {
		
		if (start < end) {
			
			int middle = (int) Math.floor((start + end) / 2);
			
			mergeSort(array, start, middle);
			
			mergeSort(array, middle + 1, end);
			
			merge(array, start, middle, end);
		}
	}
	
	public void merge(int[] array, int start, int middle, int end) {
		
		int lLength = middle + 1 - start;
		
		int rLength = end - middle;
		
		int[] leftArray = new int[lLength];
		
		int[] rightArray = new int[rLength];
		
		for (int i = 0; i < lLength; i++) {
			leftArray[i] = array[start + i]; 
		}
		
		for (int j = 0; j < rLength; j++) {
			rightArray[j] = array[ middle + 1 + j]; 
		}
		
		int i = 0;				
		int j = 0;
		
		for (int pointer = start; pointer <= end; pointer++) {
			
			if ((j >= rLength) || (i < lLength && leftArray[i] <= rightArray[j])) {
				array[pointer] = leftArray[i];
				i++;
			} else {
				array[pointer] = rightArray[j];
				j++;
			}
		}
	}
}
