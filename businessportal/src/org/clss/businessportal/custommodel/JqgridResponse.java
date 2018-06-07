/*
 *
 * 
---------------------------------------------------------------------

Program Name: JqgridResponse.java

Author      :  Mohamed Saud SNS                          Date : 4 Aug, 2017

---------------------------------------------------------------------

Description







---------------------------------------------------------------------
Corrections
---------------------------------------------------------------------


Name            Date      Version                ECCO     Reason



---------------------------------------------------------------------
Copyright : © 2017  Client Linx Software Pvt., Ltd.
---------------------------------------------------------------------
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.clss.businessportal.custommodel;

/**
*
* @author Mohamed Saud SNS
*/

import java.util.List;
 
public class JqgridResponse<T> {
 
	/**
	 * Current page
	 */
//	private String page;
	
	/**
	 * Total pages
	 */
//	private String total;
	
	/**
	 * Total number of records
	 */
//	private String records;
	
	/**
	 * Contains the actual data
	 */
	private List<T> rows;
	public JqgridResponse() {}
	
        public JqgridResponse(List<T> rows) 
        {
	    this.rows = rows;
        }
//	public JqgridResponse(String page, String total, String records,
//			List<T> rows) {
//		super();
//		this.page = page;
//		this.total = total;
//		this.records = records;
//		this.rows = rows;
//	}

//    public String getPage() {
//        return page;
//    }
//
//    public void setPage(String page) {
//        this.page = page;
//    }
//
//    public String getTotal() {
//        return total;
//    }
//
//    public void setTotal(String total) {
//        this.total = total;
//    }
//
//    public String getRecords() {
//        return records;
//    }
//
//    public void setRecords(String records) {
//        this.records = records;
//    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
 
	
 
//	@Override
//	public String toString() {
//            
//		return "[{ \"CLIENT0_0_\": \"test\", \"LANGUAGE2_0_0_\": \"67\",  \"AENAM0_0_\": \"ravi\",\"CHTIM0_0_\":\"123\",\"CRTIM0_0_\":\"123\",\"ERNAM0_0_\":\"123\",\"ERSDA0_0_\":\"132\",\"LAEDA0_0_\":\"312\",\"LANGUAGE9_0_0_\":\"dgsg\",\"LANGUAGE10_0_0_\":\"wtgsdf\"}]";
//	}
}