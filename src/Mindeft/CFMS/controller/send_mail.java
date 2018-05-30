package Mindeft.CFMS.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class send_mail {

	
public static String storeotp(String otp)
{
	return otp;
}
public static void sendmail(String to,String subject,String text)
{

final String user="crimefilemanagementsystem2017@gmail.com";
final String pass="adirutul@2017";

//Get session object

System.out.println("To::"+ to);
System.out.println("Subjext::"+ subject);
System.out.println("text::"+ text);


Properties prop=new Properties();
/*prop.put("mail.smtp.auth","true");
prop.put("mail.smtp.startttls.enable", "true");
prop.put("mail.smtp.host", "smtp.gmail.com");
prop.put("mail.smtp.port", "587");*/

prop.put("mail.smtp.host", "smtp.gmail.com");    
prop.put("mail.smtp.socketFactory.port", "465");    
prop.put("mail.smtp.socketFactory.class",    
       "javax.net.ssl.SSLSocketFactory");    
prop.put("mail.smtp.auth", "true");    
prop.put("mail.smtp.port", "465");    


Session session=Session.getDefaultInstance(prop,new Authenticator() {
	protected javax.mail.PasswordAuthentication getPasswordAuthentication()
	{
		return new javax.mail.PasswordAuthentication(user, pass);
		
	}

});




//2nd step
	try
	{
	MimeMessage msg=new MimeMessage(session);
	msg.setFrom(new InternetAddress(user));
	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	msg.setSubject(subject);
	msg.setText(text);


//3rd step

	Transport.send(msg);

	System.out.println("done");
	}
	catch(MessagingException m)
	{
		m.printStackTrace();	
	}
  }
}