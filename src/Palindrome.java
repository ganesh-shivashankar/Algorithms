import java.util.Scanner;

public class Palindrome {

	static boolean checkPalindrome(String inputString) 
	{
		if((inputString == null) || (inputString.length() == 0) || (inputString.length() == 1))
			return true;
		
		char firstChar = inputString.charAt(0);
		char lastChar = inputString.charAt(inputString.length() - 1);
		
		if(firstChar != lastChar)
			return false;
		else
			checkPalindrome(inputString.substring(1, inputString.length() - 2));
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		String inputString = input.nextLine();
			
		input.close();
		
		System.out.println(checkPalindrome(inputString));
	}

}
