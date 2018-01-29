package eshviewer.data;
// Generated Jan 29, 2018 4:14:35 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * CodeValue generated by hbm2java
 */
@Entity
@Table(name="CODE_VALUE"
    ,schema="V500"
    , uniqueConstraints = @UniqueConstraint(columnNames={"CODE_SET", "CODE_VALUE"}) 
)
public class CodeValue  implements java.io.Serializable {


     private BigDecimal codeValue;
     private BigDecimal codeSet;
     private String cdfMeaning;
     private String display;
     private String displayKey;
     private String description;
     private String definition;
     private BigDecimal collationSeq;
     private BigDecimal activeTypeCd;
     private BigDecimal activeInd;
     private Date activeDtTm;
     private Date inactiveDtTm;
     private Date updtDtTm;
     private BigDecimal updtId;
     private BigDecimal updtCnt;
     private BigDecimal updtTask;
     private BigDecimal updtApplctx;
     private Date beginEffectiveDtTm;
     private Date endEffectiveDtTm;
     private BigDecimal dataStatusCd;
     private Date dataStatusDtTm;
     private BigDecimal dataStatusPrsnlId;
     private BigDecimal activeStatusPrsnlId;
     private String cki;
     private String displayKeyNls;
     private String conceptCki;
     private String displayKeyANls;
     private Date lastUtcTs;
     private Set<CodeValueAlias> codeValueAliases = new HashSet<CodeValueAlias>(0);

    public CodeValue() {
    }

	
   
     @Id 

    
    @Column(name="CODE_VALUE", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getCodeValue() {
        return this.codeValue;
    }
    
    public void setCodeValue(BigDecimal codeValue) {
        this.codeValue = codeValue;
    }

    
    @Column(name="CODE_SET", nullable=false, precision=22, scale=0)
    public BigDecimal getCodeSet() {
        return this.codeSet;
    }
    
    public void setCodeSet(BigDecimal codeSet) {
        this.codeSet = codeSet;
    }

    
    @Column(name="CDF_MEANING", length=12)
    public String getCdfMeaning() {
        return this.cdfMeaning;
    }
    
    public void setCdfMeaning(String cdfMeaning) {
        this.cdfMeaning = cdfMeaning;
    }

    
    @Column(name="DISPLAY", length=40)
    public String getDisplay() {
        return this.display;
    }
    
    public void setDisplay(String display) {
        this.display = display;
    }

    
    @Column(name="DISPLAY_KEY", length=40)
    public String getDisplayKey() {
        return this.displayKey;
    }
    
    public void setDisplayKey(String displayKey) {
        this.displayKey = displayKey;
    }

    
    @Column(name="DESCRIPTION", length=60)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="DEFINITION", length=100)
    public String getDefinition() {
        return this.definition;
    }
    
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    
    @Column(name="COLLATION_SEQ", precision=22, scale=0)
    public BigDecimal getCollationSeq() {
        return this.collationSeq;
    }
    
    public void setCollationSeq(BigDecimal collationSeq) {
        this.collationSeq = collationSeq;
    }

    
    @Column(name="ACTIVE_TYPE_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getActiveTypeCd() {
        return this.activeTypeCd;
    }
    
    public void setActiveTypeCd(BigDecimal activeTypeCd) {
        this.activeTypeCd = activeTypeCd;
    }

    
    @Column(name="ACTIVE_IND", precision=22, scale=0)
    public BigDecimal getActiveInd() {
        return this.activeInd;
    }
    
