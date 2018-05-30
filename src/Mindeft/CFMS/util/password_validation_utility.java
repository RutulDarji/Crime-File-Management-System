package Mindeft.CFMS.util;

public class password_validation_utility {

	public static boolean isEmpty(String param)
	{
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		boolean isEmpty=false;
		param=param.trim();
		
		if(param==null || param.trim().length() <=0)
		{
			isEmpty=true;
			//System.out.println("H");
		}
		else
		{
			if(!param.matches(pattern))
				isEmpty=true;
		}
		
		System.out.println(isEmpty);
		return isEmpty;
	}
}
