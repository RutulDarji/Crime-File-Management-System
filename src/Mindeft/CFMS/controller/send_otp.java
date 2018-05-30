package Mindeft.CFMS.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.state_name_validation_utility;

/**
 * Servlet implementation class send_otp
 */
public class send_otp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static String activation_code;
	public static void storeotp(String otp)
	{
		activation_code=otp;
	}
	
	public static String getotp()
	{
		return activation_code;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isError=false;
		
		String email=request.getParameter("email");
		
		Random random=new Random();
		activation_code = ""+(int)(100000+random.nextInt(900000));
		String subject="your otp";
		//String to=request.getParameter("emailid");
	//	String subject=request.getParameter("your otp");
	//	String msg=request.getParameter();
		
		if(StringValidationUtility.isEmpty(email))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("email", "<font color=red>*Enter Valid  email</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("email_varification.jsp").forward(request, response);
			request.setAttribute("email", email);
		}
		else
		{
			request.setAttribute("email", email);
			HttpSession email_session=request.getSession();
			email_session.setAttribute("email1", email);
			
			send_otp.storeotp(activation_code);
			
			//request.setAttribute("email", email);
			
			System.out.println("OTP is" + send_otp.getotp());
			
			try {
				send_mail.sendmail(email, subject,activation_code );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("user_email_verification.jsp").forward(request, response);

		}
		
				
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*System.out.println("In Send OTP");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean isError=false;
		List<FileItem> items = null;//TO Store All File Items
		String fieldName = null;//TO Store All HTML Field Names 
		String fieldValue = null;//TO Store All Field Values
		String fileName = null;//TO Store File Name
		File file = null;
		
		String email=new String() ;
		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				
				if (item.isFormField()) 
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("email")) 
					{
						email = fieldValue;				
						System.out.println("email : " + email);
			
						if(StringValidationUtility.isEmpty(email))
						{
								request.setAttribute("email", "<font color=red>*Enter Valid email</font>");
								isError=true;
						}
					}
		
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		//request.setAttribute("emailid", email);
		
		/*String email=request.getParameter("email");
		
		Random random=new Random();
		activation_code = ""+(int)(100000+random.nextInt(900000));
		String subject="your otp";
		//String to=request.getParameter("emailid");
	//	String subject=request.getParameter("your otp");
	//	String msg=request.getParameter();
		send_otp.storeotp(activation_code);
		
		try {
			send_mail.sendmail(email, subject,activation_code );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.getRequestDispatcher("user_table.jsp").forward(request, response);;
		//out.print("message has been sent successfully");
		//out.close();*/
	}

}
