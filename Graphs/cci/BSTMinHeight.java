package cci;

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int i)
	{
		data = i;
		left = null;
		right = null;
	}
}

public class BSTMinHeight 
{
	private static Node constructBST(int[] arr, int startIndex, int endIndex)
	{
		if((arr == null) || (arr.length == 0) || (startIndex > endIndex))
			return null;
		
		int mid = (startIndex + endIndex) / 2;
		
		Node root = new Node(arr[mid]);
		root.left = constructBST(arr, startIndex, mid-1);
		root.right = constructBST(arr, mid+1, endIndex);
		
		return root;
	}
	
	//print tree in in-order
	private static void printTree(Node root)
	{
		if(root != null)
		{
			printTree(root.left);
			System.out.print(root.data + " -> ");
			printTree(root.right);
		}
	}
	
	public static void main(String[] args)
	{
		int[] sortedArr1 = new int[]{1, 3, 4, 8, 8, 10};
		Node root1 = constructBST(sortedArr1, 0, sortedArr1.length-1);
		printTree(root1);
		System.out.println();
		
		int[] sortedArr2 = new int[]{1, 3, 4, 8, 9, 15};
		Node root2 = constructBST(sortedArr2, 0, sortedArr2.length-1);
		printTree(root2);
		System.out.println();
		
		int[] sortedArr3 = new int[]{1, 3, 4, 8, 8, 15, 16};
		Node root3 = constructBST(sortedArr3, 0, sortedArr3.length-1);
		printTree(root3);
		System.out.println();
		
		int[] sortedArr4 = new int[]{1, 3, 4, 8, 9, 15, 20};
		Node root4 = constructBST(sortedArr4, 0, sortedArr4.length-1);
		printTree(root4);
		System.out.println();
	}
}
