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
@Table(name = "project_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectStatus.findAll", query = "SELECT p FROM ProjectStatus p")
    , @NamedQuery(name = "ProjectStatus.findByProjectstatusId", query = "SELECT p FROM ProjectStatus p WHERE p.projectstatusId = :projectstatusId")
    , @NamedQuery(name = "ProjectStatus.findByProjectStatusName", query = "SELECT p FROM ProjectStatus p WHERE p.projectStatusName = :projectStatusName")})
public class ProjectStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projectstatus_id")
    private Integer projectstatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "project_status_name")
    private String projectStatusName;
    @OneToMany(mappedBy = "projectstatusId")
    private Collection<Projects> projectsCollection;

    public ProjectStatus() {
    }

    public ProjectStatus(Integer projectstatusId) {
        this.projectstatusId = projectstatusId;
    }

    public ProjectStatus(Integer projectstatusId, String projectStatusName) {
        this.projectstatusId = projectstatusId;
        this.projectStatusName = projectStatusName;
    }

    public Integer getProjectstatusId() {
        return projectstatusId;
    }

    public void setProjectstatusId(Integer projectstatusId) {
        this.projectstatusId = projectstatusId;
    }

    public String getProjectStatusName() {
        return projectStatusName;
    }

    public void setProjectStatusName(String projectStatusName) {
        this.projectStatusName = projectStatusName;
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
        hash += (projectstatusId != null ? projectstatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectStatus)) {
            return false;
        }
        ProjectStatus other = (ProjectStatus) object;
        if ((this.projectstatusId == null && other.projectstatusId != null) || (this.projectstatusId != null && !this.projectstatusId.equals(other.projectstatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.janos.adios.model.ProjectStatus[ projectstatusId=" + projectstatusId + " ]";
    }
    
}
