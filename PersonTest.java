import java.text.*;

public class PersonTest
{
	public static void main(String[] args)
	{
		Person[] people = new Person[2];
		
		people[0] = new Employee("Harry", 400000);
		people[1] = new Student("Maria", "IT");
		
		for (int i = 0; i < people.length; i++)
		{
			Person p = people[i];
			System.out.println(p.getName() + ", " + p.getDescription());
		}
	}
}

abstract class Person
{
	private String name;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public abstract String getDescription();
	
	public String getName()
	{
		return name;
	}
}

class Employee extends Person
{
	public Employee(String name, double salary)
	{
		super(name);
		this.salary = salary;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public String getDescription()
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return "an employee with a salary of " + formatter.format(salary);
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	private double salary;
}

class Student extends Person
{
	private String major;
	
	public Student(String name, String major)
	{
		super(name);
		this.major = major;
	}
	
	public String getDescription()
	{
		return "a student majoring in " + major;
	}
}