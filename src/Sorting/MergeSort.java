package Sorting;
import java.util.Scanner;

public class MergeSort {

	private static int[] merge(int[] arr1, int arr2[])
	{
		int[] mergedArr = new int[arr1.length + arr2.length];
		
		int i = 0, j = 0, k = 0;
		while(k < (arr1.length + arr2.length))
		{
			if(i == arr1.length)
			{
				for(int p = j; p < arr2.length; p++)
					mergedArr[k++] = arr2[p];
				continue;
			}
			
			if(j == arr2.length)
			{
				for(int p = i; p < arr1.length; p++)
					mergedArr[k++] = arr1[p];
				continue;
			}
			
			if(arr1[i] < arr2[j])
				mergedArr[k++] = arr1[i++];
			else if(arr1[i] > arr2[j])
				mergedArr[k++] = arr2[j++];
			else
			{
				mergedArr[k++] = mergedArr[k+1] = arr1[i];
				k += 2;
			}
		}
		
		return mergedArr;
	}
	
	private static int[] mergeSort(int[] arr)
	{
		if((arr == null) || (arr.length == 0))
			return arr;
		
		if(arr.length == 1)
			return arr;
		
		int[] arr1 = new int[arr.length / 2];
		int[] arr2 = new int[arr.length - arr1.length];
		
		for(int i = 0; i < arr1.length; i++)
			arr1[i] = arr[i];
		
		for(int i = 0; i < arr2.length; i++)
			arr2[i] = arr[i + arr1.length];
		
		int[] sortedArr1 = mergeSort(arr1);
		int[] sortedArr2 = mergeSort(arr2);
		
		return merge(sortedArr1, sortedArr2);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = input.nextInt();
		
		input.close();
		
		int[] sortedArr = mergeSort(arr);
		
		for(int i = 0; i < n; i++)
			System.out.print(sortedArr[i] + " ");
	}
}
