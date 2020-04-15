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
@Table(name = "project_administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectAdministrator.findAll", query = "SELECT p FROM ProjectAdministrator p")
    , @NamedQuery(name = "ProjectAdministrator.findByProjectadministratorId", query = "SELECT p FROM ProjectAdministrator p WHERE p.projectadministratorId = :projectadministratorId")
    , @NamedQuery(name = "ProjectAdministrator.findByFullNameProadmin", query = "SELECT p FROM ProjectAdministrator p WHERE p.fullNameProadmin = :fullNameProadmin")
    , @NamedQuery(name = "ProjectAdministrator.findByMobile", query = "SELECT p FROM ProjectAdministrator p WHERE p.mobile = :mobile")
    , @NamedQuery(name = "ProjectAdministrator.findByEmail", query = "SELECT p FROM ProjectAdministrator p WHERE p.email = :email")})
public class ProjectAdministrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projectadministrator_id")
    private Integer projectadministratorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "full_name_proadmin")
    private String fullNameProadmin;
    @Size(max = 20)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "projectadministratorId")
    private Collection<Projects> projectsCollection;
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    @ManyToOne
    private Unit unitId;

    public ProjectAdministrator() {
    }

    public ProjectAdministrator(Integer projectadministratorId) {
        this.projectadministratorId = projectadministratorId;
    }

    public ProjectAdministrator(Integer projectadministratorId, String fullNameProadmin) {
        this.projectadministratorId = projectadministratorId;
        this.fullNameProadmin = fullNameProadmin;
    }

    public Integer getProjectadministratorId() {
        return projectadministratorId;
    }

    public void setProjectadministratorId(Integer projectadministratorId) {
        this.projectadministratorId = projectadministratorId;
    }

    public String getFullNameProadmin() {
        return fullNameProadmin;
    }

    public void setFullNameProadmin(String fullNameProadmin) {
        this.fullNameProadmin = fullNameProadmin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectadministratorId != null ? projectadministratorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectAdministrator)) {
            return false;
        }
        ProjectAdministrator other = (ProjectAdministrator) object;
        if ((this.projectadministratorId == null && other.projectadministratorId != null) || (this.projectadministratorId != null && !this.projectadministratorId.equals(other.projectadministratorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.ProjectAdministrator[ projectadministratorId=" + projectadministratorId + " ]";
    }
    
}
