import java.util.ArrayList;
import java.util.Scanner;

public class BitOperationExample {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 int num = sc.nextInt();
		 
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		 for(int i = 0; i < num; i++){
			 int n = sc.nextInt();
			 int k = sc.nextInt();
			 
			 int andResult = 0;
			 for(int p = 1; p <= n-1; p++){
				 for(int q = p + 1; q <= n; q++){
					 int r = p & q;
					 if ((r > andResult) && (r < k))
						 andResult = p & q;
				 }				 
			 }
			 
			 result.add(andResult);
		 }
		 
		 for(int i = 0; i < result.size(); i++)
			 System.out.println(result.get(i));
		 
		 sc.close();
	}

}
