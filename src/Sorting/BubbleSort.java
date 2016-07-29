package Sorting;
import java.util.Scanner;

public class BubbleSort {

	private static int numSwaps = 0;
	
	private static int[] bubbleSort(int[] input) {
		for(int i = 0; i < input.length; i++){
			int swps = 0;
			
			for(int j = 0; j < input.length-1; j++) {
				if(input[j] > input[j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
					swps++;
				}
			}
			
			numSwaps += swps;
			
			if(swps == 0)
				break;
		}
		return input;
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] input = new int[num];
		for(int i = 0; i < num; i++)
			input[i] = sc.nextInt();
		
		sc.close();
		
		int[] result = bubbleSort(input);
		
		System.out.println("Array is sorted in " + numSwaps + " swaps.");
		System.out.println("First Element: " + result[0]);
		System.out.println("Last Element: " + result[num-1]);
	}

}
