import java.util.*;

public class EqualsTest
{
	public static void main(String[] args)
	{
		Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
		
		System.out.println("alice1 == alice2: " + (alice1 == alice2));
		System.out.println("alice1 == alice3: " + (alice1 == alice3));
		System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
		System.out.println("alice1.queals(bob): " + alice1.equals(bob));
		
		System.out.println("bob.toString(): " + bob);
		
		Manager carl = new Manager("Cark Cracker", 80000, 1987, 12, 15);
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		
		System.out.println("boss.toString(): " + boss);
		System.out.println("boss.toString(): " + carl);
		System.out.println("carl.equals(boss): " + carl.equals(boss));
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
	
	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		Employee other = (Employee)otherObject;
		
		return name.equals(other.name)
			&& salary == other.salary
			&& hireDay.equals(other.hireDay);
	}
	
	public String toString()
	{
		return getClass().getName()
			+ " [name= " + name
			+ " ,base salary= " + salary
			+ " ,hireDay= " + hireDay
			+ "]";
	}
}

class Manager extends Employee
{
	private double bonus;
	
	public Manager(String name, double salary, int year, int month, int day)
	{
		super(name, salary, year, month, day);
		bonus = 0;
	}
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double bonus)
	{
		this.bonus = bonus;
	}
	
	public boolean equals(Object otherObject)
	{
		if (!super.equals(otherObject)) return false;
		Manager other = (Manager)otherObject;
		return bonus == other.bonus;
	}
	

	
	public String toString()
	{
		return super.toString()
			+ "[bonus = " + bonus
			+ "]";
	}
}

