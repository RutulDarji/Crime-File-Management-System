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

import Mindeft.CFMS.bean.crime_victimBean;
import Mindeft.CFMS.dao.crime_victimDao;
//import Mindeft.CFMS.bean.crime_victimBean;
//import Mindeft.CFMS.dao.crime_victimDao;
import Mindeft.CFMS.util.AgeValidationUtility;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.nameValidationUtility;
import Mindeft.CFMS.util.name_validation_utility;
import Mindeft.CFMS.util.phone_number_validatation_utility;
import Mindeft.CFMS.util.policeStation_contact_utility;

/**
 * Servlet implementation class crime_victim_insert_servlet
 */
public class crime_victim_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String crime_victim_id,crime_victim_firstname,crime_victim_middlename,crime_victim_lastname,crime_victim_gender;
	String crime_victim_age,crime_victim_number,crime_victim_address,crime_victim_image,crime_id;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean isError=false;
		List<FileItem> items = null;//TO Store All File Items
		String fieldName = null;//TO Store All HTML Field Names 
		String fieldValue = null;//TO Store All Field Values
		String fileName = null;//TO Store File Name
		File file = null;
		
		crime_victimBean crime_victimBeanObj=new crime_victimBean();
		
		try {
			items = upload.parseRequest(req);// Parse Request
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				
				if (item.isFormField()) 
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("crime_victim_firstname")) 
					{
						crime_victim_firstname = fieldValue;				
						System.out.println("crime_victim_firstname : " + crime_victim_firstname);
						
						if(name_validation_utility.isEmpty(crime_victim_firstname))
						{
							req.setAttribute("crime_victim_firstname", "<font color=red>*Enter Valid First Name</font>");
							isError=true;
							crime_victimBeanObj.setCrime_victim_firstname(crime_victim_firstname);
						}
						else
						{
							crime_victimBeanObj.setCrime_victim_firstname(crime_victim_firstname);
						}
					}
				
					if (fieldName.equalsIgnoreCase("crime_victim_middlename")) 
					{
						crime_victim_middlename = fieldValue;				
						System.out.println("crime_victim_middlename : " + crime_victim_middlename);
						
						if(name_validation_utility.isEmpty(crime_victim_middlename))
						{
							req.setAttribute("crime_victim_middlename", "<font color=red>*Enter Valid Middle Name</font>");
							isError=true;
							crime_victimBeanObj.setCrime_victim_middlename(crime_victim_middlename);
						}
						else
						{
							crime_victimBeanObj.setCrime_victim_middlename(crime_victim_middlename);
						}
					}
					
					if (fieldName.equalsIgnoreCase("crime_victim_lastname")) 
					{
						crime_victim_lastname = fieldValue;				
						System.out.println("crime_victim_lastname : " + crime_victim_lastname);
						
						if(name_validation_utility.isEmpty(crime_victim_lastname))
						{
							req.setAttribute("crime_victim_lastname", "<font color=red>*Enter Valid Last Name</font>");
							isError=true;
							crime_victimBeanObj.setCrime_victim_lastname(crime_victim_lastname);
						}
						else
						{
							crime_victimBeanObj.setCrime_victim_lastname(crime_victim_lastname);
						}
					}
					
					if (fieldName.equalsIgnoreCase("crime_victim_gender")) 
					{
						crime_victim_gender = fieldValue;				
						System.out.println("crime_victim_gender : " + crime_victim_gender);
						
						if(StringValidationUtility.isEmpty(crime_victim_gender))
						{
							req.setAttribute("crime_victim_gender", "<font color=red>*Select Gender</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("crime_victim_age")) 
					{
						crime_victim_age = fieldValue;				
						System.out.println("crime_victim_age : " + crime_victim_age);
						
						if(AgeValidationUtility.isEmpty(crime_victim_age))
						{
							req.setAttribute("crime_victim_age", "<font color=red>*Enter Valid Age</font>");
							isError=true;
							crime_victimBeanObj.setCrime_victim_age(crime_victim_age);
						}
						else
						{
							crime_victimBeanObj.setCrime_victim_age(crime_victim_age);
						}
					}
					
					
					
					if (fieldName.equalsIgnoreCase("crime_victim_number")) 
					{
						crime_victim_number = fieldValue;				
						System.out.println("crime_victim_number : " + crime_victim_number);
						
						if(phone_number_validatation_utility.isEmpty(crime_victim_number))
						{
							req.setAttribute("crime_victim_number", "<font color=red>*Enter Valid Number</font>");
							isError=true;
							crime_victimBeanObj.setCrime_victim_number(crime_victim_number);
						}	
						else
						{
							crime_victimBeanObj.setCrime_victim_number(crime_victim_number);
						}
						
					}
					
					if (fieldName.equalsIgnoreCase("crime_victim_address")) 
					{
						crime_victim_address = fieldValue;				
						System.out.println("crime_victim_address : " + crime_victim_address);
						
						if(StringValidationUtility.isEmpty(crime_victim_address))
						{
							req.setAttribute("crime_victim_address", "<font color=red>*Enter Details</font>");
							isError=true;
							crime_victimBeanObj.setCrime_victim_address(crime_victim_address);
						}
						else
						{
							crime_victimBeanObj.setCrime_victim_address(crime_victim_address);
						}
					}
					
					if (fieldName.equalsIgnoreCase("crime_id")) 
					{
						crime_id = fieldValue;				
						System.out.println("crime_id : " + crime_id);
						
						if(StringValidationUtility.isEmpty(crime_id))
						{
							req.setAttribute("crime_id", "<font color=red>*Select Any Crime</font>");
							isError=true;
						}
					}
					
				}//main if	for finding form field
				else
				{
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					crime_victim_image = item.getName();
					System.out.println("crime_victim_image : "+crime_victim_image);
					
					crime_victim_image = crime_victim_image.substring(
							crime_victim_image.lastIndexOf("\\") + 1,
							crime_victim_image.length());
					System.out.println("crime_victim_image 1 : "+crime_victim_image);
					
					//Get Application Path Dynamically to Store File
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("Path : "+appPath);
					
					//Static Path to Store File
					String path = "D:\\JavaPrg\\CrimeFileManagementSystem\\WebContent\\upload\\crime_victim";
					file = new File(path + File.separator
							+ crime_victim_image);
					
					try {

						if (crime_victim_image.isEmpty()) {

							if(StringValidationUtility.isEmpty(crime_victim_image))
							{
								req.setAttribute("crime_victim_image", "<font color=red>*Upload Image</font>");
								isError=true;
							}
							
						} else {
							System.out.println("MIME : "+context.getMimeType(crime_victim_image));
							if (context.getMimeType(crime_victim_image).equals(
									"image/gif")
									|| context.getMimeType(crime_victim_image)
											.equals("image/jpeg")
									|| context.getMimeType(crime_victim_image)
											.equals("image/png")) {
								
								item.write(file);
								System.out.println("===> "+file.getName());
								
								//student.setPhoto(file.getName());
								//System.out.println("Student Photo "+student.getPhoto());
								
								//req.setAttribute("crime_victim_image", file.getName());
								//request.getRequestDispatcher("success.jsp").forward(request, response);
							
							} else {

								req.setAttribute(
										"crime_victim_image",
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
				req.setAttribute("crime_victimBeanObj", crime_victimBeanObj);
				req.getRequestDispatcher("crime_victim_table.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("No Worry");
				
				crime_victimBeanObj.setCrime_victim_firstname(crime_victim_firstname);
				crime_victimBeanObj.setCrime_victim_middlename(crime_victim_middlename);
				crime_victimBeanObj.setCrime_victim_lastname(crime_victim_lastname);
				crime_victimBeanObj.setCrime_victim_gender(crime_victim_gender);
				crime_victimBeanObj.setCrime_victim_age(crime_victim_age);
				crime_victimBeanObj.setCrime_victim_number(crime_victim_number);
				crime_victimBeanObj.setCrime_victim_address(crime_victim_address);
				crime_victimBeanObj.setCrime_victim_image(file.getName());
				crime_victimBeanObj.setCrime_id(crime_id);
				
				
				if(crime_victimDao.insert(crime_victimBeanObj));
				{
					System.out.println("Successful");
					req.getRequestDispatcher("crime_victim_list").forward(req, resp);
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
		
		
	}	
		
	

}
