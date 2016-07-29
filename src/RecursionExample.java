import java.util.Scanner;

public class RecursionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num < 0)
			System.out.println("Enter a number greater than or equal to 0");
		else
			System.out.println(factorial(num));
		
		sc.close();
	}
	
	private static long factorial(int num) {
		if(num > 1)
			return factorial(num - 1) * num;
		else
			return 1;
	}
}
