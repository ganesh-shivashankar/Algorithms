package cci;

class TreeNode
{
	int data;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		data = x;
	}
}

//----Main logic----
//InOrderSuccessor(Node n)
//	if(n has right-child-tree)
//		return the left-most-node of right-child-tree
//	else
//		while(n is its parent's right-child)
//			move 1 node up
//		return n.parent

public class InOrderSuccessor 
{
	private static TreeNode leftMostNode(TreeNode n)
	{
		if(n == null)
			return null;
		
		TreeNode node = n;
		while(node.left != null)
			node = node.left;
		
		return node;
	}
	
	//Find 'next' in-order successor node of a given node in a Binary Search Tree
	private static void inOrderSuccessor(TreeNode node)
	{
		if(node == null)
		{
			System.out.println("none");
			return;
		}

		//if (node has right-child-tree)
		if(node.right != null)
		{
			//return the left-most node of the right-child-tree
			System.out.println(node.data + " -> " + leftMostNode(node.right).data);
		}
		else
		{
			TreeNode n = node;

			//while(node is its parent's right child)
			while(n.parent.right == n)
			{
				//move one node up
				n = n.parent;
				if(n.parent == null)
					break;
			}
						
			//return node's parent
			if(n.parent == null)
				System.out.println(node.data + " -> " + "none");
			else
				System.out.println(node.data + " -> " + n.parent.data);
		}
	}
	
	public static void main(String[] args) 
	{
		//       10
		//   8         15
		// 6   9    12    18
		
		TreeNode node1 = new TreeNode(10);
		
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(9);
		
		node2.parent = node1;
		node2.left = node3;
		node2.right = node4;
		
		node3.parent = node2;
		node4.parent = node2;
		
		TreeNode node5 = new TreeNode(15);
		TreeNode node6 = new TreeNode(12);
		TreeNode node7 = new TreeNode(18);
		
		node5.parent = node1;
		node5.left = node6;
		node5.right = node7;
		
		node6.parent = node5;
		node7.parent = node5;
		
		node1.left = node2;
		node1.right = node5;
		
		inOrderSuccessor(null); //none
		inOrderSuccessor(node3); //6 -> 8
		inOrderSuccessor(node2); //8 -> 9
		inOrderSuccessor(node4); //9 -> 10
		inOrderSuccessor(node1); //10 -> 12
		inOrderSuccessor(node6); //12 -> 15
		inOrderSuccessor(node5); //15 -> 18
		inOrderSuccessor(node7); //18 -> none
	}
}
