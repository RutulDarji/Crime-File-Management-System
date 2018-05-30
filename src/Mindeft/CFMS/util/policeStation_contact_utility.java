package Mindeft.CFMS.util;

public class policeStation_contact_utility {

	public static boolean isEmpty(String param)
	{
		boolean isEmpty=false;
		if(param==null || param.trim().length() <=0)
		{
			isEmpty=true;
		}
		else
		{
			if(param.trim().length() ==10  || param.trim().length() ==11)
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
			
		}
		
		return isEmpty;
	}

}

