package Mindeft.CFMS.util;

public class AgeValidationUtility {
	
	public static boolean isEmpty(String param)
	{
		boolean isEmpty=false;
		
		if(param==null || param.trim().length() <=0)
		{
			isEmpty=true;
		}
		else
		{
				for(int i=0;i<param.trim().length();i++)
				{
					if(!Character.isDigit(param.charAt(i)))
						isEmpty=true;
				}		
				
				if(!isEmpty)
				{
					int age=Integer.parseInt(param);

					if(age>0 && age<125)
					{
						System.out.println("valid");
					}
					else
					{
						isEmpty=true;
						System.out.println("Invalid");
					}
					
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
