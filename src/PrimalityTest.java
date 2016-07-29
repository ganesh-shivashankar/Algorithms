import java.util.Scanner;

public class PrimalityTest {

	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] numbers = new int[size];
		
		for(int i = 0; i < size; i++)
			numbers[i] = sc.nextInt();
		
        sc.close();
        
        for(int i = 0; i < size; i++)
        {
        	boolean isPrime = true;
        	int root = (int)Math.sqrt(numbers[i]);
            
            if(numbers[i] == 1)
                isPrime = false;
            else
            {
                while(root > 1)
                {
                    if((numbers[i] % root) == 0)
                    {
                        isPrime = false;
                        break;
                    }

                    //if(((root % 2) == 0) && (root != 2))
                        root --;
                    //else
                    //	root -= 2;
                }
            }
        	if(isPrime)
        		System.out.println("Prime");
        	else
        		System.out.println("Not prime");
        }
	}
}
