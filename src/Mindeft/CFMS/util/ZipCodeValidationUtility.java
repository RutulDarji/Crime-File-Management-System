package Mindeft.CFMS.util;

public class ZipCodeValidationUtility {

	public static boolean isEmpty(String param)
	{
		boolean isEmpty=false;
		
		if(param.trim().length() ==6)
		{
			for(int i=0;i<param.trim().length();i++)
			{
				if(!Character.isDigit(param.charAt(i)))
					isEmpty=true;
			}
		}
		else
		{
			isEmpty=true;
		}
		
		return isEmpty;
	}
	
}
