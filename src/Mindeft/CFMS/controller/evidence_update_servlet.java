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

import Mindeft.CFMS.bean.evidenceBean;
import Mindeft.CFMS.dao.evidenceDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.date_validation_utility;

/**
 * Servlet implementation class evidence_update_servlet
 */
public class evidence_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String evidence_id,evidence_date,evidence_details,evidence_image,crime_id;
	
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
		
		evidenceBean evidenceBeanObj=new evidenceBean();
		
		try {
			items = upload.parseRequest(req);// Parse Request
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				
				if (item.isFormField()) 
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("evidence_id")) 
					{
						evidence_id = fieldValue;				
						System.out.println("evidence_id : " + evidence_id);
						
					}
					
					if (fieldName.equalsIgnoreCase("crime_id")) 
					{
						crime_id = fieldValue;				
						System.out.println("crime_id : " + crime_id);
						
						if(StringValidationUtility.isEmpty(crime_id))
						{
							req.setAttribute("crime_id", "<font color=red>*Select Crime</font>");
							isError=true;
						}
					}
				
					if (fieldName.equalsIgnoreCase("evidence_date")) 
					{
						evidence_date = fieldValue;				
						System.out.println("evidence_date : " + evidence_date);
						
						if(date_validation_utility.isEmpty(evidence_date))
						{
							req.setAttribute("evidence_date", "<font color=red>*Enter Date</font>");
							isError=true;
						}
					}
					
					if (fieldName.equalsIgnoreCase("evidence_details")) 
					{
						evidence_details = fieldValue;				
						System.out.println("evidence_details : " + evidence_details);
						
						if(StringValidationUtility.isEmpty(evidence_details))
						{
							req.setAttribute("evidence_details", "<font color=red>*Enter Details</font>");
							isError=true;
						}
					}
					
					
				}//main if	for finding form field
				else
				{
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					evidence_image = item.getName();
					System.out.println("evidence_image : "+evidence_image);
					
					evidence_image = evidence_image.substring(
							evidence_image.lastIndexOf("\\") + 1,
							evidence_image.length());
					System.out.println("evidence_image 1 : "+evidence_image);
					
					//Get Application Path Dynamically to Store File
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\");
					System.out.println("Path : "+appPath);
					
					//Static Path to Store File
					String path = "D:\\JavaPrg\\CrimeFileManagementSystem\\WebContent\\upload\\evidence";
					file = new File(path + File.separator
							+ evidence_image);
					
					try {

						if (evidence_image.isEmpty()) {

							if(StringValidationUtility.isEmpty(evidence_image))
							{
								req.setAttribute("evidence_image", "<font color=red>*Upload Image</font>");
								isError=true;
							}
							
						} else {
							System.out.println("MIME : "+context.getMimeType(evidence_image));
							if (context.getMimeType(evidence_image).equals(
									"image/gif")
									|| context.getMimeType(evidence_image)
											.equals("image/jpeg")
									|| context.getMimeType(evidence_image)
											.equals("image/png")) {
								
								item.write(file);
								System.out.println("===> "+file.getName());
								
								//student.setPhoto(file.getName());
								//System.out.println("Student Photo "+student.getPhoto());
								
								//req.setAttribute("crime_victim_image", file.getName());
								//request.getRequestDispatcher("success.jsp").forward(request, response);
							
							} else {

								req.setAttribute(
										"evidence_image",
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
				req.getRequestDispatcher("evidence_table_jsp.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("No Worry");
			
				evidenceBeanObj.setCrime_id(crime_id);
				evidenceBeanObj.setEvidence_date(evidence_date);
				evidenceBeanObj.setEvidence_details(evidence_details);
				evidenceBeanObj.setEvidence_image(file.getName());
				evidenceBeanObj.setEvidence_id(evidence_id);
				
				if(evidenceDao.update(evidenceBeanObj));
				{
					System.out.println("Successful");
					req.getRequestDispatcher("evidence_list").forward(req, resp);
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
