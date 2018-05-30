package Mindeft.CFMS.util;

public class StringValidationUtility {

	public static boolean isEmpty(String param)
	{
		boolean isEmpty=false;
		
		if(param==null || param.trim().length() <=0)
		{
			isEmpty=true;
		}
		
		return isEmpty;
	}
}
