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
public class ItiMazadnaAuctionitemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "AUCTIONID")
    private Long auctionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMID")
    private Long itemid;

    public ItiMazadnaAuctionitemPK() {
    }

    public ItiMazadnaAuctionitemPK(Long auctionid, Long itemid) {
        this.auctionid = auctionid;
        this.itemid = itemid;
    }

    public Long getAuctionid() {
        return auctionid;
    }

    public void setAuctionid(Long auctionid) {
        this.auctionid = auctionid;
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
        hash += (auctionid != null ? auctionid.hashCode() : 0);
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItiMazadnaAuctionitemPK)) {
            return false;
        }
        ItiMazadnaAuctionitemPK other = (ItiMazadnaAuctionitemPK) object;
        if ((this.auctionid == null && other.auctionid != null) || (this.auctionid != null && !this.auctionid.equals(other.auctionid))) {
            return false;
        }
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mazadna.dal.entities.ItiMazadnaAuctionitemPK[ auctionid=" + auctionid + ", itemid=" + itemid + " ]";
    }
    
}
