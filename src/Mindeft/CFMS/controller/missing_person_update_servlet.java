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
import Mindeft.CFMS.dao.missing_personDao;
import Mindeft.CFMS.util.AgeValidationUtility;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.nameValidationUtility;
import Mindeft.CFMS.util.name_validation_utility;
import Mindeft.CFMS.util.policeStation_contact_utility;
import Mindeft.CFMS.util.relation_validation_utility;

/**
 * Servlet implementation class missing_person_update_servlet
 */
public class missing_person_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String missing_person_firstname,missing_person_middlename,missing_person_lastname,missing_person_gender,missing_person_age;
	String referenceperson_name,referenceperson_relation,referenceperson_number,area_id;
	String missing_person_details,missing_person_date;
	String missing_person_id,missing_person_image;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean isError=false;
		List<FileItem> items = null;//TO Store All File Items
		String fieldName = null;//TO Store All HTML Field Names 
		String fieldValue = null;//TO Store All Field Values
		String fileName = null;//TO Store File Name
		File file = null;
		
		missing_personBean missing_personBeanObj=new missing_personBean();
		
		try {
			items = upload.parseRequest(req);// Parse Request
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				
				if (item.isFormField()) 
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("missing_person_id")) 
					{
						missing_person_id = fieldValue;				
						System.out.println("missing_person_id : " + missing_person_id);
						
						/*if(nameValidationUtility.isEmpty(missing_person_firstname))
						{
							req.setAttribute("missing_person_firstname", "<font color=red>*Enter Valid First Name</font>");
							isError=true;
						}*/
					}
					
					if (fieldName.equalsIgnoreCase("missing_person_firstname")) 
					{
						missing_person_firstname = fieldValue;				
						System.out.println("missing_person_firstname : " + missing_person_firstname);
						
						if(name_validation_utility.isEmpty(missing_person_firstname))
						{
							req.setAttribute("missing_person_firstname", "<font color=red>*Enter Valid First Name</font>");
							isError=true;
						}
					}
				
					if (fieldName.equalsIgnoreCase("missing_person_middlename")) 
					{
						missing_person_middlename = fieldValue;				
						System.out.println("missing_person_middlename : " + missing_person_middlename);
						
						if(name_validation_utility.isEmpty(missing_person_middlename))
						{
							req.setAttribute("missing_person_middlename", "<font color=red>*Enter Valid Middle Name</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("missing_person_lastname")) 
					{
						missing_person_lastname = fieldValue;				
						System.out.println("missing_person_lastname : " + missing_person_lastname);
						
						if(name_validation_utility.isEmpty(missing_person_lastname))
						{
							req.setAttribute("missing_person_lastname", "<font color=red>*Enter Valid Last Name</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("missing_person_gender")) 
					{
						missing_person_gender = fieldValue;				
						System.out.println("missing_person_gender : " + missing_person_gender);
						
						if(StringValidationUtility.isEmpty(missing_person_gender))
						{
							req.setAttribute("missing_person_gender", "<font color=red>*Select Any Gender</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("missing_person_age")) 
					{
						missing_person_age = fieldValue;				
						System.out.println("missing_person_age : " + missing_person_age);
						
						if(AgeValidationUtility.isEmpty(missing_person_age))
						{
							req.setAttribute("missing_person_age", "<font color=red>*Enter Valid Age</font>");
							isError=true;
						}
					}
					
					
					if (fieldName.equalsIgnoreCase("referenceperson_name")) 
					{
						referenceperson_name = fieldValue;				
						System.out.println("referenceperson_name : " + referenceperson_name);
						
						if(name_validation_utility.isEmpty(referenceperson_name))
						{
							req.setAttribute("referenceperson_name", "<font color=red>*Enter Valid referenceperson name</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("referenceperson_relation")) 
					{
						referenceperson_relation = fieldValue;				
						System.out.println("referenceperson_relation : " + referenceperson_relation);
						
						if(relation_validation_utility.isEmpty(referenceperson_relation))
						{
							req.setAttribute("referenceperson_relation", "<font color=red>*Enter Valid Relations</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("referenceperson_number")) 
					{
						referenceperson_number = fieldValue;				
						System.out.println("referenceperson_number : " + referenceperson_number);
						
						if(policeStation_contact_utility.isEmpty(referenceperson_number))
						{
							req.setAttribute("referenceperson_number", "<font color=red>*Enter Valid Number</font>");
							isError=true;
						}	
						
					}
					
					if (fieldName.equalsIgnoreCase("area_id")) 
					{
						area_id = fieldValue;				
						System.out.println("area_id : " + area_id);
						
						if(StringValidationUtility.isEmpty(area_id))
						{
							req.setAttribute("area_id", "<font color=red>*Select Any Area</font>");
							isError=true;
						}
					}
				
					if (fieldName.equalsIgnoreCase("missing_person_details")) 
					{
						missing_person_details = fieldValue;				
						System.out.println("missing_person_details : " + missing_person_details);
						
						if(StringValidationUtility.isEmpty(missing_person_details))
						{
							req.setAttribute("missing_person_details", "<font color=red>*Enter Details</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("missing_person_date")) 
					{
						missing_person_date = fieldValue;				
						System.out.println("missing_person_date : " + missing_person_date);
						
						if(StringValidationUtility.isEmpty(missing_person_date))
						{
							req.setAttribute("missing_person_date", "<font color=red>*Enter Missing Person Date</font>");
							isError=true;
						}
					}
					
				}//main if	for finding form field
				else
				{
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					missing_person_image = item.getName();
					System.out.println("missing_person_image : "+missing_person_image);
					
					missing_person_image = missing_person_image.substring(
							missing_person_image.lastIndexOf("\\") + 1,
							missing_person_image.length());
					System.out.println("missing_person_image 1 : "+missing_person_image);
					
					//Get Application Path Dynamically to Store File
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("Path : "+appPath);
					
					//Static Path to Store File
					String path = "D:\\JavaPrg\\CrimeFileManagementSystem\\WebContent\\upload\\missing_person";
					file = new File(path + File.separator
							+ missing_person_image);
					
					try {

						if (missing_person_image.isEmpty()) {

							if(StringValidationUtility.isEmpty(missing_person_image))
							{
								req.setAttribute("missing_person_image", "<font color=red>*Upload Image</font>");
								isError=true;
							}
							
						} else {
							System.out.println("MIME : "+context.getMimeType(missing_person_image));
							if (context.getMimeType(missing_person_image).equals(
									"image/gif")
									|| context.getMimeType(missing_person_image)
											.equals("image/jpeg")
									|| context.getMimeType(missing_person_image)
											.equals("image/png")) {
								
								item.write(file);
								System.out.println("===> "+file.getName());
								
								//student.setPhoto(file.getName());
								//System.out.println("Student Photo "+student.getPhoto());
								
								//req.setAttribute("missing_person_image", file.getName());
								//request.getRequestDispatcher("success.jsp").forward(request, response);
							
							} else {

								req.setAttribute(
										"missing_person_image",
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
				req.getRequestDispatcher("missing_person_table.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("No Worry");
				missing_personBeanObj.setMissing_person_id(missing_person_id);;
				missing_personBeanObj.setMissing_person_firstname(missing_person_firstname);
				missing_personBeanObj.setMissing_person_middlename(missing_person_middlename);
				missing_personBeanObj.setMissing_person_lastname(missing_person_lastname);
				missing_personBeanObj.setMissing_person_gender(missing_person_gender);
				missing_personBeanObj.setMissing_person_age(missing_person_age);
				missing_personBeanObj.setReferenceperson_name(referenceperson_name);
				missing_personBeanObj.setReferenceperson_number(referenceperson_number);
				missing_personBeanObj.setReferenceperson_relation(referenceperson_relation);
				missing_personBeanObj.setArea_id(area_id);
				missing_personBeanObj.setMissing_person_date(missing_person_date);
				missing_personBeanObj.setMissing_person_details(missing_person_details);
				missing_personBeanObj.setMissing_person_image(file.getName());
				
				
				if(missing_personDao.update(missing_personBeanObj));
				{
					System.out.println("Successful");
					req.getRequestDispatcher("missing_person_list").forward(req, resp);
				}	
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		missing_person_id=request.getParameter("missing_person_id");
		missing_person_firstname=request.getParameter("missing_person_firstname");
		missing_person_middlename=request.getParameter("missing_person_middlename");
		missing_person_lastname=request.getParameter("missing_person_lastname");
		missing_person_gender=request.getParameter("missing_person_gender");
		missing_person_age=request.getParameter("missing_person_age");
		
		referenceperson_name=request.getParameter("referenceperson_name");
		referenceperson_relation=request.getParameter("referenceperson_relation");
		referenceperson_number=request.getParameter("referenceperson_number");
		area_id=request.getParameter("area_id");
		
		missing_person_details=request.getParameter("missing_person_details");
		missing_person_date=request.getParameter("missing_person_date");
		
		
		
		boolean isError=false;
		missing_personBean missing_personBeanObj=new missing_personBean();
		 
		
		
		if(StringValidationUtility.isEmpty(missing_person_firstname))
		{
			request.setAttribute("missing_person_firstname", "<font color=red>*Enter First Name</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(missing_person_middlename))
		{
			request.setAttribute("missing_person_middlename", "<font color=red>*Enter Middle Name</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(missing_person_lastname))
		{
			request.setAttribute("missing_person_lastname", "<font color=red>*Enter Last Name</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(missing_person_gender))
		{
			request.setAttribute("missing_person_gender", "<font color=red>*Select Any Gender</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(missing_person_age))
		{
			request.setAttribute("missing_person_age", "<font color=red>*Enter Any Missing Person Age</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(referenceperson_name))
		{
			request.setAttribute("referenceperson_name", "<font color=red>*Enter Reference Person Name</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(referenceperson_relation))
		{
			request.setAttribute("referenceperson_relation", "<font color=red>*Enter Realtions</font>");
			isError=true;
		}
		
		if(policeStation_contact_utility.isEmpty(referenceperson_number))
		{
			request.setAttribute("referenceperson_number", "<font color=red>*Enter Number</font>");
			isError=true;
		}
		
		
		if(StringValidationUtility.isEmpty(area_id))
		{
			request.setAttribute("area_id", "<font color=red>*Select Area</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(missing_person_details))
		{
			request.setAttribute("missing_person_details", "<font color=red>*Enter Details</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(missing_person_date))
		{
			request.setAttribute("missing_person_date", "<font color=red>*Select Date</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("missing_person_table.jsp").forward(request, response);
		}
		else
		{
			missing_personBeanObj.setMissing_person_firstname(missing_person_firstname);
			missing_personBeanObj.setMissing_person_middlename(missing_person_middlename);
			missing_personBeanObj.setMissing_person_lastname(missing_person_lastname);
			missing_personBeanObj.setMissing_person_gender(missing_person_gender);
			missing_personBeanObj.setMissing_person_age(missing_person_age);
			missing_personBeanObj.setReferenceperson_name(referenceperson_name);
			missing_personBeanObj.setReferenceperson_number(referenceperson_number);
			missing_personBeanObj.setReferenceperson_relation(referenceperson_relation);
			missing_personBeanObj.setArea_id(area_id);
			missing_personBeanObj.setMissing_person_date(missing_person_date);
			missing_personBeanObj.setMissing_person_details(missing_person_details);
			missing_personBeanObj.setMissing_person_id(missing_person_id);
			
			if(missing_personDao.update(missing_personBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("missing_person_list").forward(request, response);
			}
			
		}
		
	}*/

}
