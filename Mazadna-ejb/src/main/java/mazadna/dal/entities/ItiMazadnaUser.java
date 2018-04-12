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
@Table(name = "ITI_MAZADNA_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItiMazadnaUser.findAll", query = "SELECT i FROM ItiMazadnaUser i")
    , @NamedQuery(name = "ItiMazadnaUser.findByRecid", query = "SELECT i FROM ItiMazadnaUser i WHERE i.recid = :recid")
    , @NamedQuery(name = "ItiMazadnaUser.findByFirstname", query = "SELECT i FROM ItiMazadnaUser i WHERE i.firstname = :firstname")
    , @NamedQuery(name = "ItiMazadnaUser.findByLastname", query = "SELECT i FROM ItiMazadnaUser i WHERE i.lastname = :lastname")
    , @NamedQuery(name = "ItiMazadnaUser.findByEmail", query = "SELECT i FROM ItiMazadnaUser i WHERE i.email = :email")
    , @NamedQuery(name = "ItiMazadnaUser.findByPassword", query = "SELECT i FROM ItiMazadnaUser i WHERE i.password = :password")
    , @NamedQuery(name = "ItiMazadnaUser.findByCreditlimit", query = "SELECT i FROM ItiMazadnaUser i WHERE i.creditlimit = :creditlimit")
    , @NamedQuery(name = "ItiMazadnaUser.findByCountry", query = "SELECT i FROM ItiMazadnaUser i WHERE i.country = :country")
    , @NamedQuery(name = "ItiMazadnaUser.findByCity", query = "SELECT i FROM ItiMazadnaUser i WHERE i.city = :city")
    , @NamedQuery(name = "ItiMazadnaUser.findByRole", query = "SELECT i FROM ItiMazadnaUser i WHERE i.role = :role")
    , @NamedQuery(name = "ItiMazadnaUser.findByBirthdate", query = "SELECT i FROM ItiMazadnaUser i WHERE i.birthdate = :birthdate")
    , @NamedQuery(name = "ItiMazadnaUser.findByCreationdate", query = "SELECT i FROM ItiMazadnaUser i WHERE i.creationdate = :creationdate")})
public class ItiMazadnaUser implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECID")
    private Long recid;
    @Size(max = 25)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 25)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 75)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 50)
    @Column(name = "CREDITLIMIT")
    private String creditlimit;
    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 30)
    @Column(name = "CITY")
    private String city;
    @Column(name = "ROLE")
    private Long role;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @OneToMany(mappedBy = "supplierid")
    private Set<ItiMazadnaItem> itiMazadnaItemSet;
    @OneToMany(mappedBy = "userid")
    private Set<ItiMazadnaItem> itiMazadnaItemSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itiMazadnaUser")
    private Set<ItiMazadnaBidderitem> itiMazadnaBidderitemSet;

    public ItiMazadnaUser() {
    }

    public ItiMazadnaUser(Long recid) {
        this.recid = recid;
    }

    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(String creditlimit) {
        this.creditlimit = creditlimit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    @XmlTransient
    public Set<ItiMazadnaItem> getItiMazadnaItemSet() {
        return itiMazadnaItemSet;
    }

    public void setItiMazadnaItemSet(Set<ItiMazadnaItem> itiMazadnaItemSet) {
        this.itiMazadnaItemSet = itiMazadnaItemSet;
    }

    @XmlTransient
    public Set<ItiMazadnaItem> getItiMazadnaItemSet1() {
        return itiMazadnaItemSet1;
    }

    public void setItiMazadnaItemSet1(Set<ItiMazadnaItem> itiMazadnaItemSet1) {
        this.itiMazadnaItemSet1 = itiMazadnaItemSet1;
    }

    @XmlTransient
    public Set<ItiMazadnaBidderitem> getItiMazadnaBidderitemSet() {
        return itiMazadnaBidderitemSet;
    }

    public void setItiMazadnaBidderitemSet(Set<ItiMazadnaBidderitem> itiMazadnaBidderitemSet) {
        this.itiMazadnaBidderitemSet = itiMazadnaBidderitemSet;
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
        if (!(object instanceof ItiMazadnaUser)) {
            return false;
        }
        ItiMazadnaUser other = (ItiMazadnaUser) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mazadna.dal.entities.ItiMazadnaUser[ recid=" + recid + " ]";
    }
    
}