    public void setActiveInd(BigDecimal activeInd) {
        this.activeInd = activeInd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ACTIVE_DT_TM", length=7)
    public Date getActiveDtTm() {
        return this.activeDtTm;
    }
    
    public void setActiveDtTm(Date activeDtTm) {
        this.activeDtTm = activeDtTm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INACTIVE_DT_TM", length=7)
    public Date getInactiveDtTm() {
        return this.inactiveDtTm;
    }
    
    public void setInactiveDtTm(Date inactiveDtTm) {
        this.inactiveDtTm = inactiveDtTm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="UPDT_DT_TM", nullable=false, length=7)
    public Date getUpdtDtTm() {
        return this.updtDtTm;
    }
    
    public void setUpdtDtTm(Date updtDtTm) {
        this.updtDtTm = updtDtTm;
    }

    
    @Column(name="UPDT_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getUpdtId() {
        return this.updtId;
    }
    
    public void setUpdtId(BigDecimal updtId) {
        this.updtId = updtId;
    }

    
    @Column(name="UPDT_CNT", nullable=false, precision=22, scale=0)
    public BigDecimal getUpdtCnt() {
        return this.updtCnt;
    }
    
    public void setUpdtCnt(BigDecimal updtCnt) {
        this.updtCnt = updtCnt;
    }

    
    @Column(name="UPDT_TASK", nullable=false, precision=22, scale=0)
    public BigDecimal getUpdtTask() {
        return this.updtTask;
    }
    
    public void setUpdtTask(BigDecimal updtTask) {
        this.updtTask = updtTask;
    }

    
    @Column(name="UPDT_APPLCTX", nullable=false, precision=22, scale=0)
    public BigDecimal getUpdtApplctx() {
        return this.updtApplctx;
    }
    
    public void setUpdtApplctx(BigDecimal updtApplctx) {
        this.updtApplctx = updtApplctx;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="BEGIN_EFFECTIVE_DT_TM", length=7)
    public Date getBeginEffectiveDtTm() {
        return this.beginEffectiveDtTm;
    }
    
    public void setBeginEffectiveDtTm(Date beginEffectiveDtTm) {
        this.beginEffectiveDtTm = beginEffectiveDtTm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="END_EFFECTIVE_DT_TM", nullable=false, length=7)
    public Date getEndEffectiveDtTm() {
        return this.endEffectiveDtTm;
    }
    
    public void setEndEffectiveDtTm(Date endEffectiveDtTm) {
        this.endEffectiveDtTm = endEffectiveDtTm;
    }

    
    @Column(name="DATA_STATUS_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getDataStatusCd() {
        return this.dataStatusCd;
    }
    
    public void setDataStatusCd(BigDecimal dataStatusCd) {
        this.dataStatusCd = dataStatusCd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DATA_STATUS_DT_TM", length=7)
    public Date getDataStatusDtTm() {
        return this.dataStatusDtTm;
    }
    
    public void setDataStatusDtTm(Date dataStatusDtTm) {
        this.dataStatusDtTm = dataStatusDtTm;
    }

    
    @Column(name="DATA_STATUS_PRSNL_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getDataStatusPrsnlId() {
        return this.dataStatusPrsnlId;
    }
    
    public void setDataStatusPrsnlId(BigDecimal dataStatusPrsnlId) {
        this.dataStatusPrsnlId = dataStatusPrsnlId;
    }

    
    @Column(name="ACTIVE_STATUS_PRSNL_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getActiveStatusPrsnlId() {
        return this.activeStatusPrsnlId;
    }
    
    public void setActiveStatusPrsnlId(BigDecimal activeStatusPrsnlId) {
        this.activeStatusPrsnlId = activeStatusPrsnlId;
    }

    
    @Column(name="CKI")
    public String getCki() {
        return this.cki;
    }
    
    public void setCki(String cki) {
        this.cki = cki;
    }

    
    @Column(name="DISPLAY_KEY_NLS")
    public String getDisplayKeyNls() {
        return this.displayKeyNls;
    }
    
    public void setDisplayKeyNls(String displayKeyNls) {
        this.displayKeyNls = displayKeyNls;
    }

    
    @Column(name="CONCEPT_CKI")
    public String getConceptCki() {
        return this.conceptCki;
    }
    
    public void setConceptCki(String conceptCki) {
        this.conceptCki = conceptCki;
    }

    
    @Column(name="DISPLAY_KEY_A_NLS", length=160)
    public String getDisplayKeyANls() {
        return this.displayKeyANls;
    }
    
    public void setDisplayKeyANls(String displayKeyANls) {
        this.displayKeyANls = displayKeyANls;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UTC_TS")
    public Date getLastUtcTs() {
        return this.lastUtcTs;
    }
    
    public void setLastUtcTs(Date lastUtcTs) {
        this.lastUtcTs = lastUtcTs;
    }


    @OneToMany(fetch=FetchType.LAZY, mappedBy="codeValue")
    public Set<CodeValueAlias> getCodeValueAliases() {
        return this.codeValueAliases;
    }
    
    public void setCodeValueAliases(Set<CodeValueAlias> codeValueAliases) {
        this.codeValueAliases = codeValueAliases;
    }

}


