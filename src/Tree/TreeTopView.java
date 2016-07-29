package Tree;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeTopView 
{
	public class Node
	{
		int data;
		Node left;
		Node right;
	}
	
	void top_view(Node root)
	{
		if(root == null)
			return;
		
		if((root.left == null) && (root.right == null)) 
		{
			System.out.println(root.data);
			return;
		}
		
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		
		tm = GetTopViewNodes(root, tm, 0);
		
		PrintTopView(tm);
	}
	
	TreeMap<Integer, Integer> GetTopViewNodes(Node root, TreeMap<Integer, Integer> tm, int horiz_level)
	{
		if(tm.get(horiz_level) == null)
			tm.put(horiz_level, root.data);
		
		if(root.left != null)
			tm = GetTopViewNodes(root.left, tm, horiz_level + 1);
		
		if(root.right != null)
			tm = GetTopViewNodes(root.right, tm, horiz_level - 1);
		
		return tm;
	}
	
	private void PrintTopView(TreeMap<Integer, Integer> tm)
	{
		Set set = tm.descendingKeySet();
		Iterator i = set.iterator();
		while(i.hasNext())
		{
			Map.Entry<Integer, Integer> me = (Map.Entry<Integer, Integer>)i.next();
			System.out.print(me.getValue() + " ");
		}		
	}

	public static void main(String[] args)
	{	
	}
}
