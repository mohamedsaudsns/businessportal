package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the daily_scheduler_log database table.
 * 
 */
@Embeddable
public class DailySchedulerLogPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MODULE_NAME")
	private String moduleName;

	private String menu;

	@Column(name="FUNCTION_NAME")
	private String functionName;

	public DailySchedulerLogPK() {
	}
	public String getModuleName() {
		return this.moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getMenu() {
		return this.menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getFunctionName() {
		return this.functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DailySchedulerLogPK)) {
			return false;
		}
		DailySchedulerLogPK castOther = (DailySchedulerLogPK)other;
		return 
			this.moduleName.equals(castOther.moduleName)
			&& this.menu.equals(castOther.menu)
			&& this.functionName.equals(castOther.functionName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moduleName.hashCode();
		hash = hash * prime + this.menu.hashCode();
		hash = hash * prime + this.functionName.hashCode();
		
		return hash;
	}
}