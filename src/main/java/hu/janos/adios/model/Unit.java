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
@Table(name = "unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
    , @NamedQuery(name = "Unit.findByUnitId", query = "SELECT u FROM Unit u WHERE u.unitId = :unitId")
    , @NamedQuery(name = "Unit.findByUnitName", query = "SELECT u FROM Unit u WHERE u.unitName = :unitName")
    , @NamedQuery(name = "Unit.findByUnitShortName", query = "SELECT u FROM Unit u WHERE u.unitShortName = :unitShortName")})
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unit_id")
    private Integer unitId;
    @Size(max = 125)
    @Column(name = "unit_name")
    private String unitName;
    @Size(max = 30)
    @Column(name = "unit_short_name")
    private String unitShortName;
    @OneToMany(mappedBy = "unitId")
    private Collection<Projects> projectsCollection;
    @OneToMany(mappedBy = "unitId")
    private Collection<ProjectAdministrator> projectAdministratorCollection;

    public Unit() {
    }

    public Unit(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitShortName() {
        return unitShortName;
    }

    public void setUnitShortName(String unitShortName) {
        this.unitShortName = unitShortName;
    }

    @XmlTransient
    public Collection<Projects> getProjectsCollection() {
        return projectsCollection;
    }

    public void setProjectsCollection(Collection<Projects> projectsCollection) {
        this.projectsCollection = projectsCollection;
    }

    @XmlTransient
    public Collection<ProjectAdministrator> getProjectAdministratorCollection() {
        return projectAdministratorCollection;
    }

    public void setProjectAdministratorCollection(Collection<ProjectAdministrator> projectAdministratorCollection) {
        this.projectAdministratorCollection = projectAdministratorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitId != null ? unitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.unitId == null && other.unitId != null) || (this.unitId != null && !this.unitId.equals(other.unitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.Unit[ unitId=" + unitId + " ]";
    }
    
}
