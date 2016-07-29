package Sorting;

import java.util.*;

class Sort {
	
	private int[] arr;
	
	public int[] getSortedArr() {
		return arr;
	}
	
	Sort(int[] unsorted_arr) {
		arr = unsorted_arr;
	}
	
	public void sort() {
		quickSort(0, arr.length-1);
	}
	
	private void quickSort(int lowIndex, int highIndex) {
		int i = lowIndex;
		int j = highIndex;
		
		int pivot = arr[lowIndex + (highIndex - lowIndex)/2];
		
		while(i <= j) {
			while(arr[i] < pivot)
				i++;
			
			while(arr[j] > pivot)
				j--;
			
			if(i <= j) {
				exchangeNumbers(i, j);
				i++;
				j--;
			}
		}
		
		if(lowIndex < j)
			quickSort(lowIndex, j);
		
		if(highIndex > i)
			quickSort(i, highIndex);
	}
	
	private void exchangeNumbers(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = input.nextInt();
		
		input.close();

		Sort sorter = new Sort(arr);
		sorter.sort();
		
		int[] sortedArr = sorter.getSortedArr();
		for(int i = 0; i < sortedArr.length; i++)
			System.out.print(sortedArr[i] + " ");
	}

}
