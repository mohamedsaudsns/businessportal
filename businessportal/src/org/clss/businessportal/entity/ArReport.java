package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ar_report database table.
 * 
 */
@Entity
@Table(name="ar_report")
@NamedQuery(name="ArReport.findAll", query="SELECT a FROM ArReport a")
public class ArReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArReportPK id;

	@Column(precision=13, scale=2)
	private BigDecimal amount;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DB_CR_IND", length=1)
	private String dbCrInd;

	@Column(name="DB_CR_IND_DESC", length=2)
	private String dbCrIndDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="DOC_DATE")
	private Date docDate;

	@Column(name="ITEM_TEXT", length=150)
	private String itemText;

	@Column(name="ITEM_TYPE", length=45)
	private String itemType;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	@Column(name="NET_AMOUNT", precision=13, scale=2)
	private BigDecimal netAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="POSTING_DATE")
	private Date postingDate;

	@Column(name="REF_DOC_NO", length=45)
	private String refDocNo;

	@Column(name="SP_GL_IND", length=45)
	private String spGlInd;

	@Column(length=1)
	private String status;

	@Column(name="TDS_AMOUNT", precision=13, scale=2)
	private BigDecimal tdsAmount;

	//bi-directional many-to-one association to CustomerMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="COMP_CODE", referencedColumnName="COMP_CODE", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="CUSTOMER_CODE", referencedColumnName="CUSTOMER_CODE", nullable=false, insertable=false, updatable=false)
		})
	private CustomerMaster customerMaster;

	//bi-directional many-to-one association to DocTypeMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DOC_TYPE")
	private DocTypeMaster docTypeMaster;

	public ArReport() {
	}

	public ArReportPK getId() {
		return this.id;
	}

	public void setId(ArReportPK id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public CustomerMaster getCustomerMaster() {
		return this.customerMaster;
	}

	public void setCustomerMaster(CustomerMaster customerMaster) {
		this.customerMaster = customerMaster;
	}

	public DocTypeMaster getDocTypeMaster() {
		return this.docTypeMaster;
	}

	public void setDocTypeMaster(DocTypeMaster docTypeMaster) {
		this.docTypeMaster = docTypeMaster;
	}

}