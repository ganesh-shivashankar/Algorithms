class Person
{
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	Person(String firstName, String lastName, int identification)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	public void printPerson()
	{
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
	}
}

class Student extends Person
{
	private int[] testScores;
	
	Student(String firstName, String lastName, int id, int[] scores)
	{
		super(firstName, lastName, id);
		testScores = scores;
	}
	
	public char calculate()
	{
		int sum = 0;
		for(int i = 0; i < testScores.length; i++)
			sum += testScores[i];
		
		float avg = sum / testScores.length;
		char grade = 'x';
		
		if((avg <= 100) && (avg >= 90))
			grade = 'O';
		if((avg < 90) && (avg >= 80))
			grade = 'E';
		if((avg < 80) && (avg >= 70))
			grade = 'A';
		if((avg < 70) && (avg >= 55))
			grade = 'P';
		if((avg < 55) && (avg >= 40))
			grade = 'D';
		else if (avg < 40)
			grade = 'T';
		
		return grade;
	}
}

public class ClassExample 
{
	public static void main(String[] args)
	{
		int[] testScores = new int[2];
		testScores[0] = 100;
		testScores[1] = 80;
		
		Student s = new Student("First", "Second", 100, testScores);
		
		s.printPerson();
		
		System.out.println("Grade: " + s.calculate());
	}
}
