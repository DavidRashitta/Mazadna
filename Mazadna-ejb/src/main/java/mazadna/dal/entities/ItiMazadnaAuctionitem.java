/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dal.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author szmoh
 */
@Entity
@Table(name = "ITI_MAZADNA_AUCTIONITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItiMazadnaAuctionitem.findAll", query = "SELECT i FROM ItiMazadnaAuctionitem i")
    , @NamedQuery(name = "ItiMazadnaAuctionitem.findByAuctionid", query = "SELECT i FROM ItiMazadnaAuctionitem i WHERE i.itiMazadnaAuctionitemPK.auctionid = :auctionid")
    , @NamedQuery(name = "ItiMazadnaAuctionitem.findByItemid", query = "SELECT i FROM ItiMazadnaAuctionitem i WHERE i.itiMazadnaAuctionitemPK.itemid = :itemid")
    , @NamedQuery(name = "ItiMazadnaAuctionitem.findByActive", query = "SELECT i FROM ItiMazadnaAuctionitem i WHERE i.active = :active")})
public class ItiMazadnaAuctionitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItiMazadnaAuctionitemPK itiMazadnaAuctionitemPK;
    @Column(name = "ACTIVE")
    private Long active;
    @JoinColumn(name = "AUCTIONID", referencedColumnName = "RECID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ItiMazadnaAuction itiMazadnaAuction;
    @JoinColumn(name = "ITEMID", referencedColumnName = "RECID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ItiMazadnaItem itiMazadnaItem;

    public ItiMazadnaAuctionitem() {
    }

    public ItiMazadnaAuctionitem(ItiMazadnaAuctionitemPK itiMazadnaAuctionitemPK) {
        this.itiMazadnaAuctionitemPK = itiMazadnaAuctionitemPK;
    }

    public ItiMazadnaAuctionitem(Long auctionid, Long itemid) {
        this.itiMazadnaAuctionitemPK = new ItiMazadnaAuctionitemPK(auctionid, itemid);
    }

    public ItiMazadnaAuctionitemPK getItiMazadnaAuctionitemPK() {
        return itiMazadnaAuctionitemPK;
    }

    public void setItiMazadnaAuctionitemPK(ItiMazadnaAuctionitemPK itiMazadnaAuctionitemPK) {
        this.itiMazadnaAuctionitemPK = itiMazadnaAuctionitemPK;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public ItiMazadnaAuction getItiMazadnaAuction() {
        return itiMazadnaAuction;
    }

    public void setItiMazadnaAuction(ItiMazadnaAuction itiMazadnaAuction) {
        this.itiMazadnaAuction = itiMazadnaAuction;
    }

    public ItiMazadnaItem getItiMazadnaItem() {
        return itiMazadnaItem;
    }

    public void setItiMazadnaItem(ItiMazadnaItem itiMazadnaItem) {
        this.itiMazadnaItem = itiMazadnaItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itiMazadnaAuctionitemPK != null ? itiMazadnaAuctionitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItiMazadnaAuctionitem)) {
            return false;
        }
        ItiMazadnaAuctionitem other = (ItiMazadnaAuctionitem) object;
        if ((this.itiMazadnaAuctionitemPK == null && other.itiMazadnaAuctionitemPK != null) || (this.itiMazadnaAuctionitemPK != null && !this.itiMazadnaAuctionitemPK.equals(other.itiMazadnaAuctionitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mazadna.dal.entities.ItiMazadnaAuctionitem[ itiMazadnaAuctionitemPK=" + itiMazadnaAuctionitemPK + " ]";
    }
    
}
