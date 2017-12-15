package eshviewer.data;
// Generated Dec 11, 2017 9:52:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * OrderCatalog generated by hbm2java
 */
@Entity
@Table(name="ORDER_CATALOG"
    ,schema="V500"
    , uniqueConstraints = @UniqueConstraint(columnNames="PRIMARY_MNEMONIC") 
)
public class OrderCatalog  implements java.io.Serializable {


     private BigDecimal catalogCd;
     private BigDecimal reviewHierarchyId;
     private BigDecimal abnReviewInd;
     private BigDecimal resourceRouteCd;
     private BigDecimal activityTypeCd;
     private BigDecimal resourceRouteLvl;
     private BigDecimal consentFormInd;
     private BigDecimal activeInd;
     private BigDecimal promptInd;
     private BigDecimal catalogTypeCd;
     private BigDecimal requisitionFormatCd;
     private BigDecimal requisitionRoutingCd;
     private BigDecimal instRestrictionInd;
     private BigDecimal scheduleInd;
     private String description;
     private BigDecimal printReqInd;
     private BigDecimal oeFormatId;
     private BigDecimal orderableTypeFlag;
     private BigDecimal quickChartInd;
     private BigDecimal completeUponOrderInd;
     private BigDecimal commentTemplateFlag;
     private BigDecimal prepInfoFlag;
     private Date updtDtTm;
     private BigDecimal updtId;
     private BigDecimal updtTask;
     private BigDecimal updtCnt;
     private BigDecimal updtApplctx;
     private BigDecimal eventCd;
     private BigDecimal activitySubtypeCd;
     private BigDecimal dupCheckingInd;
     private BigDecimal billOnlyInd;
     private BigDecimal contOrderMethodFlag;
     private BigDecimal deptDupCheckInd;
     private String primaryMnemonic;
     private BigDecimal orderReviewInd;
     private BigDecimal consentFormFormatCd;
     private BigDecimal consentFormRoutingCd;
     private String deptDisplayName;
     private BigDecimal refTextMask;
     private BigDecimal csIndexCd;
     private String sourceVocabMean;
     private String sourceVocabIdent;
     private BigDecimal ordComTemplateLongTextId;
     private BigDecimal modifiableFlag;
     private BigDecimal dcpClinCatCd;
     private BigDecimal autoCancelInd;
     private String cki;
     private BigDecimal stopTypeCd;
     private BigDecimal stopDuration;
     private BigDecimal stopDurationUnitCd;
     private BigDecimal dcDisplayDays;
     private BigDecimal dcInteractionDays;
     private BigDecimal disableOrderCommentInd;
     private BigDecimal formId;
     private BigDecimal formLevel;
     private String conceptCki;
     private BigDecimal icAutoVerifyFlag;
     private BigDecimal discernAutoVerifyFlag;
     private BigDecimal vettingApprovalFlag;
     private BigDecimal opDcDisplayDays;
     private BigDecimal opDcInteractionDays;
     private BigDecimal dosingAllIngredInd;
     private BigDecimal dosingActIngredCode;
     private Date lastUtcTs;

