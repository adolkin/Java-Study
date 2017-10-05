import java.util.*;

public class CloneTest
{
	public static void main(String[] args)
	{
		try 
		{
			Employee original = new Employee("John Q. Public", 50000);
			original.setHireDay(2000, 1, 1);
			
			//Employee copy = original;
			Employee clone = original.clone();
			clone.raiseSalary(100);
			clone.setHireDay(2002, 12, 31);
			System.out.println("orignal = " + original);
			System.out.println("clone = " + clone);
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
}

class Employee implements Cloneable
{
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String name, double salary)
	{
		this.name = name;
		this.salary = salary;
	}
	
	public Employee clone() throws CloneNotSupportedException
	{
		Employee cloned = (Employee)super.clone();
		cloned.hireDay = (Date)hireDay.clone();
		return cloned;
	}
	
	public void setHireDay(int year, int month, int day)
	{
		hireDay = new GregorianCalendar(year, month - 1, day).getTime();
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public String toString()
	{
		return "Employee[name = " + name
			+ ", salary= " + salary
			+ ", hireDay= " + hireDay
			+ "]";
	}
}