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

import Mindeft.CFMS.bean.crime_accuseBean;
import Mindeft.CFMS.dao.crime_accuseDao;
import Mindeft.CFMS.util.AgeValidationUtility;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.nameValidationUtility;
import Mindeft.CFMS.util.name_validation_utility;
import Mindeft.CFMS.util.phone_number_validatation_utility;
import Mindeft.CFMS.util.policeStation_contact_utility;

/**
 * Servlet implementation class crime_accuse_update_servlet
 */
public class crime_accuse_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String crime_accuse_id,crime_accuse_firstname,crime_accuse_middlename,crime_accuse_lastname,crime_accuse_gender;
	String crime_accuse_age,crime_accuse_number,crime_accuse_address,crime_accuse_image,crime_id;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("crime_accuse_insert");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean isError=false;
		List<FileItem> items = null;//TO Store All File Items
		String fieldName = null;//TO Store All HTML Field Names 
		String fieldValue = null;//TO Store All Field Values
		String fileName = null;//TO Store File Name
		File file = null;
		
		crime_accuseBean crime_accuseBeanObj=new crime_accuseBean();
		
		try {
			items = upload.parseRequest(req);// Parse Request
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				
				if (item.isFormField()) 
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
			
					if (fieldName.equalsIgnoreCase("crime_accuse_id")) 
					{
						crime_accuse_id = fieldValue;				
						System.out.println("crime_accuse_id : " + crime_accuse_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("crime_accuse_firstname")) 
					{
						crime_accuse_firstname = fieldValue;				
						System.out.println("crime_accuse_firstname : " + crime_accuse_firstname);
						
						if(name_validation_utility.isEmpty(crime_accuse_firstname))
						{
							req.setAttribute("crime_accuse_firstname", "<font color=red>*Enter Valid First Name</font>");
							isError=true;
						}
					}
				
					if (fieldName.equalsIgnoreCase("crime_accuse_middlename")) 
					{
						crime_accuse_middlename = fieldValue;				
						System.out.println("crime_accuse_middlename : " + crime_accuse_middlename);
						
						if(name_validation_utility.isEmpty(crime_accuse_middlename))
						{
							req.setAttribute("crime_accuse_middlename", "<font color=red>*Enter Valid Middle Name</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("crime_accuse_lastname")) 
					{
						crime_accuse_lastname = fieldValue;				
						System.out.println("crime_accuse_lastname : " + crime_accuse_lastname);
						
						if(name_validation_utility.isEmpty(crime_accuse_lastname))
						{
							req.setAttribute("crime_accuse_lastname", "<font color=red>*Enter Valid Last Name</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("crime_accuse_gender")) 
					{
						crime_accuse_gender = fieldValue;				
						System.out.println("crime_accuse_gender : " + crime_accuse_gender);
						
						if(StringValidationUtility.isEmpty(crime_accuse_gender))
						{
							req.setAttribute("crime_accuse_gender", "<font color=red>*Select Gender</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("crime_accuse_age")) 
					{
						crime_accuse_age = fieldValue;				
						System.out.println("crime_accuse_age : " + crime_accuse_age);
						
						if(AgeValidationUtility.isEmpty(crime_accuse_age))
						{
							req.setAttribute("crime_accuse_age", "<font color=red>*Enter Valid Age</font>");
							isError=true;
						}
					}
					
					
					
					if (fieldName.equalsIgnoreCase("crime_accuse_number")) 
					{
						crime_accuse_number = fieldValue;				
						System.out.println("crime_accuse_number : " + crime_accuse_number);
						
						if(phone_number_validatation_utility.isEmpty(crime_accuse_number))
						{
							req.setAttribute("crime_accuse_number", "<font color=red>*Enter Valid Number</font>");
							isError=true;
						}	
						
					}
					
					
					
					if (fieldName.equalsIgnoreCase("crime_accuse_address")) 
					{
						crime_accuse_address = fieldValue;				
						System.out.println("crime_accuse_address : " + crime_accuse_address);
						
						if(StringValidationUtility.isEmpty(crime_accuse_address))
						{
							req.setAttribute("crime_accuse_address", "<font color=red>*Enter Details</font>");
							isError=true;
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
					crime_accuse_image = item.getName();
					System.out.println("crime_accuse_image : "+crime_accuse_image);
					
					crime_accuse_image = crime_accuse_image.substring(
							crime_accuse_image.lastIndexOf("\\") + 1,
							crime_accuse_image.length());
					System.out.println("crime_accuse_image 1 : "+crime_accuse_image);
					
					//Get Application Path Dynamically to Store File
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("Path : "+appPath);
					
					//Static Path to Store File
					String path = "D:\\JavaPrg\\CrimeFileManagementSystem\\WebContent\\upload\\crime_accuse";
					file = new File(path + File.separator
							+ crime_accuse_image);
					
					try {

						if (crime_accuse_image.isEmpty()) {

							if(StringValidationUtility.isEmpty(crime_accuse_image))
							{
								req.setAttribute("crime_accuse_image", "<font color=red>*Upload Image</font>");
								isError=true;
							}
							
						} else {
							System.out.println("MIME : "+context.getMimeType(crime_accuse_image));
							if (context.getMimeType(crime_accuse_image).equals(
									"image/gif")
									|| context.getMimeType(crime_accuse_image)
											.equals("image/jpeg")
									|| context.getMimeType(crime_accuse_image)
											.equals("image/png")) {
								
								item.write(file);
								System.out.println("===> "+file.getName());
								
								//student.setPhoto(file.getName());
								//System.out.println("Student Photo "+student.getPhoto());
								
								//req.setAttribute("crime_accuse_image", file.getName());
								//request.getRequestDispatcher("success.jsp").forward(request, response);
							
							} else {

								req.setAttribute(
										"crime_accuse_image",
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
				req.getRequestDispatcher("crime_accuse_table.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("No Worry");
				
				/*crime_accuseBeanObj.setcrime_accuse_firstname(crime_accuse_firstname);
				crime_accuseBeanObj.setcrime_accuse_middlename(crime_accuse_middlename);
				crime_accuseBeanObj.setcrime_accuse_lastname(crime_accuse_lastname);
				crime_accuseBeanObj.setcrime_accuse_gender(crime_accuse_gender);
				crime_accuseBeanObj.setcrime_accuse_age(crime_accuse_age);
				crime_accuseBeanObj.setcrime_accuse_number(crime_accuse_number);
				crime_accuseBeanObj.setcrime_accuse_address(crime_accuse_address);
				crime_accuseBeanObj.setcrime_accuse_image(file.getName());
				crime_accuseBeanObj.setCrime_id(crime_id);
				*/
				
				crime_accuseBeanObj.setCrime_accuse_firstname(crime_accuse_firstname);
				crime_accuseBeanObj.setCrime_accuse_middlename(crime_accuse_middlename);
				crime_accuseBeanObj.setCrime_accuse_lastname(crime_accuse_lastname);
				crime_accuseBeanObj.setCrime_accuse_gender(crime_accuse_gender);
				crime_accuseBeanObj.setCrime_accuse_age(crime_accuse_age);
				crime_accuseBeanObj.setCrime_accuse_number(crime_accuse_number);
				crime_accuseBeanObj.setCrime_accuse_address(crime_accuse_address);
				crime_accuseBeanObj.setCrime_accuse_image(file.getName());
				crime_accuseBeanObj.setCrime_id(crime_id);
				crime_accuseBeanObj.setCrime_accuse_id(crime_accuse_id);
				
				if(crime_accuseDao.update(crime_accuseBeanObj));
				{
					System.out.println("Successful");
					req.getRequestDispatcher("crime_accuse_list").forward(req, resp);
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

}
