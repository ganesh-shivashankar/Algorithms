package Tree;
import java.util.Scanner;

class BSTNode
{
	BSTNode left;
	BSTNode right;
	int data;
	
	BSTNode(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinarySearchTree 
{
	public static int getHeight(BSTNode root){
        if(root == null)
			return 0;
        
        int nodeCount = getMaxNodeCount(root);
        return (nodeCount - 1);
    }

    private static int getMaxNodeCount(BSTNode root){
        if(root == null)
			return 0;
        
		int leftHeight = getMaxNodeCount(root.left);
		int rightHeight = getMaxNodeCount(root.right);
		
		return ((leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1));
    }
    
    //lowest common ancestor - lca
    private static BSTNode lca(BSTNode root, int v1, int v2) {
    	if(root == null)
    		return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (root.data > v1 && root.data > v2)
	        return lca(root.left, v1, v2);
	
	    // If both n1 and n2 are greater than root, then LCA lies in right
	    if (root.data < v1 && root.data < v2)
	        return lca(root.right, v1, v2);
		
		return root; 
    }
	
   
    
    
	public static BSTNode insert(BSTNode root, int data)
	{
		if(root == null)
			return new BSTNode(data);
		
		BSTNode cur;
		if(data <= root.data)
		{
			cur = insert(root.left, data);
			root.left = cur;
		}
		else
		{
			cur = insert(root.right, data);
			root.right = cur;
		}
		return root;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		BSTNode root = null;
		while(T-- > 0)
		{
			int data = sc.nextInt();
			root = insert(root, data);
		}
		//int height = getHeight(root);
		//System.out.println(height);
		
		BSTNode n = lca(root, sc.nextInt(), sc.nextInt());
		System.out.println(n.data);
		
		sc.close();
	}
}
