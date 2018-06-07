package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ap_report database table.
 * 
 */
@Entity
@Table(name="ap_report")
@NamedQuery(name="ApReport.findAll", query="SELECT a FROM ApReport a")
public class ApReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ApReportPK id;

	@Column(name="ALLOC_NMBR")
	private String allocNmbr;

	private BigDecimal amount;

	private String bktxt;

	@Column(name="CLR_DOC_NO")
	private String clrDocNo;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DB_CR_IND")
	private String dbCrInd;

	@Column(name="DB_CR_IND_DESC")
	private String dbCrIndDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="DOC_DATE")
	private Date docDate;

	@Column(name="DOC_TYPE")
	private String docType;

	@Column(name="ITEM_TEXT")
	private String itemText;

	@Column(name="ITEM_TYPE")
	private String itemType;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="NET_AMOUNT")
	private BigDecimal netAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="POSTING_DATE")
	private Date postingDate;

	@Column(name="REF_DOC_NO")
	private String refDocNo;

	@Column(name="SP_GL_IND")
	private String spGlInd;

	private String status;

	@Column(name="TDS_AMOUNT")
	private BigDecimal tdsAmount;

	@Column(name="VENDOR_ACC_GRP_CODE")
	private String vendorAccGrpCode;

	public ApReport() {
	}

	public ApReportPK getId() {
		return this.id;
	}

	public void setId(ApReportPK id) {
		this.id = id;
	}

	public String getAllocNmbr() {
		return this.allocNmbr;
	}

	public void setAllocNmbr(String allocNmbr) {
		this.allocNmbr = allocNmbr;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBktxt() {
		return this.bktxt;
	}

	public void setBktxt(String bktxt) {
		this.bktxt = bktxt;
	}

	public String getClrDocNo() {
		return this.clrDocNo;
	}

	public void setClrDocNo(String clrDocNo) {
		this.clrDocNo = clrDocNo;
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

	public String getDbCrInd() {
		return this.dbCrInd;
	}

	public void setDbCrInd(String dbCrInd) {
		this.dbCrInd = dbCrInd;
	}

	public String getDbCrIndDesc() {
		return this.dbCrIndDesc;
	}

	public void setDbCrIndDesc(String dbCrIndDesc) {
		this.dbCrIndDesc = dbCrIndDesc;
	}

	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getItemText() {
		return this.itemText;
	}

	public void setItemText(String itemText) {
		this.itemText = itemText;
	}

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
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

	public BigDecimal getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public Date getPostingDate() {
		return this.postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public String getRefDocNo() {
		return this.refDocNo;
	}

	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}

	public String getSpGlInd() {
		return this.spGlInd;
	}

	public void setSpGlInd(String spGlInd) {
		this.spGlInd = spGlInd;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTdsAmount() {
		return this.tdsAmount;
	}

	public void setTdsAmount(BigDecimal tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public String getVendorAccGrpCode() {
		return this.vendorAccGrpCode;
	}

	public void setVendorAccGrpCode(String vendorAccGrpCode) {
		this.vendorAccGrpCode = vendorAccGrpCode;
	}

}