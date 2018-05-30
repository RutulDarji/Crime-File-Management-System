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

import Mindeft.CFMS.bean.criminalBean;
import Mindeft.CFMS.dao.criminalDao;
import Mindeft.CFMS.util.AgeValidationUtility;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.nameValidationUtility;
import Mindeft.CFMS.util.name_validation_utility;

/**
 * Servlet implementation class criminal_update_servlet
 */
public class criminal_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String criminal_id,criminal_firstname,criminal_middlename,criminal_lastname;
	String criminal_gender,criminal_age,criminal_details,criminal_image,mostwanted,police_station_id;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean isError=false;
		List<FileItem> items = null;//TO Store All File Items
		String fieldName = null;//TO Store All HTML Field Names 
		String fieldValue = null;//TO Store All Field Values
		String fileName = null;//TO Store File Name
		File file = null;
		
		criminalBean criminalBeanObj=new criminalBean();
		
		try {
			items = upload.parseRequest(req);// Parse Request
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				
				if (item.isFormField()) 
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("criminal_id")) 
					{
						criminal_id = fieldValue;				
						System.out.println("criminal_id : " + criminal_id);
						
					}
					
					
					if (fieldName.equalsIgnoreCase("criminal_firstname")) 
					{
						criminal_firstname = fieldValue;				
						System.out.println("criminal_firstname : " + criminal_firstname);
						
						if(name_validation_utility.isEmpty(criminal_firstname))
						{
							req.setAttribute("criminal_firstname", "<font color=red>*Enter Valid First Name</font>");
							isError=true;
						}
					}
				
					if (fieldName.equalsIgnoreCase("criminal_middlename")) 
					{
						criminal_middlename = fieldValue;				
						System.out.println("criminal_middlename : " + criminal_middlename);
						
						if(name_validation_utility.isEmpty(criminal_middlename))
						{
							req.setAttribute("criminal_middlename", "<font color=red>*Enter Valid Middle Name</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("criminal_lastname")) 
					{
						criminal_lastname = fieldValue;				
						System.out.println("criminal_lastname : " + criminal_lastname);
						
						if(name_validation_utility.isEmpty(criminal_lastname))
						{
							req.setAttribute("criminal_lastname", "<font color=red>*Enter Valid Last Name</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("criminal_gender")) 
					{
						criminal_gender = fieldValue;				
						System.out.println("criminal_gender : " + criminal_gender);
						
						if(StringValidationUtility.isEmpty(criminal_gender))
						{
							req.setAttribute("missing_person_gender", "<font color=red>*Select Any Gender</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("criminal_age")) 
					{
						criminal_age = fieldValue;				
						System.out.println("criminal_age : " + criminal_age);
						
						if(AgeValidationUtility.isEmpty(criminal_age))
						{
							req.setAttribute("criminal_age", "<font color=red>*Enter Valid Age</font>");
							isError=true;
						}
					}
					
					
	
					
					if (fieldName.equalsIgnoreCase("criminal_details")) 
					{
						criminal_details = fieldValue;				
						System.out.println("criminal_details : " + criminal_details);
						
						if(StringValidationUtility.isEmpty(criminal_details))
						{
							req.setAttribute("criminal_details", "<font color=red>*Enter Details</font>");
							isError=true;
						}
					}
					
					
					if (fieldName.equalsIgnoreCase("police_station_id")) 
					{
						police_station_id = fieldValue;				
						System.out.println("police_station_id : " + police_station_id);
						
					}
				
					if (fieldName.equalsIgnoreCase("mostwanted")) 
					{
						mostwanted = fieldValue;				
						System.out.println("mostwanted : " + mostwanted);
						
						if(StringValidationUtility.isEmpty(mostwanted))
						{
							req.setAttribute("mostwanted", "<font color=red>*Select Any option For Most Wanted Details</font>");
							isError=true;
						}
					}
					
					
				}//main if	for finding form field
				else
				{
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					criminal_image = item.getName();
					System.out.println("criminal_image : "+criminal_image);
					
					criminal_image = criminal_image.substring(
							criminal_image.lastIndexOf("\\") + 1,
							criminal_image.length());
					System.out.println("criminal_image 1 : "+criminal_image);
					
					//Get Application Path Dynamically to Store File
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("Path : "+appPath);
					
					//Static Path to Store File
					String path = "D:\\JavaPrg\\CrimeFileManagementSystem\\WebContent\\upload\\criminal";
					file = new File(path + File.separator
							+ criminal_image);
					
					try {

						if (criminal_image.isEmpty()) {

							if(StringValidationUtility.isEmpty(criminal_image))
							{
								req.setAttribute("criminal_image", "<font color=red>*Upload Image</font>");
								isError=true;
							}
							
						} else {
							System.out.println("MIME : "+context.getMimeType(criminal_image));
							if (context.getMimeType(criminal_image).equals(
									"image/gif")
									|| context.getMimeType(criminal_image)
											.equals("image/jpeg")
									|| context.getMimeType(criminal_image)
											.equals("image/png")) {
								
								item.write(file);
								System.out.println("===> "+file.getName());
								
								//student.setPhoto(file.getName());
								//System.out.println("Student Photo "+student.getPhoto());
								
								//req.setAttribute("missing_person_image", file.getName());
								//request.getRequestDispatcher("success.jsp").forward(request, response);
							
							} else {

								req.setAttribute(
										"criminal_image",
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
				req.getRequestDispatcher("criminal_table.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("No Worry");
				
				/*missing_personBeanObj.setMissing_person_image(file.getName());*/

				criminalBeanObj.setCriminal_firstname(criminal_firstname);
				criminalBeanObj.setCriminal_middlename(criminal_middlename);
				criminalBeanObj.setCriminal_lastname(criminal_lastname);
				criminalBeanObj.setCriminal_gender(criminal_gender);
				criminalBeanObj.setCriminal_age(criminal_age);
				criminalBeanObj.setCriminal_details(criminal_details);
				criminalBeanObj.setCriminal_image(criminal_image);
				criminalBeanObj.setMostwanted(mostwanted);
				criminalBeanObj.setPolice_station_id(police_station_id);
				criminalBeanObj.setCriminal_id(criminal_id);
				
				
				if(criminalDao.update(criminalBeanObj));
				{
					System.out.println("Successful");
					req.getRequestDispatcher("criminal_list").forward(req, resp);
				}	
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

}