    public OrderCatalog() {
    }

	
    public OrderCatalog(BigDecimal catalogCd, BigDecimal reviewHierarchyId, BigDecimal resourceRouteCd, BigDecimal activityTypeCd, BigDecimal catalogTypeCd, BigDecimal requisitionFormatCd, BigDecimal requisitionRoutingCd, BigDecimal oeFormatId, Date updtDtTm, BigDecimal updtId, BigDecimal updtTask, BigDecimal updtCnt, BigDecimal updtApplctx, BigDecimal eventCd, BigDecimal activitySubtypeCd, String primaryMnemonic, BigDecimal consentFormFormatCd, BigDecimal consentFormRoutingCd, BigDecimal csIndexCd, BigDecimal ordComTemplateLongTextId, BigDecimal dcpClinCatCd, BigDecimal stopTypeCd, BigDecimal stopDurationUnitCd, BigDecimal formId, BigDecimal icAutoVerifyFlag, BigDecimal discernAutoVerifyFlag) {
        this.catalogCd = catalogCd;
        this.reviewHierarchyId = reviewHierarchyId;
        this.resourceRouteCd = resourceRouteCd;
        this.activityTypeCd = activityTypeCd;
        this.catalogTypeCd = catalogTypeCd;
        this.requisitionFormatCd = requisitionFormatCd;
        this.requisitionRoutingCd = requisitionRoutingCd;
        this.oeFormatId = oeFormatId;
        this.updtDtTm = updtDtTm;
        this.updtId = updtId;
        this.updtTask = updtTask;
        this.updtCnt = updtCnt;
        this.updtApplctx = updtApplctx;
        this.eventCd = eventCd;
        this.activitySubtypeCd = activitySubtypeCd;
        this.primaryMnemonic = primaryMnemonic;
        this.consentFormFormatCd = consentFormFormatCd;
        this.consentFormRoutingCd = consentFormRoutingCd;
        this.csIndexCd = csIndexCd;
        this.ordComTemplateLongTextId = ordComTemplateLongTextId;
        this.dcpClinCatCd = dcpClinCatCd;
        this.stopTypeCd = stopTypeCd;
        this.stopDurationUnitCd = stopDurationUnitCd;
        this.formId = formId;
        this.icAutoVerifyFlag = icAutoVerifyFlag;
        this.discernAutoVerifyFlag = discernAutoVerifyFlag;
    }
    public OrderCatalog(BigDecimal catalogCd, BigDecimal reviewHierarchyId, BigDecimal abnReviewInd, BigDecimal resourceRouteCd, BigDecimal activityTypeCd, BigDecimal resourceRouteLvl, BigDecimal consentFormInd, BigDecimal activeInd, BigDecimal promptInd, BigDecimal catalogTypeCd, BigDecimal requisitionFormatCd, BigDecimal requisitionRoutingCd, BigDecimal instRestrictionInd, BigDecimal scheduleInd, String description, BigDecimal printReqInd, BigDecimal oeFormatId, BigDecimal orderableTypeFlag, BigDecimal quickChartInd, BigDecimal completeUponOrderInd, BigDecimal commentTemplateFlag, BigDecimal prepInfoFlag, Date updtDtTm, BigDecimal updtId, BigDecimal updtTask, BigDecimal updtCnt, BigDecimal updtApplctx, BigDecimal eventCd, BigDecimal activitySubtypeCd, BigDecimal dupCheckingInd, BigDecimal billOnlyInd, BigDecimal contOrderMethodFlag, BigDecimal deptDupCheckInd, String primaryMnemonic, BigDecimal orderReviewInd, BigDecimal consentFormFormatCd, BigDecimal consentFormRoutingCd, String deptDisplayName, BigDecimal refTextMask, BigDecimal csIndexCd, String sourceVocabMean, String sourceVocabIdent, BigDecimal ordComTemplateLongTextId, BigDecimal modifiableFlag, BigDecimal dcpClinCatCd, BigDecimal autoCancelInd, String cki, BigDecimal stopTypeCd, BigDecimal stopDuration, BigDecimal stopDurationUnitCd, BigDecimal dcDisplayDays, BigDecimal dcInteractionDays, BigDecimal disableOrderCommentInd, BigDecimal formId, BigDecimal formLevel, String conceptCki, BigDecimal icAutoVerifyFlag, BigDecimal discernAutoVerifyFlag, BigDecimal vettingApprovalFlag, BigDecimal opDcDisplayDays, BigDecimal opDcInteractionDays, BigDecimal dosingAllIngredInd, BigDecimal dosingActIngredCode, Date lastUtcTs) {
       this.catalogCd = catalogCd;
       this.reviewHierarchyId = reviewHierarchyId;
       this.abnReviewInd = abnReviewInd;
       this.resourceRouteCd = resourceRouteCd;
       this.activityTypeCd = activityTypeCd;
       this.resourceRouteLvl = resourceRouteLvl;
       this.consentFormInd = consentFormInd;
       this.activeInd = activeInd;
       this.promptInd = promptInd;
       this.catalogTypeCd = catalogTypeCd;
       this.requisitionFormatCd = requisitionFormatCd;
       this.requisitionRoutingCd = requisitionRoutingCd;
       this.instRestrictionInd = instRestrictionInd;
       this.scheduleInd = scheduleInd;
       this.description = description;
       this.printReqInd = printReqInd;
       this.oeFormatId = oeFormatId;
       this.orderableTypeFlag = orderableTypeFlag;
       this.quickChartInd = quickChartInd;
       this.completeUponOrderInd = completeUponOrderInd;
       this.commentTemplateFlag = commentTemplateFlag;
       this.prepInfoFlag = prepInfoFlag;
       this.updtDtTm = updtDtTm;
       this.updtId = updtId;
       this.updtTask = updtTask;
       this.updtCnt = updtCnt;
       this.updtApplctx = updtApplctx;
       this.eventCd = eventCd;
       this.activitySubtypeCd = activitySubtypeCd;
       this.dupCheckingInd = dupCheckingInd;
       this.billOnlyInd = billOnlyInd;
       this.contOrderMethodFlag = contOrderMethodFlag;
       this.deptDupCheckInd = deptDupCheckInd;
       this.primaryMnemonic = primaryMnemonic;
       this.orderReviewInd = orderReviewInd;
       this.consentFormFormatCd = consentFormFormatCd;
       this.consentFormRoutingCd = consentFormRoutingCd;
       this.deptDisplayName = deptDisplayName;
       this.refTextMask = refTextMask;
       this.csIndexCd = csIndexCd;
       this.sourceVocabMean = sourceVocabMean;
       this.sourceVocabIdent = sourceVocabIdent;
       this.ordComTemplateLongTextId = ordComTemplateLongTextId;
       this.modifiableFlag = modifiableFlag;
       this.dcpClinCatCd = dcpClinCatCd;
       this.autoCancelInd = autoCancelInd;
       this.cki = cki;
       this.stopTypeCd = stopTypeCd;
       this.stopDuration = stopDuration;
       this.stopDurationUnitCd = stopDurationUnitCd;
       this.dcDisplayDays = dcDisplayDays;
       this.dcInteractionDays = dcInteractionDays;
       this.disableOrderCommentInd = disableOrderCommentInd;
       this.formId = formId;
       this.formLevel = formLevel;
       this.conceptCki = conceptCki;
       this.icAutoVerifyFlag = icAutoVerifyFlag;
       this.discernAutoVerifyFlag = discernAutoVerifyFlag;
       this.vettingApprovalFlag = vettingApprovalFlag;
       this.opDcDisplayDays = opDcDisplayDays;
       this.opDcInteractionDays = opDcInteractionDays;
       this.dosingAllIngredInd = dosingAllIngredInd;
       this.dosingActIngredCode = dosingActIngredCode;
       this.lastUtcTs = lastUtcTs;
    }
   
