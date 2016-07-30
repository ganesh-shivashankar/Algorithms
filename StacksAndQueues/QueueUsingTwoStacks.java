import java.util.*;

class CustomQueue
{
	private Stack<Integer> st1 = new Stack<Integer>();
	private Stack<Integer> st2 = new Stack<Integer>();
	
	private void moveElements()
	{
		if(st1.isEmpty())
			while(!st2.isEmpty())
				st1.push(st2.pop());
	}
	
	public void enqueue(int value)
	{
		st2.push(value);
	}

	public int dequeue()
	{
		moveElements();
		if(!st1.isEmpty())
			return st1.pop();
		return Integer.MIN_VALUE;
	}
	
	public int peek()
	{
		moveElements();
		if(!st1.isEmpty())
			return st1.peek();
		return Integer.MIN_VALUE;
	}
	
	public int size()
	{
		return st1.size() + st2.size();
	}
	
	public boolean isEmpty()
	{
		if(st1.isEmpty() && st2.isEmpty())
			return true;
		return false;
	}
}

public class QueueUsingTwoStacks 
{
	public static void main(String[] args) 
	{
		CustomQueue queue = new CustomQueue();
		
		queue.enqueue(100);
		queue.enqueue(50);
		queue.enqueue(75);
		
		System.out.println(queue.peek()); //100
		System.out.println(queue.dequeue()); //100
		System.out.println(queue.peek()); //50
		
		System.out.println(queue.size()); //2
		
		queue.enqueue(80);
		System.out.println(queue.dequeue()); //50
		
		System.out.println(queue.isEmpty()); //FALSE
		
		System.out.println(queue.size()); //2
		
		System.out.println(queue.dequeue()); //75
		System.out.println(queue.dequeue()); //80
		System.out.println(queue.dequeue()); //MIN - INT VALUE
		System.out.println(queue.dequeue()); //MIN - INT VALUE
		System.out.println(queue.dequeue()); //MIN - INT VALUE
		
		System.out.println(queue.isEmpty()); //TRUE
		System.out.println(queue.size()); //0
	}
}

