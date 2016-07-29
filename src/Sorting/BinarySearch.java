package Sorting;

import java.util.*;

public class BinarySearch {
	
	private static boolean binarySearch(int[] arr, int searchKey) {
		if(arr.length == 0)
			return false;
		
		if((arr.length == 1) && (searchKey != arr[1]))
			return false;
		
		int low = 0;
		int high = arr.length - 1;
		
		while(high >= low) {
			int mid = (low + high) / 2;
			
			if(arr[mid] == searchKey)
				return true;
			
			if(arr[mid] < searchKey)
				low = mid + 1;
			
			if(arr[mid] > searchKey)
				high = mid - 1;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = input.nextInt();
		
		for(int i = 0; i < n-1; i++)
			for(int j = i+1; j < n; j++) {
				if(arr[i] > arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		
		int searchKey = input.nextInt();
		
		input.close();
		
		if(binarySearch(arr, searchKey))
			System.out.println("found");
		else
			System.out.println("not found");
	}

}
