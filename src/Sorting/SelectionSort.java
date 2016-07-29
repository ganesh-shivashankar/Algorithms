package Sorting;
import java.util.Scanner;

public class SelectionSort {
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = input.nextInt();
		
		input.close();
		
		for(int i = 0; i < n-1; i++)
			for(int j = i+1; j < n; j++)
				if(arr[i] > arr[j])
				{
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
		
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
