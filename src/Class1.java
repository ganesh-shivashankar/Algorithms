
class Node {
	int data;
	Node next;
}

public class Class1 {

	public static void main(String[] args) 
	{		
		System.out.println("Inserting Nodes - 1, 2, 3 to an empty linked list");
		
		Node head = insertAtEnd(null, 1);
		head = insertAtEnd(head, 2);
		head = insertAtEnd(head, 3);
		
		printNodes(head);
	}

	private static Node insertAtEnd(Node head, int data)
	{
		if(head == null)
		{
			Node node = new Node();
			node.data = data;
			head = node;
		}
		else
		{
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			
			Node node = new Node();
			node.data = data;
			
			temp.next = node;
		}
		return head;
	}	
	
	private static void printNodes(Node head)
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data + " ->");
			temp = temp.next;
		}
	}
}
