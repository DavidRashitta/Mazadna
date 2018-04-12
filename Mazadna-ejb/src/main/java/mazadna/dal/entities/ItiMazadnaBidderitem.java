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
@Table(name = "ITI_MAZADNA_BIDDERITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItiMazadnaBidderitem.findAll", query = "SELECT i FROM ItiMazadnaBidderitem i")
    , @NamedQuery(name = "ItiMazadnaBidderitem.findByBidderid", query = "SELECT i FROM ItiMazadnaBidderitem i WHERE i.itiMazadnaBidderitemPK.bidderid = :bidderid")
    , @NamedQuery(name = "ItiMazadnaBidderitem.findByItemid", query = "SELECT i FROM ItiMazadnaBidderitem i WHERE i.itiMazadnaBidderitemPK.itemid = :itemid")
    , @NamedQuery(name = "ItiMazadnaBidderitem.findByBidamount", query = "SELECT i FROM ItiMazadnaBidderitem i WHERE i.bidamount = :bidamount")
    , @NamedQuery(name = "ItiMazadnaBidderitem.findByWinner", query = "SELECT i FROM ItiMazadnaBidderitem i WHERE i.winner = :winner")})
public class ItiMazadnaBidderitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItiMazadnaBidderitemPK itiMazadnaBidderitemPK;
    @Column(name = "BIDAMOUNT")
    private Long bidamount;
    @Column(name = "WINNER")
    private Long winner;
    @JoinColumn(name = "ITEMID", referencedColumnName = "RECID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ItiMazadnaItem itiMazadnaItem;
    @JoinColumn(name = "BIDDERID", referencedColumnName = "RECID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ItiMazadnaUser itiMazadnaUser;

    public ItiMazadnaBidderitem() {
    }

    public ItiMazadnaBidderitem(ItiMazadnaBidderitemPK itiMazadnaBidderitemPK) {
        this.itiMazadnaBidderitemPK = itiMazadnaBidderitemPK;
    }

    public ItiMazadnaBidderitem(Long bidderid, Long itemid) {
        this.itiMazadnaBidderitemPK = new ItiMazadnaBidderitemPK(bidderid, itemid);
    }

    public ItiMazadnaBidderitemPK getItiMazadnaBidderitemPK() {
        return itiMazadnaBidderitemPK;
    }

    public void setItiMazadnaBidderitemPK(ItiMazadnaBidderitemPK itiMazadnaBidderitemPK) {
        this.itiMazadnaBidderitemPK = itiMazadnaBidderitemPK;
    }

    public Long getBidamount() {
        return bidamount;
    }

    public void setBidamount(Long bidamount) {
        this.bidamount = bidamount;
    }

    public Long getWinner() {
        return winner;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }

    public ItiMazadnaItem getItiMazadnaItem() {
        return itiMazadnaItem;
    }

    public void setItiMazadnaItem(ItiMazadnaItem itiMazadnaItem) {
        this.itiMazadnaItem = itiMazadnaItem;
    }

    public ItiMazadnaUser getItiMazadnaUser() {
        return itiMazadnaUser;
    }

    public void setItiMazadnaUser(ItiMazadnaUser itiMazadnaUser) {
        this.itiMazadnaUser = itiMazadnaUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itiMazadnaBidderitemPK != null ? itiMazadnaBidderitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItiMazadnaBidderitem)) {
            return false;
        }
        ItiMazadnaBidderitem other = (ItiMazadnaBidderitem) object;
        if ((this.itiMazadnaBidderitemPK == null && other.itiMazadnaBidderitemPK != null) || (this.itiMazadnaBidderitemPK != null && !this.itiMazadnaBidderitemPK.equals(other.itiMazadnaBidderitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mazadna.dal.entities.ItiMazadnaBidderitem[ itiMazadnaBidderitemPK=" + itiMazadnaBidderitemPK + " ]";
    }
    
}
