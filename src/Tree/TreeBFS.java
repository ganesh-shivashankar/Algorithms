package Tree;
import java.util.*;
import java.io.*;

class BFSNode
{
    BFSNode left,right;
    int data;
    
    BFSNode(int data)
    {
        this.data=data;
        left = right = null;
    }
}

public class TreeBFS {

	static void levelOrder(BFSNode root)
	{
		if(root == null)
			return;
		
	    LinkedList<BFSNode> queue = new LinkedList<BFSNode>();
	      
	    queue.add(root);
	    while(!queue.isEmpty())
	    {
	    	BFSNode n = queue.removeLast();
	    	if(n.left != null)
	    		queue.addFirst(n.left);
	    	if(n.right != null)
	    		queue.addFirst(n.right);
	    	
	    	System.out.println(n.data + " ");
	    }
	}
	
	public static BFSNode insert(BFSNode root, int data)
	{
        if(root == null)
        {
            return new BFSNode(data);
        }
        else
        {
            BFSNode cur;
            if(data <= root.data)
            {
                cur = insert(root.left, data);
                root.left = cur;
            }
            else
            {
                cur = insert(root.right,data);
                root.right = cur;
            }
            return root;
        }
    }	
	
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        BFSNode root=null;
        
        while(T-- > 0)
        {
            int data = sc.nextInt();
            root = insert(root,data);
        }
        levelOrder(root);
        
        sc.close();
	}
}
