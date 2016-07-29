package cci;

//class Node
//{
//	int data;
//	Node left;
//	Node right;
//	
//	Node(int i)
//	{
//		data = i;
//		left = null;
//		right = null;
//	}
//}

class RetVal
{
	boolean n1_Found;
	boolean n2_Found;
	Node node;
}

public class TreeFirstCommonAncestor 
{
	private static RetVal findFirstAncestor(Node n1, Node n2, Node root, boolean n1Found, boolean n2Found)
	{
		return null;
	}
	
	private static void printAncestor(Node root, Node n1, Node n2)
	{
		String node1 = (n1 == null) ? "NULL" : String.valueOf(n1.data);
		String node2 = (n2 == null) ? "NULL" : String.valueOf(n2.data);
		String rootNode = (root == null) ? "NULL" : String.valueOf(root.data);
		
		String ancestor = rootNode;
		
		System.out.println("Root Node : " + rootNode + ". First common ancestor of " + node1 + " and " + node2 + " is " + ancestor);
	}
	
	public static void main(String[] args) 
	{
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3); n1.left = n2; n1.right = n3;
		Node n4 = new Node(8); n2.left = n4;
		Node n5 = new Node(4);
		Node n6 = new Node(5); n3.left = n5; n3.right = n6;
		Node n7 = new Node(9);
		Node n8 = new Node(10); n4.left = n7; n4.right = n8;
		Node n9 = new Node(6);
		Node n10 = new Node(7); n5.left = n9; n5.right = n10;
		
		printAncestor(n1, n9, n6);		
		printAncestor(n1, n5, n4);		
		printAncestor(n1, n4, n2);		
		printAncestor(n1, n2, new Node(20));		
		printAncestor(n1, new Node(-1), n6);		
		printAncestor(n1, new Node(100), new Node(200));		
		printAncestor(n1, null, null);		
		printAncestor(n1, n6, null);		
		printAncestor(n1, null, n10);		
		printAncestor(n1, n5, n1);		
		printAncestor(n1, null, new Node(50));		
		printAncestor(null, n5, n6);		
		printAncestor(n1, n2, n2);
	}
}
