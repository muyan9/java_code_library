package zcy.service.smtp;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.*;

/**
 * 这个 <i>CmdBase</i> 类封装Command的命令处理基类。
 * <p>
 * 所有具体的命令都要继承给类
 * <p>
 */
public class Email {

	public static void main(String[] args)
	{
		Email e = new Email();
		e.sendAlarmInfo();
	}
	/**
	 * 发送报警信息
	 * @param hAlarmMap 封装报警信息Map
	 * @param sDevID 设备ID
	 */
	private void sendAlarmInfo(){
		//向E-Mail发送的告警信息
			String sSmtp = "smtp.";
			Properties props = new Properties(); 		     
		    SendMailAuthenticator au = new SendMailAuthenticator();  
		    //写信
		    try{ 
				String sFromAddr = "muyan9@sohu.com";	//
				String sFromPass = "bushiwo";	//
				String sToAddr = "muyan9@sohu.com";		//
				String sAlarmHead = "test";	//
				String sAlarmInfo = "test content";	//
				if(sAlarmInfo != null && !sAlarmInfo.trim().equals("")){
					String sUserName = sFromAddr.substring(0,sFromAddr.indexOf("@"));
					sSmtp += sFromAddr.substring(sFromAddr.lastIndexOf("@") + 1, sFromAddr.length());
					au.check(sUserName, sFromPass); 		// 认证 (用户名和密码) 
					PasswordAuthentication pa = au.getPasswordAuthentication();
				    props.put("mail.smtp.host", sSmtp); 	// 设置smtp服务器 
				    props.put("mail.smtp.auth", "true"); 	// 这样认证才会起作用：） 
				    Session session = Session.getInstance(props, au);	// 创建session 
				    MimeMessage message = new MimeMessage(session); 	//创建message对象
					Address address = new InternetAddress(sFromAddr, "Alarm"); 	//发件人地址 
					Address toAddress = new InternetAddress(sToAddr);			//收件人地址 
					message.setFrom(address);//设置发件人 
					message.setRecipient(MimeMessage.RecipientType.TO,toAddress);//设置收件人 
					//下面写邮件内容 
					message.setSubject(sAlarmHead); 	//设置主题 
					message.setSentDate(new Date());	//设置日期 
					message.setText(sAlarmInfo);		//设置邮件内容 
					//发送
					Transport transport = session.getTransport("smtp"); 
//					transport.send(message); 
					transport.sendMessage(message, message.getAllRecipients());
				}
		    } catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		
		       
//		       Session sendMailSession;
//		       Transport transport;
//		      sendMailSession = Session.getInstance(props, null);
//		      props.put("mail.smtp.host", "smtp.163.com");
//		      //用你的smtp服务器代替上面的 < smtp.jspinsider.com >
//		      Message newMessage = new MimeMessage(sendMailSession);
//		      try {
//		    	  au.check("muyan9", "bushiwo");
//				newMessage.setFrom(new InternetAddress("muyan9@163.com"));
//			      newMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("muyan9@163.com"));
//			      newMessage.setSubject("subject");
//			      newMessage.setSentDate(new Date());
//			      newMessage.setText("text");
//			      transport = sendMailSession.getTransport("smtp");
//			      transport.send(newMessage);
//			} catch (AddressException e) {
//				e.printStackTrace();
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			}

		}
}

/**
 * 邮件用户验证类
 *
 */
class SendMailAuthenticator extends Authenticator{ 
	  private String username = ""; 
	  private String password = ""; 

	  public void check(String username, String password){ 
	    this.username = username; 
	    this.password = password; 
	  } 

	  public PasswordAuthentication getPasswordAuthentication(){ 
	    return new PasswordAuthentication(username,password); 
	  } 
} 
