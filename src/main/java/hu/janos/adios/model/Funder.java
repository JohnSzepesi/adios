/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.janos.adios.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Felhasználó
 */
@Entity
@Table(name = "funder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funder.findAll", query = "SELECT f FROM Funder f")
    , @NamedQuery(name = "Funder.findByFunderId", query = "SELECT f FROM Funder f WHERE f.funderId = :funderId")
    , @NamedQuery(name = "Funder.findByName", query = "SELECT f FROM Funder f WHERE f.name = :name")
    , @NamedQuery(name = "Funder.findByWebpage", query = "SELECT f FROM Funder f WHERE f.webpage = :webpage")
    , @NamedQuery(name = "Funder.findByShortName", query = "SELECT f FROM Funder f WHERE f.shortName = :shortName")
    , @NamedQuery(name = "Funder.findByPhone", query = "SELECT f FROM Funder f WHERE f.phone = :phone")
    , @NamedQuery(name = "Funder.findByEmail", query = "SELECT f FROM Funder f WHERE f.email = :email")})
public class Funder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "funder_id")
    private Integer funderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "webpage")
    private String webpage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "shortName")
    private String shortName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "funderId")
    private Collection<Tender> tenderCollection;
    @OneToMany(mappedBy = "funderId")
    private Collection<Projects> projectsCollection;
    @OneToMany(mappedBy = "funderId")
    private Collection<FunderContact> funderContactCollection;

    public Funder() {
    }

    public Funder(Integer funderId) {
        this.funderId = funderId;
    }

    public Funder(Integer funderId, String name, String webpage, String shortName, String phone, String email) {
        this.funderId = funderId;
        this.name = name;
        this.webpage = webpage;
        this.shortName = shortName;
        this.phone = phone;
        this.email = email;
    }

    public Integer getFunderId() {
        return funderId;
    }

    public void setFunderId(Integer funderId) {
        this.funderId = funderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Tender> getTenderCollection() {
        return tenderCollection;
    }

    public void setTenderCollection(Collection<Tender> tenderCollection) {
        this.tenderCollection = tenderCollection;
    }

    @XmlTransient
    public Collection<Projects> getProjectsCollection() {
        return projectsCollection;
    }

    public void setProjectsCollection(Collection<Projects> projectsCollection) {
        this.projectsCollection = projectsCollection;
    }

    @XmlTransient
    public Collection<FunderContact> getFunderContactCollection() {
        return funderContactCollection;
    }

    public void setFunderContactCollection(Collection<FunderContact> funderContactCollection) {
        this.funderContactCollection = funderContactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funderId != null ? funderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funder)) {
            return false;
        }
        Funder other = (Funder) object;
        if ((this.funderId == null && other.funderId != null) || (this.funderId != null && !this.funderId.equals(other.funderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.Funder[ funderId=" + funderId + " ]";
    }
    
}
