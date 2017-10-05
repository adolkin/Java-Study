import java.util.*;

public class CalendarTest
{
	public static void main(String[] args)
	{
		GregorianCalendar d = new GregorianCalendar();
		
		int today = d.get(Calendar.DAY_OF_MONTH);
		int thismonth = d.get(Calendar.MONTH);
		
		
		d.set(Calendar.DAY_OF_MONTH, 1);
		
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		
		for (int i = Calendar.MONDAY; i < weekday; i++)
			System.out.print("    ");
		
		do
		{
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			
			if (day == today)
				System.out.print("*");
			else
				System.out.print(" ");
			
			if(weekday == Calendar.SUNDAY)
				System.out.println();
			
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		while (d.get(Calendar.MONTH) == thismonth);
		
		
		//if (weekday != Calendar.SUNDAY)
			//System.out.println();
		
	}
}
		