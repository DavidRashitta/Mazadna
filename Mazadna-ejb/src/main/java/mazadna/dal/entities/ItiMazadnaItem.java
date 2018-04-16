/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazadna.dal.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author szmoh
 */
@Entity
@Table(name = "ITI_MAZADNA_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItiMazadnaItem.findAll", query = "SELECT i FROM ItiMazadnaItem i")
    , @NamedQuery(name = "ItiMazadnaItem.findByRecid", query = "SELECT i FROM ItiMazadnaItem i WHERE i.recid = :recid")
    , @NamedQuery(name = "ItiMazadnaItem.findByName", query = "SELECT i FROM ItiMazadnaItem i WHERE i.name = :name")
    , @NamedQuery(name = "ItiMazadnaItem.findByMinprice", query = "SELECT i FROM ItiMazadnaItem i WHERE i.minprice = :minprice")
    , @NamedQuery(name = "ItiMazadnaItem.findByDescription", query = "SELECT i FROM ItiMazadnaItem i WHERE i.description = :description")
    , @NamedQuery(name = "ItiMazadnaItem.findByBidincrement", query = "SELECT i FROM ItiMazadnaItem i WHERE i.bidincrement = :bidincrement")
    , @NamedQuery(name = "ItiMazadnaItem.findByImgurl", query = "SELECT i FROM ItiMazadnaItem i WHERE i.imgurl = :imgurl")
    , @NamedQuery(name = "ItiMazadnaItem.findBySold", query = "SELECT i FROM ItiMazadnaItem i WHERE i.sold = :sold")})
public class ItiMazadnaItem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECID")
    private Long recid;

    @Column(name = "PLACEBIDAMOUNT")
    private Long placeBidAmount;

    @Size(max = 200)
    @Column(name = "NAME")
    private String name;
    @Column(name = "MINPRICE")
    private Long minprice;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "BIDINCREMENT")
    private Long bidincrement;
    @Size(max = 200)
    @Column(name = "IMGURL")
    private String imgurl;
    @Column(name = "SOLD")
    private Long sold;
    @JoinColumn(name = "SUPPLIERID", referencedColumnName = "RECID")
    @ManyToOne
    private ItiMazadnaUser supplierid;
    @JoinColumn(name = "USERID", referencedColumnName = "RECID")
    @ManyToOne
    private ItiMazadnaUser userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itiMazadnaItem")
    private Set<ItiMazadnaBidderitem> itiMazadnaBidderitemSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itiMazadnaItem")
    private Set<ItiMazadnaAuctionitem> itiMazadnaAuctionitemSet;

    public ItiMazadnaItem() {
    }

    public ItiMazadnaItem(Long recid) {
        this.recid = recid;
    }

    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMinprice() {
        return minprice;
    }

    public void setMinprice(Long minprice) {
        this.minprice = minprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBidincrement() {
        return bidincrement;
    }

    public void setBidincrement(Long bidincrement) {
        this.bidincrement = bidincrement;
    }

    public Long getPlaceBidAmount() {
        return placeBidAmount;
    }

    public void setPlaceBidAmount(Long placeBidAmount) {
        this.placeBidAmount = placeBidAmount;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public ItiMazadnaUser getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(ItiMazadnaUser supplierid) {
        this.supplierid = supplierid;
    }

    public ItiMazadnaUser getUserid() {
        return userid;
    }

    public void setUserid(ItiMazadnaUser userid) {
        this.userid = userid;
    }


    @XmlTransient
    public Set<ItiMazadnaBidderitem> getItiMazadnaBidderitemSet() {
        return itiMazadnaBidderitemSet;
    }

    public void setItiMazadnaBidderitemSet(Set<ItiMazadnaBidderitem> itiMazadnaBidderitemSet) {
        this.itiMazadnaBidderitemSet = itiMazadnaBidderitemSet;
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
        if (!(object instanceof ItiMazadnaItem)) {
            return false;
        }
        ItiMazadnaItem other = (ItiMazadnaItem) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mazadna.dal.entities.ItiMazadnaItem[ recid=" + recid + " ]";
    }
    
}
