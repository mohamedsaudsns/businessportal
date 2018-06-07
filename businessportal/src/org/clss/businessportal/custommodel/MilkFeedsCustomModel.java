package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class MilkFeedsCustomModel implements Serializable  {
	
	private String inputDate;
	private String sumOfFeed;
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getSumOfFeed() {
		return sumOfFeed;
	}
	public void setSumOfFeed(String sumOfFeed) {
		this.sumOfFeed = sumOfFeed;
	}
	
	
	
	
	
}
