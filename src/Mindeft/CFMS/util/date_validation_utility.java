package Mindeft.CFMS.util;

import java.util.Calendar;

public class date_validation_utility {

	public static boolean isEmpty(String param)
	{
		boolean isEmpty=false;
		Calendar cal = Calendar.getInstance();
		int currentYear, currentMonth, currentDay; 
		currentYear = cal.get(Calendar.YEAR); 
		currentMonth = cal.get(Calendar.MONTH); 
		currentDay = cal.get(Calendar.DATE);
		
		if(param==null || param.trim().length() <=0)
		{
			isEmpty=true;
		}
		else
		{
			String array[]=param.split("-");
			
			int selectedyear=Integer.parseInt(array[0]);
			int selectedmonth=Integer.parseInt(array[1]);
			int selecteddate=Integer.parseInt(array[2]);				
			String message="";
			//System.out.println(currentDay + "" + currentMonth + "" + currentYear);
			System.out.println("Current Day" + currentDay);
			System.out.println("Current month" + currentMonth);
			System.out.println("Current year" + currentYear);
			
			     		if(selectedyear < currentYear)
			            {
			                    message = message + "Start Date is Before Today" + "\n";
			                    System.out.println(message);
			            }
			            else if(selectedmonth < currentMonth && selectedyear <= currentYear)
			            {
			                    message = message + "Start Date is Before Today" + "\n";
	                            System.out.println(message);
			            }
			            else if(selecteddate < currentDay && selectedmonth <= currentMonth && selectedyear <= currentYear)
			            {
			                        message = message + "Start Date is Before Today" + "\n";
			                        System.out.println(message);
			            }
			            else
			            {
			            	System.out.println("Invalid");
			            	isEmpty=true;
			            }
			
				
		}
		
		return isEmpty;
	}
}
