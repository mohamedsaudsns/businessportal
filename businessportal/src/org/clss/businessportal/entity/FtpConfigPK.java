package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ftp_config database table.
 * 
 */
@Embeddable
public class FtpConfigPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FTP_CONFIG_ID", unique=true, nullable=false)
	private int ftpConfigId;

	@Column(name="MENU_TYPE", unique=true, nullable=false, length=45)
	private String menuType;

	@Column(name="CONFIG_TYPE", unique=true, nullable=false, length=45)
	private String configType;

	public FtpConfigPK() {
	}
	public int getFtpConfigId() {
		return this.ftpConfigId;
	}
	public void setFtpConfigId(int ftpConfigId) {
		this.ftpConfigId = ftpConfigId;
	}
	public String getMenuType() {
		return this.menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getConfigType() {
		return this.configType;
	}
	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FtpConfigPK)) {
			return false;
		}
		FtpConfigPK castOther = (FtpConfigPK)other;
		return 
			(this.ftpConfigId == castOther.ftpConfigId)
			&& this.menuType.equals(castOther.menuType)
			&& this.configType.equals(castOther.configType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ftpConfigId;
		hash = hash * prime + this.menuType.hashCode();
		hash = hash * prime + this.configType.hashCode();
		
		return hash;
	}
}