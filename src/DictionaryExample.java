import java.util.*;

public class DictionaryExample {

	public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Map<String, Integer> phoneBook = new HashMap<String, Integer>();        
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name, phone);
        }
        
        ArrayList<String> names = new ArrayList<String>();
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            names.add(s);
        }
        
        in.close();
        
        for(int i = 0; i < names.size(); i++) {
            Object number = phoneBook.get(names.get(i));
            if(number == null)
                System.out.println("Not found");
            else
                System.out.println(names.get(i) + "=" + number);
        } 
	}
}
