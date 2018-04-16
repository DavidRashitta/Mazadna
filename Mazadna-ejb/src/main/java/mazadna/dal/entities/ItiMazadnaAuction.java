/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dal.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author szmoh
 */
@Entity
@Table(name = "ITI_MAZADNA_AUCTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItiMazadnaAuction.findAll", query = "SELECT i FROM ItiMazadnaAuction i")
    , @NamedQuery(name = "ItiMazadnaAuction.findByRecid", query = "SELECT i FROM ItiMazadnaAuction i WHERE i.recid = :recid")
    , @NamedQuery(name = "ItiMazadnaAuction.findByAuctionStart", query = "SELECT i FROM ItiMazadnaAuction i WHERE i.auctionStart = :auctionStart")
    , @NamedQuery(name = "ItiMazadnaAuction.findByAuctionEnd", query = "SELECT i FROM ItiMazadnaAuction i WHERE i.auctionEnd = :auctionEnd")
    , @NamedQuery(name = "ItiMazadnaAuction.findByApprove", query = "SELECT i FROM ItiMazadnaAuction i WHERE i.approve = :approve")})
public class ItiMazadnaAuction implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECID")
    private Long recid;
    @Column(name = "AUCTION_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionStart;
    @Column(name = "AUCTION_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionEnd;
    @Column(name = "APPROVE")
    private Long approve;
    @Size(max = 200)
    @Column(name = "AUCTION_IMAGE")
    private String auctionImage;
    @Size(max = 100)
    @Column(name = "AUCTION_NAME")
    private String auctionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itiMazadnaAuction")
    private Set<ItiMazadnaAuctionitem> itiMazadnaAuctionitemSet;

    public ItiMazadnaAuction() {
    }

    public ItiMazadnaAuction(Long recid) {
        this.recid = recid;
    }

    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public Date getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(Date auctionStart) {
        this.auctionStart = auctionStart;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Long getApprove() {
        return approve;
    }

    public void setApprove(Long approve) {
        this.approve = approve;
    }

    public String getAuctionImage() {
        return auctionImage;
    }

    public void setAuctionImage(String auctionImage) {
        this.auctionImage = auctionImage;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    @XmlTransient
    public Set<ItiMazadnaAuctionitem> getItiMazadnaAuctionitemSet() {
        return itiMazadnaAuctionitemSet;
    }

    public void setItiMazadnaAuctionitemSet(Set<ItiMazadnaAuctionitem> itiMazadnaAuctionitemSet) {
        this.itiMazadnaAuctionitemSet = itiMazadnaAuctionitemSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recid != null ? recid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItiMazadnaAuction)) {
            return false;
        }
        ItiMazadnaAuction other = (ItiMazadnaAuction) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mazadna.dal.entities.ItiMazadnaAuction[ recid=" + recid + " ]";
    }
    
}
