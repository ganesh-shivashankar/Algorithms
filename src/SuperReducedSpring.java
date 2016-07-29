import java.util.*;

public class SuperReducedSpring
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        String inStr = input.nextLine();
        input.close();

        if((inStr == null) || (inStr.length() == 0))
        {
            System.out.println("Empty String");
            return;
        }

        StringBuilder output = new StringBuilder();
        output.append(inStr);

        boolean parseAgain = true;

        while(parseAgain)
        {
            parseAgain = false;

            String strToCheck = output.toString();
            char[] inArray = strToCheck.toCharArray();

            output.delete(0, output.length());

            int i = 0;
            while(i < strToCheck.length())
            {
                if(i == strToCheck.length()-1)
                {
                    output.append(inArray[i]);
                    i++;
                    continue;
                }

                if(inArray[i] == inArray[i+1])
                {
                    parseAgain = true;
                    i += 2;
                }
                else
                {
                    output.append(inArray[i]);
                    i++;
                }  
            }
        }


        if(output.length() == 0)
            System.out.println("Empty String");
        else
            System.out.println(output.toString());
    }
}
