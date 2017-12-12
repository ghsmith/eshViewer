/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshviewer.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ghsmith
 */
@Entity
public class NormalizedHierarchy implements java.io.Serializable {

    String id;
    String nodeType;
    String cd;
    String parentCd;
    String seq;
    String disp;

    @Id
    @Column(name="ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
}
