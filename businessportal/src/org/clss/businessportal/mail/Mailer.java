/*
 *
 * ---------------------------------------------------------------------

Program Name: Mailer.java

Author      : Mohamed Saud SNS        Date : 21 Jul 2017.

---------------------------------------------------------------------

Description







---------------------------------------------------------------------
Corrections
---------------------------------------------------------------------


Name            Date      Version                ECCO     Reason



---------------------------------------------------------------------
 */
package org.clss.businessportal.mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class Mailer {

	public String sendMail(String subject, String body, String bodyContent, String recipients, String cc, String from)
			throws Exception {
		String ret = "S";
		try {
			//recipients = "mohamedsaud.sns@clss.in";
			cc = "";
			String instructions = "<br><br><br>This is an auto generated mail. Kindly do not reply to this mail. Any reply to this mail will not be monitored or entertained.";

			String instructions2 = "<br>" + bodyContent;
			Properties props = System.getProperties();
			props.setProperty("mail.transport.protocol", "smtps");
			props.setProperty("mail.host", "smtpout.secureserver.net");
			props.put("mail.smtps.socketFactory.port", "465");
			props.put("mail.smtps.starttls.enable", "true");
			props.put("mail.smtps.auth", "true");
			props.setProperty("mail.user", "mohamedsaud.sns@clss.in");
			props.setProperty("mail.password", "081281clss");
			Session mailSession = Session.getInstance(props, null);
			body += instructions2;
			body += instructions;
			mailSession.setDebug(false);
			Transport transport = mailSession.getTransport("smtps");
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from));

			message.setSubject(subject);
			message.setContent(body, "text/html");
			message.setSentDate(new Date());
			if (recipients.indexOf(',') > 0) {
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
			} else {
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
			}
			if (cc.indexOf(',') > 0) {
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			} else if (!cc.equalsIgnoreCase("")) {
				message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			}
			// message.setRecipient(Message.RecipientType.BCC, new
			// InternetAddress("sts.clss@gmail.com"));
			MimeMultipart multipart = new MimeMultipart("related");
			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(body, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);
			// put everything together
			message.setContent(multipart);

			transport.connect("smtpout.secureserver.net", "mohamedsaud.sns@clss.in", "081281clss");
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			if (!cc.equalsIgnoreCase("")) {
				transport.sendMessage(message, message.getRecipients(Message.RecipientType.CC));
			}
			// transport.sendMessage(message,
			// message.getRecipients(Message.RecipientType.BCC));
			transport.close();

			System.out.println("Succssfully mail sent");

		} catch (Exception ex) {
			ret = ex.getMessage();
			ex.printStackTrace();
		} finally {
			return ret;
		}
	}

	public static void main(String[] args) {
		try {
			Mailer mail = new Mailer();
			mail.sendMail("Requested OTP", "Hi Vendor,", " You are requested OTP is :: 12333",
					"mohamedsaud.sns@clss.in", "", "mohamedsaud.sns@clss.in");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}