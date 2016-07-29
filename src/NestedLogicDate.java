import java.io.*;
import java.util.*;

public class NestedLogicDate 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int rDay = sc.nextInt();
		int rMonth = sc.nextInt(); 
		int rYear = sc.nextInt();
		
		int eDay = sc.nextInt();
		int eMonth = sc.nextInt();
		int eYear = sc.nextInt();
		
		sc.close();
		
		int diffYear = rYear - eYear;
		int diffMonth = rMonth - eMonth;
		int diffDay = rDay - eDay;
		
		int fine = 0;
		
		if(diffYear > 0)
			fine = 10000;
		else if(diffMonth > 0)
			fine = diffMonth * 500;
		else if(diffDay > 0)
			fine = diffDay * 15;
		
		System.out.println(fine);
		System.out.println("a");
		System.out.println('b');
		
		String s;
		
	}
}
