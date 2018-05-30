package Mindeft.CFMS.util;

public class city_name_validation_utility {

	public static boolean isEmpty(String param)
	{
		boolean isEmpty=false;
		param=param.trim();
		
		if(param==null || param.trim().length() <=0)
		{
			isEmpty=true;
			//System.out.println("H");
		}
		else
		{
			for(int i=0;i<param.length();i++)
			{
				if(param.charAt(i)!=' ')
				{
					if(!(Character.isLetter(param.charAt(i))))
					{	
						System.out.println(param.charAt(i));
						isEmpty=true;
					}
				}
			}
		}
		
		System.out.println(isEmpty);
		return isEmpty;
	}
}
