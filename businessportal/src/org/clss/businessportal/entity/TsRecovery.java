package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ts_recovery database table.
 * 
 */
@Entity
@Table(name="ts_recovery")
@NamedQuery(name="TsRecovery.findAll", query="SELECT t FROM TsRecovery t")
public class TsRecovery implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TsRecoveryPK id;

	private String agri;

	@Column(name="AGRI_NAME")
	private String agriName;

	@Column(name="AGRI_POS")
	private String agriPos;

	private String amagri;

	@Column(name="AMAGRI_NAME")
	private String amagriName;

	@Column(name="AMAGRI_POS")
	private String amagriPos;

	private String amah;

	@Column(name="AMAH_NAME")
	private String amahName;

	@Column(name="AMAH_POS")
	private String amahPos;

	private String amcc;

	@Column(name="AMCC_NAME")
	private String amccName;

	@Column(name="AMCC_POS")
	private String amccPos;

	@Column(name="AMT_DIFF_SCAN_QTY_LTR")
	private BigDecimal amtDiffScanQtyLtr;

	private String ardocc;

	@Column(name="ARDOCC_NAME")
	private String ardoccName;

	@Column(name="ARDOCC_POS")
	private String ardoccPos;

	private String ardoqa;

	@Column(name="ARDOQA_NAME")
	private String ardoqaName;

	@Column(name="ARDOQA_POS")
	private String ardoqaPos;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="DIFF_LT")
	private String diffLt;

	@Column(name="DIFF_PER")
	private String diffPer;

	@Column(name="DIFF_SUM_KG_FAT")
	private String diffSumKgFat;

	@Column(name="DIFF_SUM_KG_SNF")
	private String diffSumKgSnf;

	@Column(name="FMILK_SH_AMT")
	private BigDecimal fmilkShAmt;

	private String fte;

	@Column(name="FTE_NAME")
	private String fteName;

	@Column(name="FTE_POS")
	private String ftePos;

	private String fto;

	@Column(name="FTO_NAME")
	private String ftoName;

	@Column(name="FTO_POS")
	private String ftoPos;

	@Column(name="FTS_SH_AMT")
	private BigDecimal ftsShAmt;

	private String gm;

	@Column(name="GM_NAME")
	private String gmName;

	@Column(name="GM_POS")
	private String gmPos;

	private String gmah;

	@Column(name="GMAH_NAME")
	private String gmahName;

	@Column(name="GMAH_POS")
	private String gmahPos;

	@Temporal(TemporalType.DATE)
	@Column(name="HMB_DATE")
	private Date hmbDate;

	@Column(name="HMB_NAME")
	private String hmbName;

	private String ins;

	@Column(name="INS_NAME")
	private String insName;

	@Column(name="INS_POS")
	private String insPos;

	@Column(name="LAST_CHANGED_BY")
	private int lastChangedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CHANGED_ON")
	private Date lastChangedOn;

	private String pname;

	private String rde;

	@Column(name="RDE_NAME")
	private String rdeName;

	@Column(name="RDE_POS")
	private String rdePos;

	private String rdoabc;

	@Column(name="RDOABC_NAME")
	private String rdoabcName;

	@Column(name="RDOABC_POS")
	private String rdoabcPos;

	private String rdocc;

	@Column(name="RDOCC_NAME")
	private String rdoccName;

	@Column(name="RDOCC_POS")
	private String rdoccPos;

	private String rdoqa;

	@Column(name="RDOQA_NAME")
	private String rdoqaName;

	@Column(name="RDOQA_POS")
	private String rdoqaPos;

	@Column(name="SAM_MILK")
	private BigDecimal samMilk;

	private String society;

	private String status;

	@Column(name="SUM_KG_FAT_CENTER")
	private String sumKgFatCenter;

	@Column(name="SUM_KG_FAT_SCAN")
	private String sumKgFatScan;

	@Column(name="SUM_KG_SNF_CENTER")
	private String sumKgSnfCenter;

	@Column(name="SUM_KG_SNF_SCAN")
	private String sumKgSnfScan;

	@Column(name="SUM_LT_CENTER")
	private String sumLtCenter;

	@Column(name="SUM_LT_SCAN")
	private String sumLtScan;

	private String tlah;

	@Column(name="TLAH_NAME")
	private String tlahName;

	@Column(name="TLAH_POS")
	private String tlahPos;

	private String tlcc;

	@Column(name="TLCC_NAME")
	private String tlccName;

	@Column(name="TLCC_POS")
	private String tlccPos;

	private String tlqa;

	@Column(name="TLQA_NAME")
	private String tlqaName;

	@Column(name="TLQA_POS")
	private String tlqaPos;

	private String tltech;

	@Column(name="TLTECH_NAME")
	private String tltechName;

	@Column(name="TLTECH_POS")
	private String tltechPos;

	@Column(name="TOTAL_SOLID")
	private String totalSolid;

	@Column(name="TOTAL_SOLID_AMT")
	private BigDecimal totalSolidAmt;

	@Column(name="TOTAL_TS")
	private BigDecimal totalTs;

	private String vo;

	@Column(name="VO_NAME")
	private String voName;

	@Column(name="VO_POS")
	private String voPos;
	
	
	
	@Column(name="TOTAL_DED")
	private BigDecimal totalDed;

	public TsRecovery() {
	}

	public TsRecoveryPK getId() {
		return this.id;
	}

	public void setId(TsRecoveryPK id) {
		this.id = id;
	}

	public String getAgri() {
		return this.agri;
	}

	public void setAgri(String agri) {
		this.agri = agri;
	}

	public String getAgriName() {
		return this.agriName;
	}

	public void setAgriName(String agriName) {
		this.agriName = agriName;
	}

	public String getAgriPos() {
		return this.agriPos;
	}

	public void setAgriPos(String agriPos) {
		this.agriPos = agriPos;
	}

	public String getAmagri() {
		return this.amagri;
	}

	public void setAmagri(String amagri) {
		this.amagri = amagri;
	}

	public String getAmagriName() {
		return this.amagriName;
	}

	public void setAmagriName(String amagriName) {
		this.amagriName = amagriName;
	}

	public String getAmagriPos() {
		return this.amagriPos;
	}

	public void setAmagriPos(String amagriPos) {
		this.amagriPos = amagriPos;
	}

	public String getAmah() {
		return this.amah;
	}

	public void setAmah(String amah) {
		this.amah = amah;
	}

	public String getAmahName() {
		return this.amahName;
	}

	public void setAmahName(String amahName) {
		this.amahName = amahName;
	}

	public String getAmahPos() {
		return this.amahPos;
	}

	public void setAmahPos(String amahPos) {
		this.amahPos = amahPos;
	}

	public String getAmcc() {
		return this.amcc;
	}

	public void setAmcc(String amcc) {
		this.amcc = amcc;
	}

	public String getAmccName() {
		return this.amccName;
	}

	public void setAmccName(String amccName) {
		this.amccName = amccName;
	}

	public String getAmccPos() {
		return this.amccPos;
	}

	public void setAmccPos(String amccPos) {
		this.amccPos = amccPos;
	}

	public BigDecimal getAmtDiffScanQtyLtr() {
		return this.amtDiffScanQtyLtr;
	}

	public void setAmtDiffScanQtyLtr(BigDecimal amtDiffScanQtyLtr) {
		this.amtDiffScanQtyLtr = amtDiffScanQtyLtr;
	}

	public String getArdocc() {
		return this.ardocc;
	}

	public void setArdocc(String ardocc) {
		this.ardocc = ardocc;
	}

	public String getArdoccName() {
		return this.ardoccName;
	}

	public void setArdoccName(String ardoccName) {
		this.ardoccName = ardoccName;
	}

	public String getArdoccPos() {
		return this.ardoccPos;
	}

	public void setArdoccPos(String ardoccPos) {
		this.ardoccPos = ardoccPos;
	}

	public String getArdoqa() {
		return this.ardoqa;
	}

	public void setArdoqa(String ardoqa) {
		this.ardoqa = ardoqa;
	}

	public String getArdoqaName() {
		return this.ardoqaName;
	}

	public void setArdoqaName(String ardoqaName) {
		this.ardoqaName = ardoqaName;
	}

	public String getArdoqaPos() {
		return this.ardoqaPos;
	}

	public void setArdoqaPos(String ardoqaPos) {
		this.ardoqaPos = ardoqaPos;
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

	public String getDiffLt() {
		return this.diffLt;
	}

	public void setDiffLt(String diffLt) {
		this.diffLt = diffLt;
	}

	public String getDiffPer() {
		return this.diffPer;
	}

	public void setDiffPer(String diffPer) {
		this.diffPer = diffPer;
	}

	public String getDiffSumKgFat() {
		return this.diffSumKgFat;
	}

	public void setDiffSumKgFat(String diffSumKgFat) {
		this.diffSumKgFat = diffSumKgFat;
	}

	public String getDiffSumKgSnf() {
		return this.diffSumKgSnf;
	}

	public void setDiffSumKgSnf(String diffSumKgSnf) {
		this.diffSumKgSnf = diffSumKgSnf;
	}

	public BigDecimal getFmilkShAmt() {
		return this.fmilkShAmt;
	}

	public void setFmilkShAmt(BigDecimal fmilkShAmt) {
		this.fmilkShAmt = fmilkShAmt;
	}

	public String getFte() {
		return this.fte;
	}

	public void setFte(String fte) {
		this.fte = fte;
	}

	public String getFteName() {
		return this.fteName;
	}

	public void setFteName(String fteName) {
		this.fteName = fteName;
	}

	public String getFtePos() {
		return this.ftePos;
	}

	public void setFtePos(String ftePos) {
		this.ftePos = ftePos;
	}

	public String getFto() {
		return this.fto;
	}

	public void setFto(String fto) {
		this.fto = fto;
	}

	public String getFtoName() {
		return this.ftoName;
	}

	public void setFtoName(String ftoName) {
		this.ftoName = ftoName;
	}

	public String getFtoPos() {
		return this.ftoPos;
	}

	public void setFtoPos(String ftoPos) {
		this.ftoPos = ftoPos;
	}

	public BigDecimal getFtsShAmt() {
		return this.ftsShAmt;
	}

	public void setFtsShAmt(BigDecimal ftsShAmt) {
		this.ftsShAmt = ftsShAmt;
	}

	public String getGm() {
		return this.gm;
	}

	public void setGm(String gm) {
		this.gm = gm;
	}

	public String getGmName() {
		return this.gmName;
	}

	public void setGmName(String gmName) {
		this.gmName = gmName;
	}

	public String getGmPos() {
		return this.gmPos;
	}

	public void setGmPos(String gmPos) {
		this.gmPos = gmPos;
	}

	public String getGmah() {
		return this.gmah;
	}

	public void setGmah(String gmah) {
		this.gmah = gmah;
	}

	public String getGmahName() {
		return this.gmahName;
	}

	public void setGmahName(String gmahName) {
		this.gmahName = gmahName;
	}

	public String getGmahPos() {
		return this.gmahPos;
	}

	public void setGmahPos(String gmahPos) {
		this.gmahPos = gmahPos;
	}

	public Date getHmbDate() {
		return this.hmbDate;
	}

	public void setHmbDate(Date hmbDate) {
		this.hmbDate = hmbDate;
	}

	public String getHmbName() {
		return this.hmbName;
	}

	public void setHmbName(String hmbName) {
		this.hmbName = hmbName;
	}

	public String getIns() {
		return this.ins;
	}

	public void setIns(String ins) {
		this.ins = ins;
	}

	public String getInsName() {
		return this.insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getInsPos() {
		return this.insPos;
	}

	public void setInsPos(String insPos) {
		this.insPos = insPos;
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

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getRde() {
		return this.rde;
	}

	public void setRde(String rde) {
		this.rde = rde;
	}

	public String getRdeName() {
		return this.rdeName;
	}

	public void setRdeName(String rdeName) {
		this.rdeName = rdeName;
	}

	public String getRdePos() {
		return this.rdePos;
	}

	public void setRdePos(String rdePos) {
		this.rdePos = rdePos;
	}

	public String getRdoabc() {
		return this.rdoabc;
	}

	public void setRdoabc(String rdoabc) {
		this.rdoabc = rdoabc;
	}

	public String getRdoabcName() {
		return this.rdoabcName;
	}

	public void setRdoabcName(String rdoabcName) {
		this.rdoabcName = rdoabcName;
	}

	public String getRdoabcPos() {
		return this.rdoabcPos;
	}

	public void setRdoabcPos(String rdoabcPos) {
		this.rdoabcPos = rdoabcPos;
	}

	public String getRdocc() {
		return this.rdocc;
	}

	public void setRdocc(String rdocc) {
		this.rdocc = rdocc;
	}

	public String getRdoccName() {
		return this.rdoccName;
	}

	public void setRdoccName(String rdoccName) {
		this.rdoccName = rdoccName;
	}

	public String getRdoccPos() {
		return this.rdoccPos;
	}

	public void setRdoccPos(String rdoccPos) {
		this.rdoccPos = rdoccPos;
	}

	public String getRdoqa() {
		return this.rdoqa;
	}

	public void setRdoqa(String rdoqa) {
		this.rdoqa = rdoqa;
	}

	public String getRdoqaName() {
		return this.rdoqaName;
	}

	public void setRdoqaName(String rdoqaName) {
		this.rdoqaName = rdoqaName;
	}

	public String getRdoqaPos() {
		return this.rdoqaPos;
	}

	public void setRdoqaPos(String rdoqaPos) {
		this.rdoqaPos = rdoqaPos;
	}

	public BigDecimal getSamMilk() {
		return this.samMilk;
	}

	public void setSamMilk(BigDecimal samMilk) {
		this.samMilk = samMilk;
	}

	public String getSociety() {
		return this.society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSumKgFatCenter() {
		return this.sumKgFatCenter;
	}

	public void setSumKgFatCenter(String sumKgFatCenter) {
		this.sumKgFatCenter = sumKgFatCenter;
	}

	public String getSumKgFatScan() {
		return this.sumKgFatScan;
	}

	public void setSumKgFatScan(String sumKgFatScan) {
		this.sumKgFatScan = sumKgFatScan;
	}

	public String getSumKgSnfCenter() {
		return this.sumKgSnfCenter;
	}

	public void setSumKgSnfCenter(String sumKgSnfCenter) {
		this.sumKgSnfCenter = sumKgSnfCenter;
	}

	public String getSumKgSnfScan() {
		return this.sumKgSnfScan;
	}

	public void setSumKgSnfScan(String sumKgSnfScan) {
		this.sumKgSnfScan = sumKgSnfScan;
	}

	public String getSumLtCenter() {
		return this.sumLtCenter;
	}

	public void setSumLtCenter(String sumLtCenter) {
		this.sumLtCenter = sumLtCenter;
	}

	public String getSumLtScan() {
		return this.sumLtScan;
	}

	public void setSumLtScan(String sumLtScan) {
		this.sumLtScan = sumLtScan;
	}

	public String getTlah() {
		return this.tlah;
	}

	public void setTlah(String tlah) {
		this.tlah = tlah;
	}

	public String getTlahName() {
		return this.tlahName;
	}

	public void setTlahName(String tlahName) {
		this.tlahName = tlahName;
	}

	public String getTlahPos() {
		return this.tlahPos;
	}

	public void setTlahPos(String tlahPos) {
		this.tlahPos = tlahPos;
	}

	public String getTlcc() {
		return this.tlcc;
	}

	public void setTlcc(String tlcc) {
		this.tlcc = tlcc;
	}

	public String getTlccName() {
		return this.tlccName;
	}

	public void setTlccName(String tlccName) {
		this.tlccName = tlccName;
	}

	public String getTlccPos() {
		return this.tlccPos;
	}

	public void setTlccPos(String tlccPos) {
		this.tlccPos = tlccPos;
	}

	public String getTlqa() {
		return this.tlqa;
	}

	public void setTlqa(String tlqa) {
		this.tlqa = tlqa;
	}

	public String getTlqaName() {
		return this.tlqaName;
	}

	public void setTlqaName(String tlqaName) {
		this.tlqaName = tlqaName;
	}

	public String getTlqaPos() {
		return this.tlqaPos;
	}

	public void setTlqaPos(String tlqaPos) {
		this.tlqaPos = tlqaPos;
	}

	public String getTltech() {
		return this.tltech;
	}

	public void setTltech(String tltech) {
		this.tltech = tltech;
	}

	public String getTltechName() {
		return this.tltechName;
	}

	public void setTltechName(String tltechName) {
		this.tltechName = tltechName;
	}

	public String getTltechPos() {
		return this.tltechPos;
	}

	public void setTltechPos(String tltechPos) {
		this.tltechPos = tltechPos;
	}

	public String getTotalSolid() {
		return this.totalSolid;
	}

	public void setTotalSolid(String totalSolid) {
		this.totalSolid = totalSolid;
	}

	public BigDecimal getTotalSolidAmt() {
		return this.totalSolidAmt;
	}

	public void setTotalSolidAmt(BigDecimal totalSolidAmt) {
		this.totalSolidAmt = totalSolidAmt;
	}

	public BigDecimal getTotalTs() {
		return this.totalTs;
	}

	public void setTotalTs(BigDecimal totalTs) {
		this.totalTs = totalTs;
	}

	public String getVo() {
		return this.vo;
	}

	public void setVo(String vo) {
		this.vo = vo;
	}

	public String getVoName() {
		return this.voName;
	}

	public void setVoName(String voName) {
		this.voName = voName;
	}

	public String getVoPos() {
		return this.voPos;
	}

	public void setVoPos(String voPos) {
		this.voPos = voPos;
	}
	
	public BigDecimal getTotalDed() {
		return this.totalDed;
	}

	public void setTotalDed(BigDecimal totalDed) {
		this.totalDed = totalDed;
	}

}