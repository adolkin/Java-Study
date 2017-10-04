import java.util.*;

public class ArrayListTest
{
	public static void main(String[] args)
	{
		ArrayList<Employee> staff = new ArrayList<Employee>();
		
		staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
		staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
		staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
		
		for (Employee e : staff)
			e.raiseSalary(5);
		
		for (Employee e : staff)
			System.out.println("name=" + e.getName()
				+ ",salary=" + e.getSalary()
				+ ",hireDay=" + e.getHireDay());
	}
}

class Employee
{
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String name, double salary, int year, int month, int day)
	{
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
	