     @Id 

    
    @Column(name="CATALOG_CD", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getCatalogCd() {
        return this.catalogCd;
    }
    
    public void setCatalogCd(BigDecimal catalogCd) {
        this.catalogCd = catalogCd;
    }

    
    @Column(name="REVIEW_HIERARCHY_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getReviewHierarchyId() {
        return this.reviewHierarchyId;
    }
    
    public void setReviewHierarchyId(BigDecimal reviewHierarchyId) {
        this.reviewHierarchyId = reviewHierarchyId;
    }

    
    @Column(name="ABN_REVIEW_IND", precision=22, scale=0)
    public BigDecimal getAbnReviewInd() {
        return this.abnReviewInd;
    }
    
    public void setAbnReviewInd(BigDecimal abnReviewInd) {
        this.abnReviewInd = abnReviewInd;
    }

    
    @Column(name="RESOURCE_ROUTE_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getResourceRouteCd() {
        return this.resourceRouteCd;
    }
    
    public void setResourceRouteCd(BigDecimal resourceRouteCd) {
        this.resourceRouteCd = resourceRouteCd;
    }

    
    @Column(name="ACTIVITY_TYPE_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getActivityTypeCd() {
        return this.activityTypeCd;
    }
    
    public void setActivityTypeCd(BigDecimal activityTypeCd) {
        this.activityTypeCd = activityTypeCd;
    }

    
    @Column(name="RESOURCE_ROUTE_LVL", precision=22, scale=0)
    public BigDecimal getResourceRouteLvl() {
        return this.resourceRouteLvl;
    }
    
    public void setResourceRouteLvl(BigDecimal resourceRouteLvl) {
        this.resourceRouteLvl = resourceRouteLvl;
    }

    
    @Column(name="CONSENT_FORM_IND", precision=22, scale=0)
    public BigDecimal getConsentFormInd() {
        return this.consentFormInd;
    }
    
    public void setConsentFormInd(BigDecimal consentFormInd) {
        this.consentFormInd = consentFormInd;
    }

    
    @Column(name="ACTIVE_IND", precision=22, scale=0)
    public BigDecimal getActiveInd() {
        return this.activeInd;
    }
    
    public void setActiveInd(BigDecimal activeInd) {
        this.activeInd = activeInd;
    }

    
    @Column(name="PROMPT_IND", precision=22, scale=0)
    public BigDecimal getPromptInd() {
        return this.promptInd;
    }
    
    public void setPromptInd(BigDecimal promptInd) {
        this.promptInd = promptInd;
    }

    
    @Column(name="CATALOG_TYPE_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getCatalogTypeCd() {
        return this.catalogTypeCd;
    }
    
    public void setCatalogTypeCd(BigDecimal catalogTypeCd) {
        this.catalogTypeCd = catalogTypeCd;
    }

    
    @Column(name="REQUISITION_FORMAT_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getRequisitionFormatCd() {
        return this.requisitionFormatCd;
    }
    
    public void setRequisitionFormatCd(BigDecimal requisitionFormatCd) {
        this.requisitionFormatCd = requisitionFormatCd;
    }

    
    @Column(name="REQUISITION_ROUTING_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getRequisitionRoutingCd() {
        return this.requisitionRoutingCd;
    }
    
    public void setRequisitionRoutingCd(BigDecimal requisitionRoutingCd) {
        this.requisitionRoutingCd = requisitionRoutingCd;
    }

    
    @Column(name="INST_RESTRICTION_IND", precision=22, scale=0)
    public BigDecimal getInstRestrictionInd() {
        return this.instRestrictionInd;
    }
    
    public void setInstRestrictionInd(BigDecimal instRestrictionInd) {
        this.instRestrictionInd = instRestrictionInd;
    }

    
    @Column(name="SCHEDULE_IND", precision=22, scale=0)
    public BigDecimal getScheduleInd() {
        return this.scheduleInd;
    }
    
    public void setScheduleInd(BigDecimal scheduleInd) {
        this.scheduleInd = scheduleInd;
    }

    
    @Column(name="DESCRIPTION", length=100)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="PRINT_REQ_IND", precision=22, scale=0)
    public BigDecimal getPrintReqInd() {
        return this.printReqInd;
    }
    
