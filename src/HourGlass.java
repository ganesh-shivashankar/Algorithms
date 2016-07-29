import java.util.Scanner;

public class HourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }        
        in.close();
        
        boolean isFirst = true;
        int maxValue = 0;
        for(int i = 0; i < 4; i++) 
        {
        	for(int j = 0; j < 4; j++)
        	{
        		int hourSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
        		
        		if(isFirst)
        		{
        			isFirst = false;
        			maxValue = hourSum;
        		}
        		
        		if(hourSum > maxValue)
        			maxValue = hourSum;
        	}
        }
        
        System.out.println(maxValue);
	}
}
