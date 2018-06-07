package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the po_list database table.
 * 
 */
@Entity
@Table(name="po_list")
@NamedQuery(name="PoList.findAll", query="SELECT p FROM PoList p")
public class PoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PoListPK id;

	@Column(name="ACC_ASSIGN_CAT", length=1)
	private String accAssignCat;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DOC_CAT", length=1)
	private String docCat;

	@Temporal(TemporalType.DATE)
	@Column(name="DOC_DATE")
	private Date docDate;

	@Column(name="GROSS_VALUE", precision=10, scale=2)
	private BigDecimal grossValue;

	@Column(name="ITEM_CAT", length=1)
	private String itemCat;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="MATERIAL_CODE", length=20)
	private String materialCode;

	@Column(name="NET_VALUE", precision=10, scale=2)
	private BigDecimal netValue;

	@Column(name="RELEASE_STATUS", length=10)
	private String releaseStatus;

	@Column(name="SHORT_TEXT", length=50)
	private String shortText;

	@Column(length=1)
	private String status;

	public PoList() {
	}

	public PoListPK getId() {
		return this.id;
	}

	public void setId(PoListPK id) {
		this.id = id;
	}

	public String getAccAssignCat() {
		return this.accAssignCat;
	}

	public void setAccAssignCat(String accAssignCat) {
		this.accAssignCat = accAssignCat;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDocCat() {
		return this.docCat;
	}

	public void setDocCat(String docCat) {
		this.docCat = docCat;
	}

	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public BigDecimal getGrossValue() {
		return this.grossValue;
	}

	public void setGrossValue(BigDecimal grossValue) {
		this.grossValue = grossValue;
	}

	public String getItemCat() {
		return this.itemCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public int getLastChangedBy() {
		return this.lastChangedBy;
	}

	public void setLastChangedBy(int lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	public Date getLastChangedOn() {
		return this.lastChangedOn;
	}

	public void setLastChangedOn(Date lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}

	public String getMaterialCode() {
		return this.materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public BigDecimal getNetValue() {
		return this.netValue;
	}

	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}

	public String getReleaseStatus() {
		return this.releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public String getShortText() {
		return this.shortText;
	}

	public void setShortText(String shortText) {
		this.shortText = shortText;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}