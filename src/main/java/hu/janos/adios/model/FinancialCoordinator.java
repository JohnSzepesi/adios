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
@Table(name = "financial_coordinator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinancialCoordinator.findAll", query = "SELECT f FROM FinancialCoordinator f")
    , @NamedQuery(name = "FinancialCoordinator.findByFinancialcoordinatorId", query = "SELECT f FROM FinancialCoordinator f WHERE f.financialcoordinatorId = :financialcoordinatorId")
    , @NamedQuery(name = "FinancialCoordinator.findByFullNameFincoord", query = "SELECT f FROM FinancialCoordinator f WHERE f.fullNameFincoord = :fullNameFincoord")
    , @NamedQuery(name = "FinancialCoordinator.findByPhone", query = "SELECT f FROM FinancialCoordinator f WHERE f.phone = :phone")
    , @NamedQuery(name = "FinancialCoordinator.findByEmail", query = "SELECT f FROM FinancialCoordinator f WHERE f.email = :email")})
public class FinancialCoordinator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "financialcoordinator_id")
    private Integer financialcoordinatorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "full_name_fincoord")
    private String fullNameFincoord;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "financialcoordinatorId")
    private Collection<Projects> projectsCollection;

    public FinancialCoordinator() {
    }

    public FinancialCoordinator(Integer financialcoordinatorId) {
        this.financialcoordinatorId = financialcoordinatorId;
    }

    public FinancialCoordinator(Integer financialcoordinatorId, String fullNameFincoord, String email) {
        this.financialcoordinatorId = financialcoordinatorId;
        this.fullNameFincoord = fullNameFincoord;
        this.email = email;
    }

    public Integer getFinancialcoordinatorId() {
        return financialcoordinatorId;
    }

    public void setFinancialcoordinatorId(Integer financialcoordinatorId) {
        this.financialcoordinatorId = financialcoordinatorId;
    }

    public String getFullNameFincoord() {
        return fullNameFincoord;
    }

    public void setFullNameFincoord(String fullNameFincoord) {
        this.fullNameFincoord = fullNameFincoord;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (financialcoordinatorId != null ? financialcoordinatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialCoordinator)) {
            return false;
        }
        FinancialCoordinator other = (FinancialCoordinator) object;
        if ((this.financialcoordinatorId == null && other.financialcoordinatorId != null) || (this.financialcoordinatorId != null && !this.financialcoordinatorId.equals(other.financialcoordinatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.FinancialCoordinator[ financialcoordinatorId=" + financialcoordinatorId + " ]";
    }
    
}