    public void setPrintReqInd(BigDecimal printReqInd) {
        this.printReqInd = printReqInd;
    }

    
    @Column(name="OE_FORMAT_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getOeFormatId() {
        return this.oeFormatId;
    }
    
    public void setOeFormatId(BigDecimal oeFormatId) {
        this.oeFormatId = oeFormatId;
    }

    
    @Column(name="ORDERABLE_TYPE_FLAG", precision=22, scale=0)
    public BigDecimal getOrderableTypeFlag() {
        return this.orderableTypeFlag;
    }
    
    public void setOrderableTypeFlag(BigDecimal orderableTypeFlag) {
        this.orderableTypeFlag = orderableTypeFlag;
    }

    
    @Column(name="QUICK_CHART_IND", precision=22, scale=0)
    public BigDecimal getQuickChartInd() {
        return this.quickChartInd;
    }
    
    public void setQuickChartInd(BigDecimal quickChartInd) {
        this.quickChartInd = quickChartInd;
    }

    
    @Column(name="COMPLETE_UPON_ORDER_IND", precision=22, scale=0)
    public BigDecimal getCompleteUponOrderInd() {
        return this.completeUponOrderInd;
    }
    
    public void setCompleteUponOrderInd(BigDecimal completeUponOrderInd) {
        this.completeUponOrderInd = completeUponOrderInd;
    }

    
    @Column(name="COMMENT_TEMPLATE_FLAG", precision=22, scale=0)
    public BigDecimal getCommentTemplateFlag() {
        return this.commentTemplateFlag;
    }
    
