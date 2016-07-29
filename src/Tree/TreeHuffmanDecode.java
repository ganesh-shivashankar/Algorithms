package Tree;

class Node {
	int freq;
	char data;
	Node left;
	Node right;
}

public class TreeHuffmanDecode {

	public static void decode_huff(String S, Node root)  {
		if((root == null) || S.isEmpty())
			return;
				
		Node curr = root;
		char[] encodedStr = S.toCharArray();	
		
		StringBuilder decodedStr = new StringBuilder();
		
		int i = 0;
		while(i <= encodedStr.length) {
			if((curr.left == null) && (curr.right == null)) {
				decodedStr.append(curr.data);
				curr = root;
				
				if(i == encodedStr.length)
					break;
			}
			else {			
				if(encodedStr[i] == '0')
					curr  = curr.left;
				else if(encodedStr[i] == '1')
					curr = curr.right;
				i++;
			}			
		}
		
		System.out.println(decodedStr.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n3 = new Node();
		n3.freq = 3;
		n3.data = 'A';
		n3.left = null;
		n3.right = null;
		
		Node n4 = new Node();
		n4.freq = 1;
		n4.data = 'B';
		n4.left = null;
		n4.right = null;
		
		Node n5 = new Node();
		n5.freq = 1;
		n5.data = 'C';
		n5.left = null;
		n5.right = null;

		Node n2 = new Node();
		n2.freq = 2;
		n2.left = n4;
		n2.right = n5;	

		Node n1 = new Node();
		n1.freq = 5;
		n1.left = n2;
		n1.right = n3;	
		
		decode_huff("1001011", n1);
	}
}
