import java.util.*;
import java.util.regex.*;

public class RegexExample {

	//alice alice@alicegmail.com
	//alice alice@gmail.com
	//alice gmail.alice@gmail.com
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        ArrayList list = new ArrayList<String>();
        //Map map = new HashMap<String, String>();
                
        for(int i = 0; i < num; i++)
        {
            String name = sc.next();
            String email = sc.next();

            if((name.length() > 20) || (email.length() > 50))
            	continue;

            Pattern namePattern = Pattern.compile("^[a-z.@]+$");
            Matcher nameMatcher = namePattern.matcher(name);
            if(!nameMatcher.find())
            	continue;

            Pattern emailPattern = Pattern.compile("^[a-z.@]+@gmail.com$");
            Matcher emailMatcher = emailPattern.matcher(email);
            if(!emailMatcher.find())
            	continue;
            
            //save value
            list.add(name);
            //map.put(name, email);
        }
        
        sc.close();
        
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++)
        	System.out.println(list.get(i));
	}

}
