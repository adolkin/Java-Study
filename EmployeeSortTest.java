import java.util.*;

public class EmployeeSortTest
{
	public static void main(String[] args)
	{
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 750000);
		staff[2] = new Employee("Tony Tester", 38000);
		
		Arrays.sort(staff);
		
		for(Employee e : staff)
			System.out.println("name=" + e.getName() + ", salary =" + e. getSalary());
	}
}

class Employee implements Comparable<Employee>
{
	private String name;
	private double salary;
	
	public Employee(String name, double salary)
	{
		this.name = name;
		this.salary = salary;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public int compareTo(Employee other)
	{
		if(salary < other.salary) return -1;
		if(salary > other.salary) return 1;
		return 0;
	}
}
	