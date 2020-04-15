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
 * @author Felhasználó
 */
@Entity
@Table(name = "funder_contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FunderContact.findAll", query = "SELECT f FROM FunderContact f")
    , @NamedQuery(name = "FunderContact.findByFundercontactId", query = "SELECT f FROM FunderContact f WHERE f.fundercontactId = :fundercontactId")
    , @NamedQuery(name = "FunderContact.findByFullNameFundcont", query = "SELECT f FROM FunderContact f WHERE f.fullNameFundcont = :fullNameFundcont")
    , @NamedQuery(name = "FunderContact.findByPhone", query = "SELECT f FROM FunderContact f WHERE f.phone = :phone")
    , @NamedQuery(name = "FunderContact.findByEmail", query = "SELECT f FROM FunderContact f WHERE f.email = :email")})
public class FunderContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fundercontact_id")
    private Integer fundercontactId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "full_name_fundcont")
    private String fullNameFundcont;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "fundercontactId")
    private Collection<Projects> projectsCollection;
    @JoinColumn(name = "funder_id", referencedColumnName = "funder_id")
    @ManyToOne
    private Funder funderId;

    public FunderContact() {
    }

    public FunderContact(Integer fundercontactId) {
        this.fundercontactId = fundercontactId;
    }

    public FunderContact(Integer fundercontactId, String fullNameFundcont) {
        this.fundercontactId = fundercontactId;
        this.fullNameFundcont = fullNameFundcont;
    }

    public Integer getFundercontactId() {
        return fundercontactId;
    }

    public void setFundercontactId(Integer fundercontactId) {
        this.fundercontactId = fundercontactId;
    }

    public String getFullNameFundcont() {
        return fullNameFundcont;
    }

    public void setFullNameFundcont(String fullNameFundcont) {
        this.fullNameFundcont = fullNameFundcont;
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
    public Collection<Projects> getProjectsCollection() {
        return projectsCollection;
    }

    public void setProjectsCollection(Collection<Projects> projectsCollection) {
        this.projectsCollection = projectsCollection;
    }

    public Funder getFunderId() {
        return funderId;
    }

    public void setFunderId(Funder funderId) {
        this.funderId = funderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fundercontactId != null ? fundercontactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunderContact)) {
            return false;
        }
        FunderContact other = (FunderContact) object;
        if ((this.fundercontactId == null && other.fundercontactId != null) || (this.fundercontactId != null && !this.fundercontactId.equals(other.fundercontactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.FunderContact[ fundercontactId=" + fundercontactId + " ]";
    }
    
}