    public void setCommentTemplateFlag(BigDecimal commentTemplateFlag) {
        this.commentTemplateFlag = commentTemplateFlag;
    }

    
    @Column(name="PREP_INFO_FLAG", precision=22, scale=0)
    public BigDecimal getPrepInfoFlag() {
        return this.prepInfoFlag;
    }
    
    public void setPrepInfoFlag(BigDecimal prepInfoFlag) {
        this.prepInfoFlag = prepInfoFlag;
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

    
    @Column(name="UPDT_TASK", nullable=false, precision=22, scale=0)
    public BigDecimal getUpdtTask() {
        return this.updtTask;
    }
    
    public void setUpdtTask(BigDecimal updtTask) {
        this.updtTask = updtTask;
    }

    
    @Column(name="UPDT_CNT", nullable=false, precision=22, scale=0)
    public BigDecimal getUpdtCnt() {
        return this.updtCnt;
    }
    
    public void setUpdtCnt(BigDecimal updtCnt) {
        this.updtCnt = updtCnt;
    }

    
    @Column(name="UPDT_APPLCTX", nullable=false, precision=22, scale=0)
    public BigDecimal getUpdtApplctx() {
        return this.updtApplctx;
    }
    
    public void setUpdtApplctx(BigDecimal updtApplctx) {
        this.updtApplctx = updtApplctx;
    }

    
    @Column(name="EVENT_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getEventCd() {
        return this.eventCd;
    }
    
    public void setEventCd(BigDecimal eventCd) {
        this.eventCd = eventCd;
    }

    
    @Column(name="ACTIVITY_SUBTYPE_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getActivitySubtypeCd() {
        return this.activitySubtypeCd;
    }
    
    public void setActivitySubtypeCd(BigDecimal activitySubtypeCd) {
        this.activitySubtypeCd = activitySubtypeCd;
    }

    
    @Column(name="DUP_CHECKING_IND", precision=22, scale=0)
    public BigDecimal getDupCheckingInd() {
        return this.dupCheckingInd;
    }
    
    public void setDupCheckingInd(BigDecimal dupCheckingInd) {
        this.dupCheckingInd = dupCheckingInd;
    }

    
    @Column(name="BILL_ONLY_IND", precision=22, scale=0)
    public BigDecimal getBillOnlyInd() {
        return this.billOnlyInd;
    }
    
    public void setBillOnlyInd(BigDecimal billOnlyInd) {
        this.billOnlyInd = billOnlyInd;
    }

    
    @Column(name="CONT_ORDER_METHOD_FLAG", precision=22, scale=0)
    public BigDecimal getContOrderMethodFlag() {
        return this.contOrderMethodFlag;
    }
    
    public void setContOrderMethodFlag(BigDecimal contOrderMethodFlag) {
        this.contOrderMethodFlag = contOrderMethodFlag;
    }

    
    @Column(name="DEPT_DUP_CHECK_IND", precision=22, scale=0)
    public BigDecimal getDeptDupCheckInd() {
        return this.deptDupCheckInd;
    }
    
    public void setDeptDupCheckInd(BigDecimal deptDupCheckInd) {
        this.deptDupCheckInd = deptDupCheckInd;
    }

    
    @Column(name="PRIMARY_MNEMONIC", unique=true, nullable=false, length=100)
    public String getPrimaryMnemonic() {
        return this.primaryMnemonic;
    }
    
    public void setPrimaryMnemonic(String primaryMnemonic) {
        this.primaryMnemonic = primaryMnemonic;
    }

    
    @Column(name="ORDER_REVIEW_IND", precision=22, scale=0)
    public BigDecimal getOrderReviewInd() {
        return this.orderReviewInd;
    }
    
    public void setOrderReviewInd(BigDecimal orderReviewInd) {
        this.orderReviewInd = orderReviewInd;
    }

    
    @Column(name="CONSENT_FORM_FORMAT_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getConsentFormFormatCd() {
        return this.consentFormFormatCd;
    }
    
    public void setConsentFormFormatCd(BigDecimal consentFormFormatCd) {
        this.consentFormFormatCd = consentFormFormatCd;
    }

    
    @Column(name="CONSENT_FORM_ROUTING_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getConsentFormRoutingCd() {
        return this.consentFormRoutingCd;
    }
    
    public void setConsentFormRoutingCd(BigDecimal consentFormRoutingCd) {
        this.consentFormRoutingCd = consentFormRoutingCd;
    }

    
    @Column(name="DEPT_DISPLAY_NAME", length=100)
    public String getDeptDisplayName() {
        return this.deptDisplayName;
    }
    
    public void setDeptDisplayName(String deptDisplayName) {
        this.deptDisplayName = deptDisplayName;
    }

    
    @Column(name="REF_TEXT_MASK", precision=22, scale=0)
    public BigDecimal getRefTextMask() {
        return this.refTextMask;
    }
    
    public void setRefTextMask(BigDecimal refTextMask) {
        this.refTextMask = refTextMask;
    }

    
    @Column(name="CS_INDEX_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getCsIndexCd() {
        return this.csIndexCd;
    }
    
    public void setCsIndexCd(BigDecimal csIndexCd) {
        this.csIndexCd = csIndexCd;
    }

    
    @Column(name="SOURCE_VOCAB_MEAN", length=12)
    public String getSourceVocabMean() {
        return this.sourceVocabMean;
    }
    
    public void setSourceVocabMean(String sourceVocabMean) {
        this.sourceVocabMean = sourceVocabMean;
    }

    
    @Column(name="SOURCE_VOCAB_IDENT", length=50)
    public String getSourceVocabIdent() {
        return this.sourceVocabIdent;
    }
    
    public void setSourceVocabIdent(String sourceVocabIdent) {
        this.sourceVocabIdent = sourceVocabIdent;
    }

    
    @Column(name="ORD_COM_TEMPLATE_LONG_TEXT_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getOrdComTemplateLongTextId() {
        return this.ordComTemplateLongTextId;
    }
    
    public void setOrdComTemplateLongTextId(BigDecimal ordComTemplateLongTextId) {
        this.ordComTemplateLongTextId = ordComTemplateLongTextId;
    }

    
    @Column(name="MODIFIABLE_FLAG", precision=22, scale=0)
    public BigDecimal getModifiableFlag() {
        return this.modifiableFlag;
    }
    
    public void setModifiableFlag(BigDecimal modifiableFlag) {
        this.modifiableFlag = modifiableFlag;
    }

    
    @Column(name="DCP_CLIN_CAT_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getDcpClinCatCd() {
        return this.dcpClinCatCd;
    }
    
    public void setDcpClinCatCd(BigDecimal dcpClinCatCd) {
        this.dcpClinCatCd = dcpClinCatCd;
    }

    
    @Column(name="AUTO_CANCEL_IND", precision=22, scale=0)
    public BigDecimal getAutoCancelInd() {
        return this.autoCancelInd;
    }
    
    public void setAutoCancelInd(BigDecimal autoCancelInd) {
        this.autoCancelInd = autoCancelInd;
    }

    
    @Column(name="CKI")
    public String getCki() {
        return this.cki;
    }
    
    public void setCki(String cki) {
        this.cki = cki;
    }

    
    @Column(name="STOP_TYPE_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getStopTypeCd() {
        return this.stopTypeCd;
    }
    
    public void setStopTypeCd(BigDecimal stopTypeCd) {
        this.stopTypeCd = stopTypeCd;
    }

    
    @Column(name="STOP_DURATION", precision=22, scale=0)
    public BigDecimal getStopDuration() {
        return this.stopDuration;
    }
    
    public void setStopDuration(BigDecimal stopDuration) {
        this.stopDuration = stopDuration;
    }

    
    @Column(name="STOP_DURATION_UNIT_CD", nullable=false, precision=22, scale=0)
    public BigDecimal getStopDurationUnitCd() {
        return this.stopDurationUnitCd;
    }
    
    public void setStopDurationUnitCd(BigDecimal stopDurationUnitCd) {
        this.stopDurationUnitCd = stopDurationUnitCd;
    }

    
    @Column(name="DC_DISPLAY_DAYS", precision=22, scale=0)
    public BigDecimal getDcDisplayDays() {
        return this.dcDisplayDays;
    }
    
    public void setDcDisplayDays(BigDecimal dcDisplayDays) {
        this.dcDisplayDays = dcDisplayDays;
    }

    
    @Column(name="DC_INTERACTION_DAYS", precision=22, scale=0)
    public BigDecimal getDcInteractionDays() {
        return this.dcInteractionDays;
    }
    
    public void setDcInteractionDays(BigDecimal dcInteractionDays) {
        this.dcInteractionDays = dcInteractionDays;
    }

    
    @Column(name="DISABLE_ORDER_COMMENT_IND", precision=22, scale=0)
    public BigDecimal getDisableOrderCommentInd() {
        return this.disableOrderCommentInd;
    }
    
    public void setDisableOrderCommentInd(BigDecimal disableOrderCommentInd) {
        this.disableOrderCommentInd = disableOrderCommentInd;
    }

    
    @Column(name="FORM_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getFormId() {
        return this.formId;
    }
    
    public void setFormId(BigDecimal formId) {
        this.formId = formId;
    }

    
    @Column(name="FORM_LEVEL", precision=22, scale=0)
    public BigDecimal getFormLevel() {
        return this.formLevel;
    }
    
    public void setFormLevel(BigDecimal formLevel) {
        this.formLevel = formLevel;
    }

    
    @Column(name="CONCEPT_CKI")
    public String getConceptCki() {
        return this.conceptCki;
    }
    
    public void setConceptCki(String conceptCki) {
        this.conceptCki = conceptCki;
    }

    
    @Column(name="IC_AUTO_VERIFY_FLAG", nullable=false, precision=22, scale=0)
    public BigDecimal getIcAutoVerifyFlag() {
        return this.icAutoVerifyFlag;
    }
    
    public void setIcAutoVerifyFlag(BigDecimal icAutoVerifyFlag) {
        this.icAutoVerifyFlag = icAutoVerifyFlag;
    }

    
    @Column(name="DISCERN_AUTO_VERIFY_FLAG", nullable=false, precision=22, scale=0)
    public BigDecimal getDiscernAutoVerifyFlag() {
        return this.discernAutoVerifyFlag;
    }
    
    public void setDiscernAutoVerifyFlag(BigDecimal discernAutoVerifyFlag) {
        this.discernAutoVerifyFlag = discernAutoVerifyFlag;
    }

    
    @Column(name="VETTING_APPROVAL_FLAG", precision=22, scale=0)
    public BigDecimal getVettingApprovalFlag() {
        return this.vettingApprovalFlag;
    }
    
    public void setVettingApprovalFlag(BigDecimal vettingApprovalFlag) {
        this.vettingApprovalFlag = vettingApprovalFlag;
    }

    
    @Column(name="OP_DC_DISPLAY_DAYS", precision=22, scale=0)
    public BigDecimal getOpDcDisplayDays() {
        return this.opDcDisplayDays;
    }
    
    public void setOpDcDisplayDays(BigDecimal opDcDisplayDays) {
        this.opDcDisplayDays = opDcDisplayDays;
    }

    
    @Column(name="OP_DC_INTERACTION_DAYS", precision=22, scale=0)
    public BigDecimal getOpDcInteractionDays() {
        return this.opDcInteractionDays;
    }
    
    public void setOpDcInteractionDays(BigDecimal opDcInteractionDays) {
        this.opDcInteractionDays = opDcInteractionDays;
    }

    
    @Column(name="DOSING_ALL_INGRED_IND", precision=22, scale=0)
    public BigDecimal getDosingAllIngredInd() {
        return this.dosingAllIngredInd;
    }
    
    public void setDosingAllIngredInd(BigDecimal dosingAllIngredInd) {
        this.dosingAllIngredInd = dosingAllIngredInd;
    }

    
    @Column(name="DOSING_ACT_INGRED_CODE", precision=22, scale=0)
    public BigDecimal getDosingActIngredCode() {
        return this.dosingActIngredCode;
    }
    
    public void setDosingActIngredCode(BigDecimal dosingActIngredCode) {
        this.dosingActIngredCode = dosingActIngredCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UTC_TS")
    public Date getLastUtcTs() {
        return this.lastUtcTs;
    }
    
    public void setLastUtcTs(Date lastUtcTs) {
        this.lastUtcTs = lastUtcTs;
    }




}

