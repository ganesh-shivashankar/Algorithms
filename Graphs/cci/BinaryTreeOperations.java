package cci;

import java.util.*;

public class BinaryTreeOperations 
{
	//Compare the heights of left and right subtrees. If height > 1, return -1, else return the actual value (0/1)
	private static int checkHeight(Node root, int parentHeight)
	{
		if((root == null) || ((root.left == null) && (root.right == null)))
			return 0;
		
		int h1 = checkHeight(root.left, parentHeight + 1);
		if(h1 < 0)
			return -1;
		
		int h2 = checkHeight(root.right, parentHeight + 1);
		if(h2 < 0)
			return -1;
		
		if(Math.abs(h1 - h2) > 1)
			return -1;
		else
			return (parentHeight + 1);
	}
	
	//Check if a tree is balanced. i.e. the difference in the left and right subtree of any node is greater than 1
	private static boolean checkBalanced(Node root)
	{
		if (checkHeight(root, -1) < 0)
			return false;
		else
			return true;
	}
	
	//-----------------------------------------------------------------------
	
	private enum CheckTree
	{
		NONE,
		SMALLER,
		LARGER
	};	
	
	//Check if the binary tree is a binary search tree
	private static boolean checkIfBinarySearchTree(Node root, int parentNodeValue, CheckTree checkType)
	{
		if(root == null)
			return true;
		
		if((root.left == null) && (root.right == null))
		{
			switch(checkType)
			{
			case NONE:
				return true;
			case SMALLER:
				if(root.data < parentNodeValue)
					return true;
				else
					return false;
			case LARGER:
				if(root.data > parentNodeValue)
					return true;
				else
					return false;
			}
		}

		boolean b1 = checkIfBinarySearchTree(root.left, root.data, CheckTree.SMALLER);
		if(!b1)
			return false;
		
		boolean b2 = checkIfBinarySearchTree(root.right, root.data, CheckTree.LARGER);
		if(!b2)
			return false;
		
		return true;
	}
	
	//-----------------------------------------------------------------------
	
	private static Node BFS(Node root, int value)
	{
		Node n = null;
		boolean found = false;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			n = queue.remove();
			if(n.data == value)
			{
				found = true;
				break;
			}
			
			if(n.left != null)
				queue.add(n.left);
			if(n.right != null)
				queue.add(n.right);
		}
		
		if(found)
			return n;
		else
			return null;
	}
	
	//check if 'subTree' is found in 'mainTree'
	private static boolean checkIfSubTreeFound(Node mainTree, Node subTree)
	{
		if(subTree == null)
			return false;
		else if(mainTree == null)
			return false;
		
		Node n = BFS(mainTree, subTree.data);
		
		if(n == null)
			return false;
		else
		{
			LinkedList<Node> queue1 = new LinkedList<Node>();
			queue1.add(n);
			
			LinkedList<Node> queue2 = new LinkedList<Node>();
			queue2.add(subTree);
			
			while(!queue1.isEmpty())
			{
				Node mainTreeNode = queue1.remove();
				Node subTreeNode = queue2.remove();
				
				if((subTreeNode == null) || (mainTreeNode.data != subTreeNode.data))
					return false;
				
				if(mainTreeNode.left != null)
				{
					queue1.add(mainTreeNode.left);
					queue2.add(subTreeNode.left);
				}
				else if(subTreeNode.left != null)
					return false;
				
				if(mainTreeNode.right != null)
				{
					queue1.add(mainTreeNode.right);
					queue2.add(subTreeNode.right);
				}
				else if(subTreeNode.right != null)
					return false;
			}
		}
		
		return true;
	}	

	//-----------------------------------------------------------------------	
	
	public static void main(String[] args) 
	{
		Node tree1 = new Node(1);
		tree1.left = new Node(2);
		tree1.left.left = new Node(4);
		tree1.left.left.left = new Node(8);
		tree1.left.left.right = new Node(9);
		tree1.left.right = new Node(5);		
		tree1.right = new Node(3);
		tree1.right.left = new Node(6);
		tree1.right.right = new Node(7);
		
		if(checkBalanced(tree1))
			System.out.println("tree1 : Balanced binary tree");
		else
			System.out.println("tree1 : Unbalanced binary tree");
		
		if(checkIfBinarySearchTree(tree1, -1, CheckTree.NONE))
			System.out.println("tree1 : Binary search tree");
		else
			System.out.println("tree1 : Not a binary search tree");
		
		System.out.println("----------------------------------");
		
		Node tree2 = new Node(17);
		tree2.left = new Node(11);
		tree2.left.right = new Node(15);
		tree2.left.right.right = new Node(16);
		tree2.right = new Node(21);
		tree2.right.right = new Node(24);
		tree2.right.right.left = new Node(23);
		tree2.right.right.right = new Node(25);
		tree2.right.right.right.right = new Node(26);
		
		if(checkBalanced(tree2))
			System.out.println("tree2 : Balanced binary tree");
		else
			System.out.println("tree2 : Unbalanced binary tree");
		
		if(checkIfBinarySearchTree(tree2, -1, CheckTree.NONE))
			System.out.println("tree2 : Binary search tree");
		else
			System.out.println("tree2 : Not a binary search tree");
		
		System.out.println("----------------------------------");
		
		Node tree3 = new Node(20);
		tree3.left = new Node(18);
		tree3.left.left = new Node(16);
		tree3.right = new Node(23);
		tree3.right.left = new Node(21);
		tree3.right.right = new Node(25);
		if(checkBalanced(tree3))
			System.out.println("tree3 : Balanced binary tree");
		else
			System.out.println("tree3 : Unbalanced binary tree");
		
		if(checkIfBinarySearchTree(tree3, -1, CheckTree.NONE))
			System.out.println("tree3 : Binary search tree");
		else
			System.out.println("tree3 : Not a binary search tree");
		
		System.out.println("----------------------------------");
		
		Node subTree1 = new Node(24);
		subTree1.left = new Node(23);
		subTree1.right = new Node(25);
		if(checkIfSubTreeFound(tree2, subTree1))
			System.out.println("SubTree1 is part of Tree2");
		else
			System.out.println("SubTree1 is not part of Tree2");
		
		Node subTree2 = new Node(24);
		subTree2.left = new Node(22);
		subTree2.right = new Node(25);		
		if(checkIfSubTreeFound(tree2, subTree2))
			System.out.println("SubTree2 is part of Tree2");
		else
			System.out.println("SubTree2 is not part of Tree2");
		
		tree1.left.right = new Node(5);		
		tree1.right = new Node(3);
		tree1.right.left = new Node(6);
		tree1.right.right = new Node(7);		
		
		Node subTree3 = new Node(7);
		subTree3.left = new Node(6);
		subTree3.right = new Node(7);
		if(checkIfSubTreeFound(tree1, subTree3))
			System.out.println("SubTree3 is part of Tree1");
		else
			System.out.println("SubTree3 is not part of Tree1");		
	}
}
