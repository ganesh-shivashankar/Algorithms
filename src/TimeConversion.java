import java.util.*;
import java.util.regex.*;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		String regex = "(1[012]|[0][1-9]):[0-5][0-9]:[0-5][0-9](AM|PM)";
		Pattern pattern = Pattern.compile(regex);

		String inputDateTime = input.next();
		Matcher matcher = pattern.matcher(inputDateTime);

		input.close();		
		
		if(!matcher.matches())
			System.out.println("Input date format is wrong. It should be hh:mm:ssAM or hh:mm:ssPM");
		else
		{
			if(inputDateTime.substring(8).equals("PM"))
			{
				String time = inputDateTime.substring(0, 2);
				int hour = Integer.parseInt(time) + 12;
				
				String militaryTime = Integer.toString(hour);
				militaryTime = militaryTime.concat(inputDateTime.substring(2,8));
				
				System.out.println(militaryTime);
			}				
			else
			{
				String time = inputDateTime.substring(0,2);
				if(time.equals("12"))
				{
					String militaryTime = "00";
					militaryTime = militaryTime.concat(inputDateTime.substring(2,8));
					
					System.out.println(militaryTime);
				}
				else
				{				
					System.out.println(inputDateTime.substring(0,8));
				}
			}
		}
	}

}
