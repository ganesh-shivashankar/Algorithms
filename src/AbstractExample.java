abstract class Book
{
	String title;
	String author;
	
	Book(String t, String a)
	{
		this.title = t;
		this.author = a;
	}
	
	abstract void display();
}

class MyBook extends Book
{
	private int price;
	
	MyBook(String t, String a, int p)
	{
		super(t, a);
		price = p;
	}
	
	void display()
	{
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Price: " + price);
	}
}

public class AbstractExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String title = "Book1";
		String author = "Author1";
		int price = 100;
		
		Book new_novel = new MyBook(title, author, price);
		new_novel.display();
	}

}
