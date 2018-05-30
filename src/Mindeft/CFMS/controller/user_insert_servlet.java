package Mindeft.CFMS.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.dao.missing_personDao;
import Mindeft.CFMS.dao.userDao;
import Mindeft.CFMS.util.AgeValidationUtility;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.email_validation_utility;
import Mindeft.CFMS.util.name_validation_utility;
import Mindeft.CFMS.util.password_validation_utility;
import Mindeft.CFMS.util.phone_number_validatation_utility;
import Mindeft.CFMS.util.relation_validation_utility;

/**
 * Servlet implementation class user_insert_servlet
 */
public class user_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String otp;
	String user_id,user_firstname,user_middlename,user_lastname,email,password,gender,mobile,address;
	String city_id,date_of_birth,security_question_id,security_question_answer,user_image,isActive,user_type_id;
	String country_name,state;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		isActive="1";
		user_type_id="2";
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean isError=false;
		List<FileItem> items = null;//TO Store All File Items
		String fieldName = null;//TO Store All HTML Field Names 
		String fieldValue = null;//TO Store All Field Values
		String fileName = null;//TO Store File Name
		File file = null;
		
		userBean userBeanObj=new userBean();
		
		try {
			items = upload.parseRequest(req);// Parse Request
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				
				if (item.isFormField()) 
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					
//					if (fieldName.equalsIgnoreCase("country_name")) 
//					{
//						country_name = fieldValue;				
//						System.out.println("country_name : " + country_name);
//						
//						if(name_validation_utility.isEmpty(country_name))
//						{
//							req.setAttribute("country_name", "<font color=red>*Select Any Country</font>");
//							isError=true;
//						}
//					}
//					
//					if (fieldName.equalsIgnoreCase("state")) 
//					{
//						state = fieldValue;				
//						System.out.println("state : " + state);
//						
//						if(name_validation_utility.isEmpty(state))
//						{
//							req.setAttribute("state", "<font color=red>*Select Any State</font>");
//							isError=true;
//						}
//					}
					
					if (fieldName.equalsIgnoreCase("user_firstname")) 
					{
						user_firstname = fieldValue;				
						System.out.println("user_firstname : " + user_firstname);
						
						if(name_validation_utility.isEmpty(user_firstname))
						{
							req.setAttribute("user_firstname", "<font color=red>*Enter Valid First Name</font>");
							isError=true;
							userBeanObj.setUser_firstname(user_firstname);
						}
						else
						{
							userBeanObj.setUser_firstname(user_firstname);
						}
					}
				
					if (fieldName.equalsIgnoreCase("user_middlename")) 
					{
						user_middlename = fieldValue;				
						System.out.println("user_middlename : " + user_middlename);
						
						if(name_validation_utility.isEmpty(user_middlename))
						{
							req.setAttribute("user_middlename", "<font color=red>*Enter Valid Middle Name</font>");
							isError=true;
							userBeanObj.setUser_middlename(user_middlename);
						}
						else
						{
							userBeanObj.setUser_middlename(user_middlename);
						}
					}
					
					if (fieldName.equalsIgnoreCase("user_lastname")) 
					{
						user_lastname = fieldValue;				
						System.out.println("user_lastname : " + user_lastname);
						
						if(name_validation_utility.isEmpty(user_lastname))
						{
							req.setAttribute("user_lastname", "<font color=red>*Enter Valid Last Name</font>");
							isError=true;
							userBeanObj.setUser_lastname(user_lastname);
						}
						else
						{
							userBeanObj.setUser_lastname(user_lastname);
						}
					
					}
					
					if (fieldName.equalsIgnoreCase("email")) 
					{
						email = fieldValue;				
						System.out.println("email : " + email);
						
						if(email_validation_utility.isEmpty(email))
						{
							req.setAttribute("email", "<font color=red>*Enter Valid email</font>");
							isError=true;
							userBeanObj.setEmail(email);
						}
						else
						{
							userBeanObj.setEmail(email);
						}
					}
					
					
					if (fieldName.equalsIgnoreCase("password")) 
					{
						password = fieldValue;				
						System.out.println("password : " + password);
						
						if(password_validation_utility.isEmpty(password))
						{
							req.setAttribute("password", "<font color=red>*Contain atleast 1 small and 1 capital letter,1 digit</font>");
							isError=true;
							userBeanObj.setPassword(password);
						}
						else
						{
							userBeanObj.setPassword(password);
						}
					}
					
					if (fieldName.equalsIgnoreCase("gender")) 
					{
						gender = fieldValue;				
						System.out.println("gender : " + gender);
						
						if(StringValidationUtility.isEmpty(gender))
						{
							req.setAttribute("gender", "<font color=red>*Select Any Gender</font>");
							isError=true;
						}
					}
					
					
					if (fieldName.equalsIgnoreCase("mobile")) 
					{
						mobile = fieldValue;				
						System.out.println("mobile : " + mobile);
						
						if(phone_number_validatation_utility.isEmpty(mobile))
						{
							req.setAttribute("mobile", "<font color=red>*Enter Valid Number</font>");
							isError=true;
							userBeanObj.setMobile(mobile);
						}	
						else
						{
							userBeanObj.setMobile(mobile);
						}
						
					}
					
					if (fieldName.equalsIgnoreCase("address")) 
					{
						address = fieldValue;				
						System.out.println("address : " + address);
						
						if(StringValidationUtility.isEmpty(address))
						{
							req.setAttribute("address", "<font color=red>*Enter address</font>");
							isError=true;
							userBeanObj.setAddress(address);
						}
						else
						{
							userBeanObj.setAddress(address);
						}
					}
					
					
					if (fieldName.equalsIgnoreCase("city_id")) 
					{
						city_id = fieldValue;				
						System.out.println("city_id : " + city_id);
						
						if(StringValidationUtility.isEmpty(city_id))
						{
							req.setAttribute("city_id", "<font color=red>*Select Any City</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("date_of_birth")) 
					{
						date_of_birth = fieldValue;				
						System.out.println("date_of_birth : " + date_of_birth);
						
						if(StringValidationUtility.isEmpty(date_of_birth))
						{
							req.setAttribute("date_of_birth", "<font color=red>*Select Any Date</font>");
							isError=true;
						}
					}
					
					
					if (fieldName.equalsIgnoreCase("security_question_id")) 
					{
						security_question_id = fieldValue;				
						System.out.println("security_question_id : " + security_question_id);
						
						if(StringValidationUtility.isEmpty(security_question_id))
						{
							req.setAttribute("security_question_id", "<font color=red>*Select Any Question</font>");
							isError=true;
						}
					}
				
					if (fieldName.equalsIgnoreCase("security_question_answer")) 
					{
						security_question_answer = fieldValue;				
						System.out.println("security_question_answer : " + security_question_answer);
						
						if(StringValidationUtility.isEmpty(security_question_answer))
						{
							req.setAttribute("security_question_answer", "<font color=red>*Enter Answer</font>");
							isError=true;
							userBeanObj.setSecurity_question_answer(security_question_answer);
						}
						else
						{
							userBeanObj.setSecurity_question_answer(security_question_answer);
						}
					}
					
					
				}//main if	for finding form field
				else
				{
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					user_image = item.getName();
					System.out.println("user_image : "+user_image);
					
					user_image = user_image.substring(
							user_image.lastIndexOf("\\") + 1,
							user_image.length());
					System.out.println("user_image 1 : "+user_image);
					
					//Get Application Path Dynamically to Store File
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("Path : "+appPath);
					
					//Static Path to Store File
					String path = "D:\\JavaPrg\\CrimeFileManagementSystem\\WebContent\\upload\\user_image";
					file = new File(path + File.separator
							+ user_image);
					
					try {

						if (user_image.isEmpty()) {

							if(StringValidationUtility.isEmpty(user_image))
							{
								req.setAttribute("user_image", "<font color=red>*Upload Image</font>");
								isError=true;
							}
							
						} else {
							System.out.println("MIME : "+context.getMimeType(user_image));
							if (context.getMimeType(user_image).equals(
									"image/gif")
									|| context.getMimeType(user_image)
											.equals("image/jpeg")
									|| context.getMimeType(user_image)
											.equals("image/png")) {
								
								item.write(file);
								System.out.println("===> "+file.getName());
								
								//student.setPhoto(file.getName());
								//System.out.println("Student Photo "+student.getPhoto());
								
								//req.setAttribute("missing_person_image", file.getName());
								//request.getRequestDispatcher("success.jsp").forward(request, response);
							
							} else {

								req.setAttribute(
										"user_image",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
										isError=true;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}//else for image(file)
				
			}//for 
			
			if(isError)
			{
				req.setAttribute("userBeanObj", userBeanObj);
				req.getRequestDispatcher("user_table.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("No Worry");
				userBeanObj.setUser_firstname(user_firstname);
				userBeanObj.setUser_middlename(user_middlename);
				userBeanObj.setUser_lastname(user_lastname);
				userBeanObj.setEmail(email);
				userBeanObj.setPassword(password);
				userBeanObj.setGender(gender);
				userBeanObj.setDate_of_birth(date_of_birth);
				userBeanObj.setIsActive(isActive);
				userBeanObj.setSecurity_question_id(security_question_id);
				userBeanObj.setSecurity_question_answer(security_question_answer);
				userBeanObj.setUser_type_id(user_type_id);
				userBeanObj.setMobile(mobile);
				userBeanObj.setAddress(address);
				userBeanObj.setUser_image(user_image);
				userBeanObj.setCity_id(city_id);
				
				
				
				if(userDao.insert(userBeanObj));
				{
					System.out.println("Successful");
					req.getRequestDispatcher("user_list").forward(req, resp);
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
