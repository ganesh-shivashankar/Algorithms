import java.util.HashMap;

class ParseString
{
	String firstRepeatedWord(String s)
	{
	    String[] split = s.split("[,:;\\-.\\s]+");
	    HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < split.length; i++)
		{	
			Object o = map.put(split[i], 0);
			if(o != null)
				return split[i];
		}		
		return null;
	}
}

class MergeArray
{
	int[] mergeArrays(int[] a, int[] b)
	{
		if((a.length == 0) && (b.length == 0))
			return new int[0];
			
		if(a.length == 0) 
			return b;
		
		if(b.length == 0)
			return a;
		
		int[] result = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;

		while(k < (a.length + b.length))
		{
			if(i == a.length)
			{
				for(int x = j; x < b.length; x++)
					result[k++] = b[j++];
				continue;
			}
			
			if(j == b.length)
			{
				for(int x = i; x < a.length; x++)
					result[k++] = a[i++];
				continue;
			}
				
			if(a[i] < b[j])
				result[k++] = a[i++];
			else if(a[i] > b[j])
				result[k++] = b[j++];
			else
			{
				result[k++] = a[i++];
				result[k++] = b[j++];
			}
		}
				
		return result;
	}
}

class KCandy
{
	public int distributeCandy(int[] students)
	{
		int[] candies = new int[students.length];
		
		int i = 0;
		candies[i++] = 1;
		
		while(i < students.length)
		{
			if(students[i] < students[i-1])
			{
				for(int j = i-1; j >= 0; j--)
				{
					if(students[j] < students[j-1])
					    candies[j]++;
					else
						break;					
				}
				candies[i] = 1;
				i++;
			}
			else if (students[i] > students[i-1])
			{
				candies[i] = candies[i-1] + 1;
				i++;
			}
			else
			{
				if(students[i-1] > 1)
					candies[i] = 1;
				else
					candies[i] = candies[i-1] + 1;
				i++;
			}
		}
		
		int result = 0;
		for(int j = 0; j < candies.length; j++)
			result += candies[j];
		
		return result;
	}	
}

public class FirstRepeatedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "He had had  First-first.name";
		ParseString parseString = new ParseString();
		String repeated = parseString.firstRepeatedWord(input);		
		if(repeated == null)
			System.out.println("No repeated string");
		else
			System.out.println("First repeated string : " + repeated);
		
		//int[] a = new int[]{2, 4, 5, 9, 9};
		//int[] b = new int[]{0, 1, 2, 3, 4};		
		int[] a = new int[]{1,5,7,7};
		int[] b = new int[]{0,1,2,3};		
		MergeArray merge = new MergeArray();
		int[] c = merge.mergeArrays(a, b);		
		for(int i=0; i < c.length; i++)
			System.out.print(c[i] + " ");
		System.out.println();
		
		//int[] students = new int[]{1, 2, 2};
		int[] students = new int[]{2,4,2,6,1,7,8,9,2,1};
		KCandy candyCalc = new KCandy();
		int total = candyCalc.distributeCandy(students);		
		System.out.println("Total candies : " + total);
	}	

}
