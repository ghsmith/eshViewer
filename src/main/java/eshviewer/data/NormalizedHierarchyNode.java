/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshviewer.data;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author ghsmith
 */
@Entity
public class NormalizedHierarchyNode implements java.io.Serializable {

    String id;
    String parentId;
    String nodeType;
    String cd;
    String parentCd;
    String seq;
    String disp;
    String listFacility;

    NormalizedHierarchyNode parent;
    List<NormalizedHierarchyNode> children;
    
    @Id
    @Column(name="ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="PARENT_ID")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Column(name="NODE_TYPE")
    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    @Column(name="CD")
    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    @Column(name="PARENT_CD")
    public String getParentCd() {
        return parentCd;
    }

    public void setParentCd(String parentCd) {
        this.parentCd = parentCd;
    }

    @Column(name="SEQ")
    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    @Column(name="DISP")
    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    @Column(name="LIST_FACILITY")
    public String getListFacility() {
        return listFacility;
    }

    public void setListFacility(String listFacility) {
        this.listFacility = listFacility;
    }

    @Transient
    public NormalizedHierarchyNode getParent() {
        return parent;
    }

    public void setParent(NormalizedHierarchyNode parent) {
        this.parent = parent;
    }

    @Transient
    public List<NormalizedHierarchyNode> getChildren() {
        return children;
    }

    public void setChildren(List<NormalizedHierarchyNode> children) {
        this.children = children;
    }
        
}
