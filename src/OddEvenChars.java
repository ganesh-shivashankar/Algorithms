import java.util.*;
import java.util.Scanner;
import java.io.*;

public class OddEvenChars {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		String s;
		
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < num; i++)
		{
			s = sc.next();
			if((s != null) && (s.length() != 0))
				strings.add(s);
		}
				
		for(int i = 0; i < num; i++)
		{
			char[] c_arr = strings.get(i).toCharArray();
			
			StringBuffer b1 = new StringBuffer();
			StringBuffer b2 = new StringBuffer();
			
			for(int j = 0; j < c_arr.length; j += 2)
				b1.append(c_arr[j]);

            for(int j = 1; j < c_arr.length; j += 2)
				b2.append(c_arr[j]);

            System.out.println(b1.toString() + " " + b2.toString());
		}
        
		sc.close();
	}
}
