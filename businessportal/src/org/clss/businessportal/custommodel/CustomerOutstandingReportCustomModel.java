package org.clss.businessportal.custommodel;

import java.io.Serializable;

/**
*
* @author Mohamed Saud SNS
*/


public class CustomerOutstandingReportCustomModel implements Serializable {
	
	

	String compCode;
	String customerCode;
	String customerName;
	String docNo;
	String fiYear;
	String docType;
	String docTypeName;
	String docDate;
	String postingDate;
	String amount;
	String db_ind;
	String creditAmount;
	String debitAmount;
	String to15;
	String to30;
	String to45;
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getFiYear() {
		return fiYear;
	}
	public void setFiYear(String fiYear) {
		this.fiYear = fiYear;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocTypeName() {
		return docTypeName;
	}
	public void setDocTypeName(String docTypeName) {
		this.docTypeName = docTypeName;
	}
	public String getDocDate() {
		return docDate;
	}
	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDb_ind() {
		return db_ind;
	}
	public void setDb_ind(String db_ind) {
		this.db_ind = db_ind;
	}
	public String getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(String debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getTo15() {
		return to15;
	}
	public void setTo15(String to15) {
		this.to15 = to15;
	}
	public String getTo30() {
		return to30;
	}
	public void setTo30(String to30) {
		this.to30 = to30;
	}
	public String getTo45() {
		return to45;
	}
	public void setTo45(String to45) {
		this.to45 = to45;
	}
	
	
}
