package org.clss.businessportal.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;

/**
*
* @author Mohamed Saud SNS
*/


import java.text.ParseException;

/**
 * 
 * @author mohamedsaud sns
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class Util {

	public String separateDigit(String str) {
		String number = "";
		String letter = "";
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (Character.isDigit(a)) {
				number = number + a;

			} else {
				letter = letter + a;

			}
		}
		return number;

	}
	
	public static String jsDateFormateToJavaformat(String inputDate){
		
		
		 
	     DateFormat inputFormat = new SimpleDateFormat(
	             "E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH);
	     Date date=null;
			try {
				date = inputFormat.parse(inputDate);
			      System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	     System.out.println(formatter.format(date));
			 
			    return formatter.format(date);
				
			}
	
	
	
	
	
	
	public static String indianRupeeFormat(String value) {
		String values[] = null;
		if (value.indexOf(".") != -1) {
			values = value.split("\\.");
			value = values[0];
		}
		value = value.replace(",", "");
		char lastDigit = value.charAt(value.length() - 1);
		String result = "";
		int len = value.length() - 1;
		int nDigits = 0;

		for (int i = len - 1; i >= 0; i--) {
			result = value.charAt(i) + result;
			nDigits++;
			if (((nDigits % 2) == 0) && (i > 0)) {
				result = "," + result;
			}
		}
		if (values != null) {
			return (result + lastDigit + "." + values[1]);
		} else {
			return (result + lastDigit);
		}
	}
	
	public static String getMonthDescByYear(int year){
		 String monthString="";
	    String[] monthDesc = {"January",      
	    		   "February",
	    		   "March",        
	    		   "April",        
	    		   "May",          
	    		   "June",         
	    		   "July",         
	    		   "August",       
	    		   "September",    
	    		   "October",      
	    		   "November",     
	    		   "December"};
	     
	     
	      if(year>0){
	      monthString = monthDesc[year-1];
	      }else{
	      monthString = "Invalid month";
	      }
	      return monthString;
		
	}
	
	
	public static String getAvgByTwoString(String value1,String value2){
		
		BigDecimal resultBig= new BigDecimal("0"); 
		String result="";
		
		resultBig=new BigDecimal(value1).divide(new BigDecimal(value2), 2, RoundingMode.HALF_UP);
	
		result=""+resultBig;
		return result;
	}
	
	public static String getAvgByTwoString1(String value1,String value2){
		
		BigDecimal resultBig= new BigDecimal("0"); 
		String result="";
		
		resultBig=new BigDecimal(value1).divide(new BigDecimal(value2),5,RoundingMode.DOWN );
	
		result=""+resultBig;
		return result;
	}

	public static boolean getMinusSpecialCharacterCount(String s) {
		boolean result=false;
		
	     if (s == null || s.trim().isEmpty()) {
	         System.out.println("Incorrect format of string");
	         
	         result=false;
	         return result;
	     }
	     Pattern p = Pattern.compile("-");
	     Matcher m = p.matcher(s);
	    // boolean b = m.matches();
	     boolean b = m.find();
	     if (b == true){
	    	 result=true;
//	        System.out.println("There is a special character in my string ");
	     } else{
	    	 
	    	 result=false;
	         System.out.println("There is no special char.");
	     }
	     return result;
	 }
	
	
	
	public static String convertmonthYearToMonthEndDay(String monthYear){
		
		String result="";
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM-yyyy");
	    Date date;
		try {
			date = (dateFormat).parse(monthYear);
			 Calendar calendar = Calendar.getInstance();
			    calendar.setTime(date);
			    int noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
			    String properFormattedDate = simpleDateFormat.format(date);
			    result=properFormattedDate+"-"+String.valueOf(noOfDays);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	    return result;
	}
	
	
	public static String convertFullMonthToMonthNo(String monthYear){
		
		String result="";
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM-yyyy");
	    Date date;
		try {
			date = (dateFormat).parse(monthYear);
			 Calendar calendar = Calendar.getInstance();
			    calendar.setTime(date);
			    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
			    String properFormattedDate = simpleDateFormat.format(date);
			    result=""+properFormattedDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	    return result;
	}
	
	
	
	
	public static java.util.Date calculateMonthEndDate(int month, int year) {
	    int[] daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    int day = daysInAMonth[month];
	    boolean isLeapYear = new GregorianCalendar().isLeapYear(year);

	    if (isLeapYear && month == 2) {
	        day++;
	    }
	    GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
	    java.util.Date monthEndDate = new java.util.Date(gc.getTime().getTime());
	    return monthEndDate;
	}
	
	
	
//	public static java.util.Date calculateMonthEndDate(int month, int year) {
//	    int[] daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//	    int day = daysInAMonth[month];
//	    boolean isLeapYear = new GregorianCalendar().isLeapYear(year);
//
//	    if (isLeapYear && month == 2) {
//	        day++;
//	    }
//	    GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
//	    java.util.Date monthEndDate = new java.util.Date(gc.getTime().getTime());
//	    return monthEndDate;
//	}
//	
	
	
	
	
	public  String generateSessionKey(int length){
		String alphabet = 
		        new String("0123456789"); //9
		int n = alphabet.length(); //10

		String result = new String(); 
		Random r = new Random(); //11

		for (int i=0; i<length; i++) //12
		    result = result + alphabet.charAt(r.nextInt(n)); //13

		return result;
		}
	
	
	public  char[] generateOtp(int len)
	{
        System.out.print("Your new password is : ");
 
   
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

 
 
        String values = Capital_chars + Small_chars +
                        numbers ;
 
        // Using random method
        Random rndm_method = new Random();
 
        char[] password = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            password[i] =
              values.charAt(rndm_method.nextInt(values.length()));
 
        }
        return password;
    }
	
	
	public static long getNoOfDaysBtwnDates(String expiryDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date expDate = null;
	    long diff = 0;
	    long noOfDays = 0;
	    try {

	        expDate = formatter.parse(expiryDate);
	        //logger.info("Expiry Date is " + expDate);
	       // logger.info(formatter.format(expDate));

	        Date createdDate = new Date();
	        diff = createdDate.getTime() - expDate.getTime();
	        noOfDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	        long a = TimeUnit.DAYS.toDays(noOfDays);
	       // logger.info("No of Day after difference are - " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//	        System.out.println(a);
//	        System.out.println(noOfDays);

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    return noOfDays;
	}
	
	
	
	public static boolean getSpecialCharacterCheck(String s) {
	     if (s == null || s.trim().isEmpty()) {
	         System.out.println("Incorrect format of string");
	         return false;
	     }
	     Pattern p = Pattern.compile("-");
	     Matcher m = p.matcher(s);
	    // boolean b = m.matches();
	     boolean b = m.find();
//	     if (b == true)
////	        System.out.println("There is a special character in my string ");
//	     else
////	         System.out.println("There is no special char.");
	     return b;
	 }
	
	public static String convertToSpecialCharacterAmount(String s) {
		
		String result="";
		String splRemove="",rupeeFormat="";
		
		if(getSpecialCharacterCheck(s)) {
			
			splRemove=s.replace("-", "");
			
			rupeeFormat=indianRupeeFormat(splRemove);
			result=""+rupeeFormat;
			
		}else {
			rupeeFormat=indianRupeeFormat(s);
			result=""+rupeeFormat;
		}
		
		

		
		
		return result;
		
	}
	
	
	
	public static String addZero(String ipString, int TotalLen) {
		String opstring = "";
		if (ipString.length() < TotalLen) {
			int diff = TotalLen - ipString.length();
			while (diff > 0) {
				opstring += "0";
				diff--;
			}
			opstring += ipString;
		}
		
		System.out.println("opstring.."+opstring);

		return opstring;
	}
	
	 public Date changeDateDBFormat(String str) {
	        String newDateString = null;
	        final String OLD_FORMAT = "dd/MM/yyyy";
	        final String NEW_FORMAT = "yyyy-MM-dd";
	        Date retdate = new Date();
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
	            Date d = sdf.parse(str);
	            sdf.applyPattern(NEW_FORMAT);
	            newDateString = sdf.format(d);
//	            System.out.println("sdate=="+newDateString);
	            retdate = sdf.parse(newDateString);
//	            System.out.println(retdate);
	        } catch (Exception ex) {
	        }
	        return retdate;
	    }
	 
	 public Date changeDateUserFormat(String str) {
	        String newDateString = null;
	        final String NEW_FORMAT = "dd/MM/yyyy";
	        final String OLD_FORMAT = "yyyy-MM-dd";
	        Date retdate = new Date();
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
	            Date d = sdf.parse(str);
	            sdf.applyPattern(NEW_FORMAT);
	            newDateString = sdf.format(d);
//	            System.out.println("sdate=="+newDateString);
	            retdate = sdf.parse(newDateString);
//	            System.out.println(retdate);
	        } catch (Exception ex) {
	        }
	        return retdate;
	    }

	 public String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {
		    Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
		    SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
		    String parsedDate = formatter.format(initDate);
		return parsedDate;
	}
	 
	 public static String getIP(HttpServletRequest request) {
			String ip = request.getHeader("X-Forwarded-For");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {

				ip = request.getHeader("Proxy-Client-IP");
				//System.out.println("ip 1 adress....." + ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {

				ip = request.getHeader("WL-Proxy-Client-IP");
			//	System.out.println("ip 2 adress....." + ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			//	System.out.println("ip 3 adress....." + ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");

				//System.out.println("ip 4 adress....." + ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
				//System.out.println("ip 5 adress....." + ip);
			}

			return ip;
			
		}
		
		public static String getServerIP() throws UnknownHostException {
			
			String server_ip = "";
			InetAddress inetAddress = InetAddress.getLocalHost();
			server_ip = inetAddress.getHostAddress();
			
			return server_ip;
		}
}
