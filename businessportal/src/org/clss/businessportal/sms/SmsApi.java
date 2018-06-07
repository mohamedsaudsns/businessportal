package org.clss.businessportal.sms;

/**
*
* @author Mohamed Saud SNS
*/


import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class SmsApi {
	
	
	
	public static void sentSms(String smsUrl,String mobileNo,String smsMassage,String userName,String password,String pId){
		
		   try {
				
			 //  String req_url="http://boancomm.net/boansms/boansmsinterface.aspx?mobileno=9043484903&smsmsg=TEST%20SMS%20FROM%20BOANC%20COMM%20&uname=hatsunotp&pwd=hatsunotp2017sms&pid=925";
		          
		          String req_url1=""+smsUrl+"?mobileno="+ URLEncoder.encode(mobileNo, "UTF-8")+"&smsmsg="+URLEncoder.encode(smsMassage, "UTF-8")+"&uname="+URLEncoder.encode(userName, "UTF-8")+"&pwd="+URLEncoder.encode(password, "UTF-8")+"&pid="+URLEncoder.encode(pId, "UTF-8")+"";




		          URL url = new URL(req_url1);
		          HttpURLConnection uc = (HttpURLConnection)url.openConnection();

		          System.out.println(uc.getResponseMessage());

		          uc.disconnect();

		  } catch(Exception ex) {
		          System.out.println(ex.getMessage());

		  }
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sentSms("http://boancomm.net/boansms/boansmsinterface.aspx","9043484903","Hi, User Otp Code ","hatsunotp","hatsunotp2017sms","925");

	}

}
