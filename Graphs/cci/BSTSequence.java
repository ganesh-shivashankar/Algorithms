package cci;
import java.util.*;

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

public class BSTSequence 
{
	//Append one linked list to another linked list
	private static LinkedList<Node> appendList(LinkedList<Node> list1, LinkedList<Node> list2)
	{
		LinkedList<Node> joinedList = new LinkedList<Node>();
		
		for(int i = 0; i < list1.size(); i++)
			joinedList.add(list1.get(i));
		
		for(int j = 0; j < list2.size(); j++)
			joinedList.add(list2.get(j));
		
		return joinedList;
	}

	//Weave the linked lists to get all combinations
	private static ArrayList<LinkedList<Node>> weaveLists(Node root, 
			ArrayList<LinkedList<Node>> AL1, 
			ArrayList<LinkedList<Node>> AL2)
	{
		ArrayList<LinkedList<Node>> A = new ArrayList<LinkedList<Node>>();
		
		//prepend 'root' to 'AL1' linked lists
		ArrayList<LinkedList<Node>> X = new ArrayList<LinkedList<Node>>();
		for(int i = 0; i < AL1.size(); i++)
		{
			LinkedList<Node> firstList = new LinkedList<Node>();
			firstList.add(root);			
			LinkedList<Node> secondList = AL1.get(i);

			LinkedList<Node> appendedList = appendList(firstList, secondList);
			X.add(appendedList);
		}
		
		//for each 'AL1' linked-list, append each of 'AL2' linked list to get all combinations
		if(AL2.size() > 0)
		{			
			for(int i = 0; i < X.size(); i++)
			{
				LinkedList<Node> firstList = X.get(i);
				for(int j = 0; j < AL2.size(); j++)
				{
					LinkedList<Node> secondList = AL2.get(j);
					LinkedList<Node> appendedList = appendList(firstList, secondList);
					A.add(appendedList);
				}
			}
		}
		else
		{
			//if the 2nd linked list does not exist, append just the first list
			for(int i = 0; i < X.size(); i++)
				A.add(X.get(i));
		}
		
		return A;
	}
	
	//Recursive method to generate all the sequences
	private static ArrayList<LinkedList<Node>> generateSequence(Node root)
	{
		if(root == null)
		{
			//return empty/blank list
			return new ArrayList<LinkedList<Node>>();
		}
		
		ArrayList<LinkedList<Node>> AL1 = generateSequence(root.left);
		ArrayList<LinkedList<Node>> AL2 = generateSequence(root.right);
		
		ArrayList<LinkedList<Node>> A = new ArrayList<LinkedList<Node>>();
		
		if(AL1.size() > 0)
		{
			ArrayList<LinkedList<Node>> X1 = weaveLists(root, AL1, AL2);
			for(int i = 0; i < X1.size(); i++)
				A.add(X1.get(i));
		}
		
		if(AL2.size() > 0)
		{
			ArrayList<LinkedList<Node>> X2 = weaveLists(root, AL2, AL1);
			for(int i = 0; i < X2.size(); i++)
				A.add(X2.get(i));
		}
		
		if((AL1.size() == 0) && (AL2.size() == 0))
		{
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(root);
			A.add(list);
		}
		
		return A;
	}	
	
	//Print all sequences
	private static void findAllSequences(Node root)
	{
		ArrayList<LinkedList<Node>> sequenceList = generateSequence(root);
		
		if(sequenceList.size() == 0)
		{
			System.out.println("None");
			return;
		}
		
		for(int i = 0; i < sequenceList.size(); i++)
		{
			LinkedList<Node> list = sequenceList.get(i);
			for(int j = 0; j < list.size(); j++)
				System.out.print(list.get(j).data + " ");
			System.out.println();
		}		
	}
	
	public static void main(String[] args) 
	{
		findAllSequences(null);
		
		System.out.println("----------------------------------------");
		
		Node n = new Node(5);
		findAllSequences(n);
		
		System.out.println("----------------------------------------");
		
		Node n1 = new Node(2);		
		Node n2 = new Node(1); n1.left = n2;		
		Node n3 = new Node(10); n1.right = n3;
		Node n4 = new Node(4); n3.left = n4;
		Node n5 = new Node(12); n3.right = n5;
		findAllSequences(n1);
		
		System.out.println("----------------------------------------");
		
		Node x1 = new Node(50);
		Node x2 = new Node(20);
		Node x3 = new Node(60); x1.left = x2; x1.right = x3;
		Node x4 = new Node(10);
		Node x5 = new Node(25); x2.left = x4; x2.right = x5;
		Node x6 = new Node(70); x3.right = x6;
		Node x7 = new Node(5);
		Node x8= new Node(15); x4.left = x7; x4.right = x8;
		Node x9 = new Node(65);
		Node x10 = new Node(80); x6.left = x9; x6.right = x10;
		findAllSequences(x1);
		
	}
}
