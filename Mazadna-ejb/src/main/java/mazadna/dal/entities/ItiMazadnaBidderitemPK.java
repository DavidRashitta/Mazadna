/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dal.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author szmoh
 */
@Embeddable
public class ItiMazadnaBidderitemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "BIDDERID")
    private Long bidderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMID")
    private Long itemid;

    public ItiMazadnaBidderitemPK() {
    }

    public ItiMazadnaBidderitemPK(Long bidderid, Long itemid) {
        this.bidderid = bidderid;
        this.itemid = itemid;
    }

    public Long getBidderid() {
        return bidderid;
    }

    public void setBidderid(Long bidderid) {
        this.bidderid = bidderid;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidderid != null ? bidderid.hashCode() : 0);
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItiMazadnaBidderitemPK)) {
            return false;
        }
        ItiMazadnaBidderitemPK other = (ItiMazadnaBidderitemPK) object;
        if ((this.bidderid == null && other.bidderid != null) || (this.bidderid != null && !this.bidderid.equals(other.bidderid))) {
            return false;
        }
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mazadna.dal.entities.ItiMazadnaBidderitemPK[ bidderid=" + bidderid + ", itemid=" + itemid + " ]";
    }
    
}
