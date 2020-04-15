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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felhasználó
 */
@Entity
@Table(name = "financial_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinancialStatus.findAll", query = "SELECT f FROM FinancialStatus f")
    , @NamedQuery(name = "FinancialStatus.findByFinancialstatusId", query = "SELECT f FROM FinancialStatus f WHERE f.financialstatusId = :financialstatusId")
    , @NamedQuery(name = "FinancialStatus.findByFinancialStatusName", query = "SELECT f FROM FinancialStatus f WHERE f.financialStatusName = :financialStatusName")})
public class FinancialStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "financialstatus_id")
    private Integer financialstatusId;
    @Size(max = 45)
    @Column(name = "financial_status_name")
    private String financialStatusName;
    @OneToMany(mappedBy = "financialstatusId")
    private Collection<Projects> projectsCollection;

    public FinancialStatus() {
    }

    public FinancialStatus(Integer financialstatusId) {
        this.financialstatusId = financialstatusId;
    }

    public Integer getFinancialstatusId() {
        return financialstatusId;
    }

    public void setFinancialstatusId(Integer financialstatusId) {
        this.financialstatusId = financialstatusId;
    }

    public String getFinancialStatusName() {
        return financialStatusName;
    }

    public void setFinancialStatusName(String financialStatusName) {
        this.financialStatusName = financialStatusName;
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
        hash += (financialstatusId != null ? financialstatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialStatus)) {
            return false;
        }
        FinancialStatus other = (FinancialStatus) object;
        if ((this.financialstatusId == null && other.financialstatusId != null) || (this.financialstatusId != null && !this.financialstatusId.equals(other.financialstatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.FinancialStatus[ financialstatusId=" + financialstatusId + " ]";
    }
    
}
