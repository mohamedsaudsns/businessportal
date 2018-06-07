package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doc_type_master database table.
 * 
 */
@Entity
@Table(name="doc_type_master")
@NamedQuery(name="DocTypeMaster.findAll", query="SELECT d FROM DocTypeMaster d")
public class DocTypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DOC_TYPE", unique=true, nullable=false, length=2)
	private String docType;

	@Column(name="DOC_TYPE_DESC", length=100)
	private String docTypeDesc;

	@Column(length=1)
	private String status;

//	//bi-directional many-to-one association to ApReport
//	@OneToMany(mappedBy="docTypeMaster")
//	private List<ApReport> apReports;

	//bi-directional many-to-one association to ArReport
	@OneToMany(mappedBy="docTypeMaster")
	private List<ArReport> arReports;

	public DocTypeMaster() {
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocTypeDesc() {
		return this.docTypeDesc;
	}

	public void setDocTypeDesc(String docTypeDesc) {
		this.docTypeDesc = docTypeDesc;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public List<ApReport> getApReports() {
//		return this.apReports;
//	}
//
//	public void setApReports(List<ApReport> apReports) {
//		this.apReports = apReports;
//	}
//
//	public ApReport addApReport(ApReport apReport) {
//		getApReports().add(apReport);
//		apReport.setDocTypeMaster(this);
//
//		return apReport;
//	}
//
//	public ApReport removeApReport(ApReport apReport) {
//		getApReports().remove(apReport);
//		apReport.setDocTypeMaster(null);
//
//		return apReport;
//	}

	public List<ArReport> getArReports() {
		return this.arReports;
	}

	public void setArReports(List<ArReport> arReports) {
		this.arReports = arReports;
	}

	public ArReport addArReport(ArReport arReport) {
		getArReports().add(arReport);
		arReport.setDocTypeMaster(this);

		return arReport;
	}

	public ArReport removeArReport(ArReport arReport) {
		getArReports().remove(arReport);
		arReport.setDocTypeMaster(null);

		return arReport;
	}

}