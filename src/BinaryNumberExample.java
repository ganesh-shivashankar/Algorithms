import java.util.*;

public class BinaryNumberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int rem = 0;
		sc.close();
		
		if(num <= 1) {
			System.out.println(num);
			return;
		}
		
		int high_count = 0;
		int curr_count = 0;
		while(num > 0)
		{
			rem = num % 2;
			num = num / 2;
			
			if(rem == 1)
				curr_count++;
			else
				curr_count = 0;
			
			if(curr_count > high_count)
				high_count = curr_count;
		}
		
		System.out.println(high_count);
	}

}
