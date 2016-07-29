package LinkedList;
import java.util.*;

class LLNode{
	int data;
	LLNode next;
	LLNode(int d){
        data=d;
        next=null;
    }
	
}
public class LinkedListRemoveDuplicates 
{
    public static LLNode removeDuplicates(LLNode head) 
    {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        LLNode currNode = head;
       
        while(true)
        {
            LLNode tempNode = currNode;
            LLNode nextNode = currNode.next;
            
            while(nextNode != null)
            {
                if(currNode.data == nextNode.data)
                {
                    if(nextNode.next == null)
                    {
                        tempNode.next = null;
                        nextNode = null;
                    }
                    else
                    {
                        tempNode.next = nextNode.next;
                        if(tempNode.next != null)
                            nextNode = tempNode.next;
                        else
                            nextNode = null;
                    }
                }
                else
                {
                    tempNode = tempNode.next;
                    nextNode = nextNode.next;
                }
            }
            if(currNode.next == null)
            	break;
            if(currNode.next.next == null)
                break;
            currNode = currNode.next;
        }       	 
        return head;
    }

	 public static  LLNode insert(LLNode head,int data)
     {
        LLNode p=new LLNode(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            LLNode start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }    

    public static void display(LLNode head)
    {
          LLNode start=head;
          while(start!=null)
          {
              System.out.print(start.data+" ");
              start=start.next;
          }
    }	 
	 
	public static void main(String[] args) 
	{
		int[] numbers = new int[20];
		//numbers[0] = 9;
		//numbers[1] = 9;
		//numbers[2] = 9;
		//numbers[3] = 9;
		numbers[0] = 3; numbers[10] = 100;
		numbers[1] = 9; numbers[11] = 101;
		numbers[2] = 9; numbers[12] = 102;
		numbers[3] = 11; numbers[13] = 103;
		numbers[4] = 11; numbers[14] = 108;
		numbers[5] = 11; numbers[15] = 200;
		numbers[6] = 11; numbers[16] = 250;
		numbers[7] = 89; numbers[17] = 250;
		numbers[8] = 89; numbers[18] = 250;
		numbers[9] = 100; numbers[19] = 250;
		
        //Scanner sc=new Scanner(System.in);
        LLNode head=null;
        //int T=sc.nextInt();
        //while(T-->0){
        //    int ele=sc.nextInt();
        //    head=insert(head,ele);
        //}
        for(int i = 0; i < numbers.length; i++)
        	head = insert(head, numbers[i]);
        
        System.out.println("---------------");
        head=removeDuplicates(head);
        System.out.println("===============");
        display(head);
        System.out.println("+++++++++++++++");        
        //sc.close();
	}
}
