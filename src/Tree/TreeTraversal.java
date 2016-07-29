package Tree;

import java.util.LinkedList;

public class TreeTraversal 
{
	class Node 
	{
	    int data;
	    Node left;
	    Node right;
	}
	
	public void LevelOrder(Node root) //breadth-first traversal
	{
		if(root == null)
			return;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()) 
		{
			Node n = queue.removeFirst();
			
			if(n.left != null)
				queue.add(n.left);
			if(n.right != null)
				queue.add(n.right);
			
			System.out.print(n.data + " ");
		}
	}
	
	public void DepthFirstTraversal(Node root)
	{
		if(root == null)
			return;
		
		System.out.println(root.data + " ");
		
		if(root.left != null)
			DepthFirstTraversal(root.left);
		
		if(root.right != null)
			DepthFirstTraversal(root.right);
	}
	
	public void preOrder(Node root) {
		if(root == null)
			return;
		
		//process current node
		System.out.print(root.data + " ");
		
		//process left sub-tree
		if(root.left != null)
			preOrder(root.left);
			
		//process right sub-tree
		if(root.right != null)
			preOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if(root == null)
			return;
		
		//process left subtree
		if(root.left != null)
			postOrder(root.left);
		
		//process right subtree
		if(root.right != null)
			postOrder(root.right);
		
		//process current node
		System.out.print(root.data + " ");		
	}
	
	public void inOrder(Node root) {
		if(root == null)
			return;
		
		//process left node
		if(root.left != null)
			inOrder(root.left);
		
		//process current node
		System.out.print(root.data + " ");
		
		//process right node
		if(root.right != null)
			inOrder(root.right);
	}
	
	public int findTreeLength(Node root) {
		if(root == null)
			return 0;
		
		if((root.left == null) && (root.right == null))
			return 0;
		
		int length = 1;
		
		//get left root length
		int left = 0;
		if(root.left != null)
			left = findTreeLength(root.left);
		
		//get right root length
		int right = 0;
		if(root.right != null)
			right = findTreeLength(root.right);
		
		if(left > right)
			length += left;
		else
			length += right;
		
		return length;
	}
}
