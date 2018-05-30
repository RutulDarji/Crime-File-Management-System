package Mindeft.CFMS.util;

public class email_validation_utility {
	public static boolean isEmpty(String param)
	{
		String email_check ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		boolean isEmpty=false;
		param=param.trim();
		
		if(param==null || param.trim().length() <=0)
		{
			isEmpty=true;
		}
		else
		{
			if(!param.matches(email_check))
				isEmpty=true;
		}
		
		System.out.println(isEmpty);
		return isEmpty;
	}
}
