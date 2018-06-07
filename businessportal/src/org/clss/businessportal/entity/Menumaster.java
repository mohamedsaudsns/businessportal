package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menumaster database table.
 * 
 */
@Entity
@Table(name="menumaster")
@NamedQuery(name="Menumaster.findAll", query="SELECT m FROM Menumaster m")
public class Menumaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENU_ID", unique=true, nullable=false)
	private int menuId;

	@Column(name="MENU_DESC", nullable=false, length=100)
	private String menuDesc;

	@Column(name="MENU_VALUE", length=100)
	private String menuValue;

	@Column(length=45)
	private String status;

	public Menumaster() {
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuValue() {
		return this.menuValue;
	}

	public void setMenuValue(String menuValue) {
		this.menuValue = menuValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}