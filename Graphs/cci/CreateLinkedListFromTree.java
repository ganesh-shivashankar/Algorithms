package cci;

import java.util.*;

public class CreateLinkedListFromTree 
{
	private static ArrayList<LinkedList<Integer>> m_linkedLists = new ArrayList<LinkedList<Integer>>();
	
	private static void AddToLinkedList(Node root, int depth)
	{
		if(root != null)
		{
			if(m_linkedLists.size() < (depth+1))
				m_linkedLists.add(new LinkedList<Integer>());
			
			m_linkedLists.get(depth).add(root.data);
			AddToLinkedList(root.left, depth+1);
			AddToLinkedList(root.right, depth+1);
		}
	}
	
	private static void displayLists()
	{
		System.out.println("--------------------");
		for(int i = 0; i < m_linkedLists.size(); i++)
		{
			LinkedList<Integer> list = m_linkedLists.get(i);
			while(list.size() > 0)
				System.out.print(list.remove() + " -> ");
			System.out.println();
		}
	}
	
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
	
	public static void main(String[] args) 
	{
		int[] sortedArr1 = new int[]{1, 3, 4, 8, 8, 10};
		Node root1 = constructBST(sortedArr1, 0, sortedArr1.length-1);
		AddToLinkedList(root1, 0);
		displayLists();
		
		m_linkedLists.clear();
		int[] sortedArr2 = new int[]{1, 3, 4, 8, 9, 15};
		Node root2 = constructBST(sortedArr2, 0, sortedArr2.length-1);
		AddToLinkedList(root2, 0);
		displayLists();
		
		m_linkedLists.clear();
		int[] sortedArr3 = new int[]{1, 3, 4, 8, 8, 15, 16};
		Node root3 = constructBST(sortedArr3, 0, sortedArr3.length-1);
		AddToLinkedList(root3, 0);
		displayLists();
		
		m_linkedLists.clear();
		int[] sortedArr4 = new int[]{1, 3, 4, 8, 9, 15, 20};
		Node root4 = constructBST(sortedArr4, 0, sortedArr4.length-1);
		AddToLinkedList(root4, 0);
		displayLists();
	}
}
